package com.fireforged.legend.protocols.replies;

import java.io.Serializable;

/***************************************************************************************************
 * 
 * Name: ReplyContainer
 * 
 * Description: Contains a reply from the server to the client.
 * 
 * @author Chris Rhodes
 * 
 **************************************************************************************************/
public class ReplyContainer implements Serializable {

	private static final long serialVersionUID = 3850980272525711715L;
		
	private ReplyTypeEnum _replyType;
	private Object _replyObject;
	
	/***********************************************************************************************
	 * 
	 * Name: ReplyContainer
	 * 
	 * Description: Constructor.
	 * 
	 * @param message The message to send to the server.
	 * 
	 **********************************************************************************************/
	public ReplyContainer(ReplyTypeEnum replyType, Object replyObject) {
		_replyType = replyType;
		_replyObject = replyObject;
	}
	
	/***********************************************************************************************
	 * 
	 * Name: getReplyType
	 * 
	 * Description: Returns the reply type.
	 * 
	 * @return RequestEnum The reply type.
	 * 
	 **********************************************************************************************/
	public ReplyTypeEnum getRequestType() {
		return _replyType;
	}
	
	/***********************************************************************************************
	 * 
	 * Name: getReplyObject
	 * 
	 * Description: Returns the object associated with the request.
	 * 
	 * @return Object The object associated with the request.
	 * 
	 **********************************************************************************************/
	public Object getReplyObject() {
		return _replyObject;
	}
	
	public enum ReplyTypeEnum {
		SESSION,
		CHARACTER_LIST
	}
	
}
