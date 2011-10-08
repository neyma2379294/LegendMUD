
package com.fireforged.legend.protocols.replies;

import java.io.Serializable;
import java.util.UUID;

/***************************************************************************************************
 * 
 * Name: Session
 * 
 * Description: A Session is what the client uses to authenticate itself when issuing commands.  
 * A client receives a Session instance after successfully connecting with the server.
 * 
 * @author Chris Rhodes
 * 
 **************************************************************************************************/
public class SessionReply extends Reply implements Serializable {

	private static final long serialVersionUID = 3969890026470368901L;

	private UUID _sessionID;
	
	/***********************************************************************************************
	 * 
	 * Name: Session
	 * 
	 * Description: Constructor.
	 * 
	 * @param sessionID The unique ID of this session.
	 * 
	 **********************************************************************************************/
	public SessionReply(UUID sessionID) {
		super();
		_sessionID = sessionID;
	}
	
	/***********************************************************************************************
	 * 
	 * Name: Session
	 * 
	 * Description: Constructor.
	 * 
	 * @param errorMessage The error message.
	 * 
	 **********************************************************************************************/
	public SessionReply(String errorMessage) {
		super(errorMessage);
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
