package com.fireforged.legend.client;

import com.fireforged.legend.client.api.ClientAPI;

/***************************************************************************************************
 * 
 * Name: ReferenceClientText
 * 
 * Description: A reference implementation of a client that can connect to a Legend server.
 * 
 * @author Chris Rhodes
 * 
 **************************************************************************************************/
public class ReferenceClientText {

	/***********************************************************************************************
	 * 
	 * Name: main
	 * 
	 * Description: Gathers the user's information and attempts to connect to a Legend server.
	 * 
	 **********************************************************************************************/
	public static void main(String[] args) {
		
		try {

			// ==================
			// Read Property File
			// ==================

			// TODO - Replace with property file.
			String hostname = "localhost";
			int portnumber = 1123;
			
			// Front text.
			System.out.println("-= Legend, MUD System =-");
			System.out.println("Client: Reference, 1.0");
			System.out.println("Host: " + hostname + ":" + portnumber);
			
			// =========================
			// Query User for Login Info
			// =========================
			
			String accountName = null;
			do {
				System.out.print("Login: ");				
			} while((accountName = System.console().readLine()).equals(""));
			
			char[] password = null;
			do {
				System.out.print("Password: ");					
			} while((password = System.console().readPassword()).equals(""));

			// ==================
			// Attempt Connection
			// ==================
			
			ClientAPI client = new ClientAPI(hostname, portnumber); 

			// =============
			// Attempt Login
			// =============
			
			System.out.print("Logging in as " + accountName + " . . . ");
						
			if (client.login(accountName, password.toString())) {
				System.out.println("success!");
			} else {
				System.out.println("failure!");
			}
			
			// ===================
			// Retrieve Characters
			// ===================
			
			System.out.print("Retrieving characters . . . ");
			String[] characters = client.retrieveCharacters(); 
			if (characters != null) {
				System.out.println("success!");
				
				if (characters.length == 0) {
					System.out.println("No characters attached to this account.");
				} else {
					System.out.println("Characters found:");
					for (String character : characters) {
						System.out.println(character);
					}
				}
				
			} else {
				System.out.println("failure!");
			}
			
			int temp = System.in.read();
						
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
