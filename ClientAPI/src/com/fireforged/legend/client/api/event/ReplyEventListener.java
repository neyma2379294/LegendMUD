package com.fireforged.legend.client.api.event;

import java.util.EventListener;
import java.util.EventObject;

/***************************************************************************************************
 * 
 * Name: ReplyEventListener
 * 
 * Description: Listens for replies from the server.
 * 
 * @author Chris Rhodes
 * 
 **************************************************************************************************/
interface ReplyEventListener extends EventListener {

	void processEvent(EventObject event);
	
}
