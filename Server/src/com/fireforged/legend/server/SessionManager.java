package com.fireforged.legend.server;

import java.util.HashMap;
import java.util.UUID;

/***************************************************************************************************
 * 
 * Name: SessionManager
 * 
 * Description: Manages a collection of user sessions.
 * 
 * @author Chris Rhodes
 * 
 **************************************************************************************************/
public class SessionManager {

	HashMap<String, UUID> _accountSessionMap = new HashMap<String, UUID>(); 
	HashMap<UUID, String> _sessionAccountMap = new HashMap<UUID, String>(); 
	
	private static SessionManager _instance = new SessionManager();
	
	/***********************************************************************************************
	 * 
	 * Name: SessionManager
	 * 
	 * Description: Constructor
	 * 
	 **********************************************************************************************/
	private SessionManager() { 				
	}
		
	/***********************************************************************************************
	 * 
	 * Name: storeSession
	 * 
	 * Description: Stores a session in the manager.
	 * 
	 **********************************************************************************************/
	public static void storeSession(String accountName, UUID sessionID) {
		_instance._accountSessionMap.put(accountName, sessionID);
		_instance._sessionAccountMap.put(sessionID, accountName);
	}
	
	/***********************************************************************************************
	 * 
	 * Name: retrieveSession
	 * 
	 * Description: Returns an open session for a given account name.  This method would, for 
	 * example, allows a user to reconnect to their previous session after having their connection 
	 * drop.  Note: The session manager does not validate that the request is from an authorized
	 * user of the account in question.  To prevent session hijacking, the user's password should
	 * be validated against their account name before attempting to retrieve a session by name.
	 * 
	 * @param accountName The account name to find a session ID for.
	 * 
	 * @return UUID The session ID associated with the account.
	 * 
	 **********************************************************************************************/
	public static UUID retrieveSession(String accountName) {
		return  _instance._accountSessionMap.get(accountName);				
	}

	/***********************************************************************************************
	 * 
	 * Name: retrieveAccount
	 * 
	 * Description: Returns an account name for the given session ID.
	 * 
	 * @param sessionID The session ID to find an account name for.
	 * 
	 * @return String The account name associated with the given session ID.
	 * 
	 **********************************************************************************************/
	public static String retrieveAccount(UUID sessionID) {
		return  _instance._sessionAccountMap.get(sessionID);				
	}

}
