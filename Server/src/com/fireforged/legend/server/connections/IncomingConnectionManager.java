package com.fireforged.legend.server.connections;

import java.net.ServerSocket;


/***************************************************************************************************
 * 
 * Name: Connection
 * 
 * Description: Handles receiving connections to the server.
 * 
 * @author Chris Rhodes
 * 
 **************************************************************************************************/
public class IncomingConnectionManager {
	
	/***********************************************************************************************
	 * 
	 * Name: connect
	 * 
	 * Description: Waits for an incoming connection.
	 * 
	 **********************************************************************************************/
	public static void connect(int port) 
		throws Exception {
		
		try {
						
	        ServerSocket serverSocket = null;
	        boolean listening = true;

	        try {
	            serverSocket = new ServerSocket(port);
	        } catch (Exception e) {
	        	e.printStackTrace();
	            System.exit(-1);
	        }

			// ===============
			// Begin Listening
			// ===============

	        while (listening)
	        	new ConnectionHandlerThread(serverSocket.accept(), true).start();

	        serverSocket.close();
			
		} catch (Exception e) {
			throw e;
		}
		
	}
	
}
