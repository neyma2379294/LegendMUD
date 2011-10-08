package com.fireforged.legend.client.api.event;

import java.util.EventObject;

import com.fireforged.legend.protocols.replies.SessionReply;

/***************************************************************************************************
 * 
 * Name: SessionReplyEvent
 * 
 * Description: This event indicates that a SessionReply has been received from the server.
 * 
 * @author Chris Rhodes
 * 
 **************************************************************************************************/
public class SessionReplyEvent extends EventObject {

	private static final long serialVersionUID = 4978515296625620210L;

	private SessionReply _session;
	
	/***********************************************************************************************
	 * 
	 * Name: SessionReplyEvent
	 * 
	 * Description: Constructor.
	 * 
	 * @param source The source of the event.
	 * @param session The session returned from the server.
	 *  
	 **********************************************************************************************/
	public SessionReplyEvent(Object source, SessionReply session) {
		super(source);
		
		_session = session;
	}
	
	/***********************************************************************************************
	 * 
	 * Name: getSessionReply
	 * 
	 * Description: Returns the session reply.
	 * 
	 * @return SessionReply The session reply returned from the server.
	 * 
	 **********************************************************************************************/
	public SessionReply getSessionReply() {
		return _session;
	}

}
