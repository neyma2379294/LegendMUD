package com.fireforged.legend.server.connections;

import java.io.*;
import java.net.*;
import java.util.UUID;

import com.fireforged.legend.protocols.replies.*;
import com.fireforged.legend.protocols.replies.ReplyContainer.ReplyTypeEnum;
import com.fireforged.legend.protocols.requests.*;
import com.fireforged.legend.server.SessionManager;
import com.fireforged.legend.server.database.Database;

/***************************************************************************************************
 * 
 * Name: ConnectionHandlerThread
 * 
 * Description: Handles messages and response to a single client connected to the server.
 * 
 * @author Chris Rhodes
 * 
 **************************************************************************************************/
public class ConnectionHandlerThread extends Thread {
	
    private Socket _socket = null;
    private boolean _verbose = false;
    
	/***********************************************************************************************
	 * 
	 * Name: ConnectionHandlerThread
	 * 
	 * Description: Constructor.
	 * 
	 * @param socket The socket to listen for messages on.  
	 * @param verbose Whether or not to output verbose logs to the console.
	 * 
	 **********************************************************************************************/
    public ConnectionHandlerThread(Socket socket, boolean verbose) {
    	super();
    	
    	_socket = socket;
    	_verbose = verbose;
    	
    }

	/***********************************************************************************************
	 * 
	 * Name: run
	 * 
	 * Description: Starts the thread running, which simply listens to the given socket for 
	 * incoming messages.
	 * 
	 **********************************************************************************************/
    public void run() {

    	boolean exit = false;
    	
    	try {

			ObjectInputStream  inStream = new ObjectInputStream(_socket.getInputStream());
			ObjectOutputStream  outStream = new ObjectOutputStream(_socket.getOutputStream());

    		while (exit == false) {
    		
				RequestContainer request = ((RequestContainer) inStream.readObject());
				
				switch(request.getRequestType()) {
				
					case LOGIN:
						
						LoginRequest login = (LoginRequest) request.getRequestObject();
						
						// TODO - Replace static string with lookup for localization.
						if (_verbose) System.out.println("LOGIN: AccountName = " + login.getAccountName());
						
						// Consult the database to see if the account and password combo are valid.
						if(Database.validateAccount(login.getAccountName(), login.getPasswordHash().toString())) {
							
							// Check to see if an open session for this account still exists.
							UUID sessionID = SessionManager.retrieveSession(login.getAccountName());
							
							// If no session exists, create one and store it in the manager.
							if (sessionID == null) {
								sessionID = UUID.randomUUID();
								SessionManager.storeSession(login.getAccountName(), sessionID);								
							}
							
							outStream.writeObject(new ReplyContainer(ReplyTypeEnum.SESSION, new SessionReply(sessionID)));
							
						} else {
							
							// TODO - Replace static string with lookup for localization.
							// If no account exists, return an error message.						
							outStream.writeObject(new ReplyContainer(ReplyTypeEnum.SESSION, new SessionReply("Error: The account or password is invalid.")));
						}
						break;
						
					case RETRIEVE_CHARACTERS:

						CharacterDataRequest characterRequest = 
							(CharacterDataRequest) request.getRequestObject();

						// TODO - Replace static string with lookup for localization.
						if (_verbose) System.out.println("RETRIEVE_CHARS: Session ID = " + 
							characterRequest.getSessionID());

						// Attempt to retrieve an account name for this session.
						String accountName = 
							SessionManager.retrieveAccount(characterRequest.getSessionID());

						// If an account name was found:
						if (accountName != null) {

							// Send back a list of all characters for the account.
							outStream.writeObject(
								new ReplyContainer(
									ReplyTypeEnum.CHARACTER_LIST, 
									new CharacterListReply(Database.getAccountCharacters(accountName))));
							
						} else {

							// TODO - Replace static string with lookup for localization.
							// If no account exists, return an error message.						
							outStream.writeObject(
								new ReplyContainer(
									ReplyTypeEnum.CHARACTER_LIST, 
									new CharacterListReply("Error: The session ID is invalid.")));
						}
						break;
					default:
						inStream.close();
						outStream.close();
					    _socket.close();

						throw new Exception("Unrecognized command type.");
													
				}			
			    
    		}
		
    	} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    class ServerOutputStream extends ObjectOutputStream {

		public ServerOutputStream(OutputStream out) throws IOException {
			super(out);
		}
		
		public void send(ReplyContainer reply) {
			try {
				this.writeObject(reply);
			} catch (Exception e) {
				
			}
		}
    	
    }
    
}