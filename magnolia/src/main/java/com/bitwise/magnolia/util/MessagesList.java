package com.bitwise.magnolia.util;
/**
 *  
 * @author Sika Kay
 * @date 22/04/17
 *
 */

import java.util.ArrayList;
import java.util.List;

import com.bitwise.magnolia.model.messages.Messages;

public class MessagesList {

	public MessagesList(List<Messages> messages) {
		this.messages = messages;
	}
	
	private List<Messages> messages = new ArrayList<Messages>();

	public List<Messages> getMessages() {
		return messages;
	}

	public void setMessages(List<Messages> messages) {
		this.messages = messages;
	}
}
