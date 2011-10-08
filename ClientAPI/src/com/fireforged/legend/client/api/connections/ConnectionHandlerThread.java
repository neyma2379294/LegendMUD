package com.fireforged.legend.client.api.connections;

import java.io.*;
import java.net.*;
import java.util.concurrent.locks.*;

import com.fireforged.legend.client.api.event.CharacterListReplyEvent;
import com.fireforged.legend.client.api.event.EventDistribution;
import com.fireforged.legend.client.api.event.SessionReplyEvent;
import com.fireforged.legend.protocols.replies.*;
import com.fireforged.legend.protocols.requests.*;

/***************************************************************************************************
 * 
 * Name: ConnectionHandler
 * 
 * Description: Handles sending and receiving data to and from the server.
 * 
 * @author Chris Rhodes
 * 
 **************************************************************************************************/
public class ConnectionHandlerThread extends Thread {

	private Socket _clientSocket = null;	
	private ObjectOutputStream _outStream = null;
	private ObjectInputStream _inStream = null;	
	ReentrantLock synchLock = new ReentrantLock();
	
	/***********************************************************************************************
	 * 
	 * Name: ClientAPI
	 * 
	 * Description: Constructor
	 * 
	 **********************************************************************************************/
	public ConnectionHandlerThread(String host, int port) throws Exception {
		super();

		try {
			// ===================
			// Open TCP COnnection
			// ===================
	
			_clientSocket = new Socket(host, port);
			
			_outStream = new ObjectOutputStream(_clientSocket.getOutputStream());
			_inStream = new ObjectInputStream(_clientSocket.getInputStream());
			
		} catch (Exception e) {
			throw e;
		}
		
	}
	
	/***********************************************************************************************
	 * 
	 * Name: send
	 * 
	 * Description: Attempts to send the given request.
	 * 
	 * @param request The request to send.
	 * 
	 **********************************************************************************************/
	public void send(RequestContainer request) 
		throws Exception {
		
		try {
			
			_outStream.writeObject(request);
			
		} catch (Exception e) {
			throw e;
		}
	}
	
	/***********************************************************************************************
	 * 
	 * Name: sendSynchronous
	 * 
	 * Description: Attempts to send the given request and wait for a response.  This method may
	 * only be called while the thread has not yet been started, otherwise an exception is thrown.
	 * Useful for startup before data is expected to be streamed both ways.
	 * 
	 * @param request The request to send.
	 * 
	 * @return ReplyContainer The reply returned from the server.
	 * 
	 **********************************************************************************************/
	public ReplyContainer sendSynchronous(RequestContainer request) 
		throws Exception {
		
		if (!synchLock.tryLock()) 
			throw new Exception("Error: Thread started. This method cannot be used.");
		
		try {
			
			_outStream.writeObject(request);			
			return  (ReplyContainer) _inStream.readObject();
			
		} catch (Exception e) {
			throw e;
		}		
		
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
    	
    	// The connection may no longer send synchronously.
    	synchLock.lock();
    	
    	boolean exit = false;
    	
		while (exit == false) {

	    	try {

				ReplyContainer request = ((ReplyContainer) _inStream.readObject());
				
				switch(request.getRequestType()) {
					case SESSION:
						EventDistribution.publishEvent(
							request.getRequestType(), 
							new SessionReplyEvent(null, (SessionReply) request.getReplyObject()));
					case CHARACTER_LIST:
						EventDistribution.publishEvent(
							request.getRequestType(), 
							new CharacterListReplyEvent(null, (CharacterListReply) request.getReplyObject()));
						
				}
				
	    	} catch (Exception e) {
				e.printStackTrace();
			}

		}
		
		synchLock.unlock();
		
    }
	
}
