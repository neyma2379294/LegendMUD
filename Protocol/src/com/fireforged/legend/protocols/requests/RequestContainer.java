package com.fireforged.legend.protocols.requests;

import java.io.Serializable;

/***************************************************************************************************
 * 
 * Name: Request
 * 
 * Description: A command from a client to the server.  Use of this request requires the user to 
 * have logged in first.
 * 
 * @author Chris Rhodes
 * 
 **************************************************************************************************/
public class RequestContainer implements Serializable {

	private static final long serialVersionUID = 3850980272525711715L;
		
	private RequestTypeEnum _requestType;
	private Object _requestObject;
	
	/***********************************************************************************************
	 * 
	 * Name: Command
	 * 
	 * Description: Constructor.
	 * 
	 * @param message The message to send to the server.
	 * 
	 **********************************************************************************************/
	public RequestContainer(RequestTypeEnum requestType, Object requestObject) {
		_requestType = requestType;
		_requestObject = requestObject;
	}
	
	/***********************************************************************************************
	 * 
	 * Name: getRequestType
	 * 
	 * Description: Returns the request type.
	 * 
	 * @return RequestEnum The request type.
	 * 
	 **********************************************************************************************/
	public RequestTypeEnum getRequestType() {
		return _requestType;
	}
	
	/***********************************************************************************************
	 * 
	 * Name: getRequestObject
	 * 
	 * Description: Returns the object associated with the request.
	 * 
	 * @return Object The object associated with the request.
	 * 
	 **********************************************************************************************/
	public Object getRequestObject() {
		return _requestObject;
	}
	
	public enum RequestTypeEnum {
		LOGIN,
		RETRIEVE_CHARACTERS
	}
	
}
