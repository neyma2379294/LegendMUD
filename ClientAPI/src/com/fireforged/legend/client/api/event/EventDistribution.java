package com.fireforged.legend.client.api.event;

import java.util.ArrayList;
import java.util.EventObject;
import java.util.HashMap;

import com.fireforged.legend.protocols.replies.ReplyContainer.ReplyTypeEnum;

/***************************************************************************************************
 * 
 * Name: EventDistribution
 * 
 * Description: Registers listeners and distributes events.
 * 
 * @author Chris Rhodes
 * 
 **************************************************************************************************/
public class EventDistribution {
	
	private static EventDistribution _instance = new EventDistribution();
	
	HashMap<ReplyTypeEnum, ArrayList<ReplyEventListener>> _listenerMap = 
		new HashMap<ReplyTypeEnum, ArrayList<ReplyEventListener>>();
	
	/***********************************************************************************************
	 * 
	 * Name: EventDistribution
	 * 
	 * Description: Constructor.
	 * 
	 **********************************************************************************************/
	private EventDistribution() {
		
		// Initialize an array for all possible reply types.
		for (ReplyTypeEnum type : ReplyTypeEnum.values()) {
			_listenerMap.put(type, new ArrayList<ReplyEventListener>());
		}
	}
	
	/***********************************************************************************************
	 * 
	 * Name: registerListener
	 * 
	 * Description: Registers a listener for an event.
	 * 
	 **********************************************************************************************/
	public static void registerListener(ReplyEventListener listener, ReplyTypeEnum type) {
		_instance._listenerMap.get(type).add(listener);
	}
	
	/***********************************************************************************************
	 * 
	 * Name: publishEvent
	 * 
	 * Description: Receives an event and distributes it to the listeners.
	 * 
	 **********************************************************************************************/
	public static void publishEvent(ReplyTypeEnum replyType, EventObject event) {
		for (ReplyEventListener listener : _instance._listenerMap.get(replyType)) {
			listener.processEvent(event);
		}
	}

}
