package com.fireforged.legend.client.api.event;

import java.util.EventObject;

import com.fireforged.legend.protocols.replies.CharacterListReply;

/***************************************************************************************************
 * 
 * Name: CharacterListReplyEvent
 * 
 * Description: This event indicates that a CharacterListReply has been received from the server.
 * 
 * @author Chris Rhodes
 * 
 **************************************************************************************************/
public class CharacterListReplyEvent extends EventObject {

	private static final long serialVersionUID = -6596190909453530269L;

	private CharacterListReply _characterList;
	
	/***********************************************************************************************
	 * 
	 * Name: CharacterListReplyEvent
	 * 
	 * Description: Constructor.
	 * 
	 * @param source The source of the event.
	 * @param characterList The character list returned from the server.
	 *  
	 **********************************************************************************************/
	public CharacterListReplyEvent(Object source, CharacterListReply characterList) {
		super(source);
		
		_characterList = characterList;
	}
	
	/***********************************************************************************************
	 * 
	 * Name: getCharacterList
	 * 
	 * Description: Returns the session reply.
	 * 
	 * @return CharacterListReply The character list reply returned from the server.
	 * 
	 **********************************************************************************************/
	public CharacterListReply getCharacterList() {
		return _characterList;
	}

}
