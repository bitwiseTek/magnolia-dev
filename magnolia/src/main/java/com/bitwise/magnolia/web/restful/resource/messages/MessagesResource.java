package com.bitwise.magnolia.web.restful.resource.messages;
/**
 *  
 * @author Sika Kay
 * @date 22/04/17
 *
 */
import org.joda.time.DateTime;
import org.springframework.hateoas.ResourceSupport;

import com.bitwise.magnolia.model.messages.Messages;

public class MessagesResource extends ResourceSupport {

	public MessagesResource() {
		
	}
	
	private Long rid;
	
	private String subject;
	
	private String message;
	
	private String sender;
	
	private String receiver;
	
	private String sentAt;
	
	private String receivedAt;

	public Long getRid() {
		return rid;
	}

	public void setRid(Long rid) {
		this.rid = rid;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getSentAt() {
		return sentAt;
	}

	public void setSentAt(String sentAt) {
		this.sentAt = sentAt;
	}

	public String getReceivedAt() {
		return receivedAt;
	}

	public void setReceivedAt(String receivedAt) {
		this.receivedAt = receivedAt;
	}
	
	public Messages toMessage() {
		Messages messages = new Messages();
		messages.setId(rid);
		messages.setSubject(subject);
		messages.setMessage(message);
		messages.setSender(sender);
		messages.setReceiver(receiver);
		messages.setSentAt(new DateTime(DateTime.now()));
		messages.setReceivedAt(new DateTime(DateTime.now()));
		return messages;
	}
}
