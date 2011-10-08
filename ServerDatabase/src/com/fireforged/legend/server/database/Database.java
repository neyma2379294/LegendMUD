package com.fireforged.legend.server.database;

import java.util.HashMap;

/***************************************************************************************************
 * 
 * Name: Database
 * 
 * Description: Handles storing and retrieving data from the database.  This layer should not 
 * require as input nor provide as output any protocol-level objects.  It should also not have
 * any code that validates that a particular user is authorized.  Both of these activities should
 * be performed by the server layer.
 * 
 * @author Chris Rhodes
 * 
 **************************************************************************************************/
public class Database {

	// TODO - Replace with actual database.
	private HashMap<String, String[]> _accountCharacterMap = 
		new HashMap<String, String[]>();

	private static Database _instance = new Database();
	
	/***********************************************************************************************
	 * 
	 * Name: Database
	 * 
	 * Description: Constructor
	 * 
	 **********************************************************************************************/
	public Database() {
		
		String[] characters = {"Saro", "Deren"}; 
		_accountCharacterMap.put("Chris", characters);
		_accountCharacterMap.put("Bob", new String[0]);
		
	}
	
	/***********************************************************************************************
	 * 
	 * Name: validateAccount
	 * 
	 * Description: Returns a boolean indicating whether or not the given account and password 
	 * exist the database.
	 * 
	 **********************************************************************************************/
	public static Boolean validateAccount(String accountName, String passwordHash) {
		
		// TODO - Replace with actual database calls.
		if (_instance._accountCharacterMap.containsKey(accountName)) {
			return true;			
		}
		else {
			return false;
		}
		
	}
	
	/***********************************************************************************************
	 * 
	 * Name: getAccountCharacters
	 * 
	 * Description: Returns a list of characters associated with an account.  If no characters are
	 * found, an empty array is returned.  If the account does not exist, a null is returned.
	 * 
	 **********************************************************************************************/
	public static String[] getAccountCharacters(String accountName) {
		
		// TODO - Replace with actual database calls.
		return _instance._accountCharacterMap.get(accountName);
		
	}
	
}
