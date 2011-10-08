package com.fireforged.legend.server;

import com.fireforged.legend.server.connections.IncomingConnectionManager;

/***************************************************************************************************
 * 
 * Name: Connection
 * 
 * Description: Handles receiving connections to the server.
 * 
 * @author Chris Rhodes
 * 
 **************************************************************************************************/
public class Main {

	/***********************************************************************************************
	 * 
	 * Name: main
	 * 
	 * Description: Starts other server threads.
	 * 
	 **********************************************************************************************/
	public static void main(String[] args) {

		try {
			
			int portnumber = 1123;
			
			// Front text.
			System.out.println("-= Legend, MUD System =-");
			System.out.println("Server: Reference, 1.0");
			System.out.println("Port: " + portnumber);
			
			IncomingConnectionManager.connect(portnumber);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
