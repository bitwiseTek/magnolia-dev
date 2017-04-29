package com.bitwise.magnolia.web.restful.resource.asm.messages;
/**
 *  
 * @author Sika Kay
 * @date 22/04/17
 *
 */
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import com.bitwise.magnolia.model.messages.Messages;
import com.bitwise.magnolia.web.restful.controller.messages.MessagesController;
import com.bitwise.magnolia.web.restful.resource.messages.MessagesResource;

public class MessagesResourceAsm extends ResourceAssemblerSupport<Messages, MessagesResource> {

	public MessagesResourceAsm() {
		super(MessagesController.class, MessagesResource.class);
	}
	
	@Override
	public MessagesResource toResource(Messages messages) {
		MessagesResource res = new MessagesResource();
		res.setRid(messages.getId());
		res.setSubject(messages.getSubject());
		res.setMessage(messages.getMessage());
		res.setSender(messages.getSender());
		res.setReceiver(messages.getReceiver());
		res.setSentAt(messages.getSentAtString());
		res.setReceivedAt(messages.getRecievedAtString());
		res.add(linkTo(methodOn(MessagesController.class).findMessage(messages.getId())).withSelfRel());
		return res;
	}

}
