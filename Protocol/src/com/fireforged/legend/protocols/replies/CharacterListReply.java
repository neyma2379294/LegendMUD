
package com.fireforged.legend.protocols.replies;

import java.io.Serializable;

/***************************************************************************************************
 * 
 * Name: CharacterListReply
 * 
 * Description: Returns a list of characters associated with an account.
 * 
 * @author Chris Rhodes
 * 
 **************************************************************************************************/
public class CharacterListReply extends Reply implements Serializable {

	private static final long serialVersionUID = 3969890026470368901L;

	private String[] _characters;
	
	/***********************************************************************************************
	 * 
	 * Name: CharacterListReply
	 * 
	 * Description: Constructor.
	 * 
	 * @param characters An array of character names associated with an account.
	 * 
	 **********************************************************************************************/
	public CharacterListReply(String[] characters) {
		_characters = characters;
	}
	
	/***********************************************************************************************
	 * 
	 * Name: CharacterList
	 * 
	 * Description: Constructor.
	 * 
	 * @param errorMessage The error message.
	 * 
	 **********************************************************************************************/
	public CharacterListReply(String errorMessage) {
		super(errorMessage);
	}
	
	/***********************************************************************************************
	 * 
	 * Name: getCharacters
	 * 
	 * Description: Returns the list of character names.
	 * 
	 * @return String[] The list of character names.
	 * 
	 **********************************************************************************************/
	public String[] getCharacters() {
		return _characters;
	}

}
