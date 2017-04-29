package com.bitwise.magnolia.web.restful.resource.asm.messages;
/**
 *  
 * @author Sika Kay
 * @date 22/04/17
 *
 */
import java.util.List;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import com.bitwise.magnolia.util.MessagesList;
import com.bitwise.magnolia.web.restful.controller.messages.MessagesController;
import com.bitwise.magnolia.web.restful.resource.messages.MessagesListResource;
import com.bitwise.magnolia.web.restful.resource.messages.MessagesResource;

public class MessagesListResourceAsm extends ResourceAssemblerSupport<MessagesList, MessagesListResource> {

	public MessagesListResourceAsm() {
		super(MessagesController.class, MessagesListResource.class);
	}
	
	@Override
	public MessagesListResource toResource(MessagesList messagesList) {
		List<MessagesResource> resList = new MessagesResourceAsm().toResources(messagesList.getMessages());
		MessagesListResource finalRes = new MessagesListResource();
		finalRes.setMessages(resList);
		return finalRes;
	}

}
