package com.fireforged.legend.client.api;

import java.security.*;
import java.util.UUID;

import com.fireforged.legend.client.api.connections.ConnectionHandlerThread;
import com.fireforged.legend.protocols.replies.*;
import com.fireforged.legend.protocols.requests.*;
import com.fireforged.legend.protocols.requests.RequestContainer.RequestTypeEnum;

/***************************************************************************************************
 * 
 * Name: ClientAPI
 * 
 * Description: The ClientAPI class is a collection of common methods for communicating with
 * the Legend server.
 * 
 * @author Chris Rhodes
 * 
 **************************************************************************************************/
public class ClientAPI {

	private static UUID _sessionID = null;
	private static ConnectionHandlerThread _connection;
	
	/***********************************************************************************************
	 * 
	 * Name: ClientAPI
	 * 
	 * Description: Constructor
	 * 
	 **********************************************************************************************/
	public ClientAPI(String host, int port) throws Exception {
		super();

		try {
			// ===================
			// Open TCP COnnection
			// ===================
	
			_connection = new ConnectionHandlerThread(host, port);
			
		} catch (Exception e) {
			throw e;
		}
		
	}
	
	/***********************************************************************************************
	 * 
	 * Name: login
	 * 
	 * Description: Attempts to log in to a server with the specified account name and password.
	 * 
	 * @param accountName The account name to log in with.
	 * @param password The password matching the account name.
	 * 
	 * @return Boolean Indicates whether or not the login was successful.
	 * 
	 **********************************************************************************************/
	public Boolean login(String accountName, String password) 
		throws Exception {
		
		try {
			
			// ================
			// Encrypt Password
			// ================

			// TODO - Replace with stronger encryption scheme. This is pretty weak.
			byte[] bytePassword = password.getBytes("UTF-8");	
			MessageDigest digest = MessageDigest.getInstance("MD5");
			byte[] passwordHash = digest.digest(bytePassword);
			
			// ================
			// Retrieve Session
			// ================
						
			SessionReply session = (SessionReply) _connection.sendSynchronous(
				new RequestContainer(RequestTypeEnum.LOGIN, 
					new LoginRequest(accountName, passwordHash))).getReplyObject();
			
			if((session != null) && session.getErrorMessage() == null) {
				_sessionID = session.getSessionID();
				return true;				
			} else {
				return false;
			}
			
		} catch (Exception e) {
			throw e;
		}
	}
	
	/***********************************************************************************************
	 * 
	 * Name: retrieveCharacters
	 * 
	 * Description: Retrieves characters associated with an account.  Must have previously obtained
	 * a valid Session by calling login.
	 * 
	 * @return String[] The names of all characters for the given account.
	 * 
	 **********************************************************************************************/
	public String[] retrieveCharacters() throws Exception {
		
		try {
						
			CharacterListReply list = (CharacterListReply) _connection.sendSynchronous(
				new RequestContainer(RequestTypeEnum.RETRIEVE_CHARACTERS, 
					new CharacterDataRequest(_sessionID))).getReplyObject();
			
			if((list != null) && list.getErrorMessage() == null) {								
				return list.getCharacters();				
			} else {
				return null;
			}
			
		} catch (Exception e) {
			throw e;
		}
	}
	
}
