package com.fireforged.legend.protocols.requests;

import java.io.Serializable;
import java.util.UUID;

/***************************************************************************************************
 * 
 * Name: CharacterDataRequestObject
 * 
 * Description: Requests character data associated with an account.
 * 
 * @author Chris Rhodes
 * 
 **************************************************************************************************/
public class CharacterDataRequest implements Serializable {

	private static final long serialVersionUID = 4506083799720021477L;

	private UUID _sessionID;
	
	/***********************************************************************************************
	 * 
	 * Name: CharacterDataRequestObject
	 * 
	 * Description: Constructor.
	 * 
	 * @param sessionID The ID returned from the server for this session.
	 * 
	 **********************************************************************************************/
	public CharacterDataRequest(UUID sessionID) {
		_sessionID = sessionID;
	}
	
	/***********************************************************************************************
	 * 
	 * Name: getSessionID
	 * 
	 * Description: Returns the session ID.
	 * 
	 * @return UUID The session ID.
	 * 
	 **********************************************************************************************/
	public UUID getSessionID() {
		return _sessionID;
	}
	
}
