package com.bitwise.magnolia.web.restful.resource.messages;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.ResourceSupport;

public class MessagesListResource extends ResourceSupport {

	private List<MessagesResource> messages = new ArrayList<MessagesResource>();

	public List<MessagesResource> getMessages() {
		return messages;
	}

	public void setMessages(List<MessagesResource> messages) {
		this.messages = messages;
	}
}
