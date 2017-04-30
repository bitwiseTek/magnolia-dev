package com.bitwise.magnolia.web.restful.controller.messages;
/**
 *  
 * @author Sika Kay
 * @date 22/04/17
 *
 */
import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bitwise.magnolia.common.ApplicationConstant;
import com.bitwise.magnolia.exception.EntityExistsException;
import com.bitwise.magnolia.model.messages.Messages;
import com.bitwise.magnolia.service.messages.MessagesService;
import com.bitwise.magnolia.util.MessagesList;
import com.bitwise.magnolia.web.restful.exception.ConflictException;
import com.bitwise.magnolia.web.restful.exception.ErrorDetail;
import com.bitwise.magnolia.web.restful.resource.asm.messages.MessagesListResourceAsm;
import com.bitwise.magnolia.web.restful.resource.asm.messages.MessagesResourceAsm;
import com.bitwise.magnolia.web.restful.resource.messages.MessagesListResource;
import com.bitwise.magnolia.web.restful.resource.messages.MessagesResource;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

@RestController
@Api(value="messages", description="Messages API")
public class MessagesController {
	
	final Logger logger = LoggerFactory.getLogger(MessagesController.class);

	@Autowired
	private MessagesService messagesService;
	
	@ApiOperation(value="Retrieves a message associated with an ID", response=Messages.class)
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/messages/{id}"}, 
	method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MessagesResource> findMessage(@PathVariable Long id) {
		Messages messages = messagesService.findById(id);
		if (messages != null) {
			MessagesResource res = new MessagesResourceAsm().toResource(messages);
			return new ResponseEntity<MessagesResource>(res, HttpStatus.OK);
		} else {
			return new ResponseEntity<MessagesResource>(HttpStatus.NOT_FOUND);
		}
	}
	
	@ApiOperation(value="Retrieves all the messages sent", response=Messages.class, responseContainer="List")
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/messages/sender/{sender}"}, 
	method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MessagesListResource> findAllBySender(@PathVariable("sender") String sender) {
		MessagesList messagesList = null;
		messagesList = messagesService.findAllMessagesBySender(sender);
		if (messagesList != null) {
			MessagesListResource res = new MessagesListResourceAsm().toResource(messagesList);
			return new ResponseEntity<MessagesListResource>(res, HttpStatus.OK);
		} else {
			return new ResponseEntity<MessagesListResource>(HttpStatus.NOT_FOUND);
		}
	}
	
	@ApiOperation(value="Retrieves all the messages received", response=Messages.class, responseContainer="List")
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/messages/receiver/{receiver}"}, 
	method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MessagesListResource> findAllByReceiver(@PathVariable("receiver") String receiver) {
		MessagesList messagesList = null;
		messagesList = messagesService.findAllMessagesByReceiver(receiver);
		if (messagesList != null) {
			MessagesListResource res = new MessagesListResourceAsm().toResource(messagesList);
			return new ResponseEntity<MessagesListResource>(res, HttpStatus.OK);
		} else {
			return new ResponseEntity<MessagesListResource>(HttpStatus.NOT_FOUND);
		}
	}
	
	@ApiOperation(value="Sends a new message", notes="The newly created message ID will be sent in the location response header")
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/restful/messages/send"}, 
	method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value={@ApiResponse(code=201, message="Message sent successfully", response=Void.class), @ApiResponse(code=500, message="Error sending message", response=ErrorDetail.class)})
	public ResponseEntity<MessagesResource> sendMessage(@RequestBody MessagesResource sentMessage) {
		try {
			Messages sendMessage = messagesService.save(sentMessage.toMessage());
			MessagesResource res = new MessagesResourceAsm().toResource(sendMessage);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(URI.create(res.getLink("self").getHref()));
			return new ResponseEntity<MessagesResource>(res, headers, HttpStatus.CREATED);
		} catch(EntityExistsException ex) {
			throw new ConflictException("Message has already been sent");
		}
	}
}
