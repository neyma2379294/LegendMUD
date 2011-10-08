
package com.fireforged.legend.protocols.replies;

import java.io.Serializable;

/***************************************************************************************************
 * 
 * Name: Reply
 * 
 * Description: Returns an error message to the client.
 * 
 * @author Chris Rhodes
 * 
 **************************************************************************************************/
public abstract class Reply implements Serializable {

	private static final long serialVersionUID = -8760586722331968458L;

	private String _errorMessage = null;
	
	/***********************************************************************************************
	 * 
	 * Name: ErrorReply
	 * 
	 * Description: Constructor.
	 * 
	 **********************************************************************************************/
	public Reply() {
	}

	/***********************************************************************************************
	 * 
	 * Name: ErrorReply
	 * 
	 * Description: Constructor.
	 * 
	 * @param errorMessage The error message to display to the client.
	 * 
	 **********************************************************************************************/
	public Reply(String errorMessage) {
		_errorMessage = errorMessage;
	}
	
	/***********************************************************************************************
	 * 
	 * Name: getErrorMessage
	 * 
	 * Description: Returns the error message.
	 * 
	 * @return String The error message.
	 * 
	 **********************************************************************************************/
	public String getErrorMessage() {
		return _errorMessage;
	}
	
	/***********************************************************************************************
	 * 
	 * Name: setErrorMessage
	 * 
	 * Description: Sets the error message.
	 * 
	 * @param errorMessage The error message.
	 * 
	 **********************************************************************************************/
	public void setErrorMessage(String errorMessage) {
		_errorMessage = errorMessage;
	}
		
}
