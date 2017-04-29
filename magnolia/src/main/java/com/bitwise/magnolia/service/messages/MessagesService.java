package com.bitwise.magnolia.service.messages;
/**
 *  
 * @author Sika Kay
 * @date 22/04/17
 *
 */
import java.util.List;

import com.bitwise.magnolia.model.messages.Messages;
import com.bitwise.magnolia.util.MessagesList;

public interface MessagesService {

	public Messages findById(Long id);
	
	public List<Messages> findAllBySender(String sender);
	
	public List<Messages> findAllByReceiver(String receiver);
	
	public List<Messages> findAll();
	
	public MessagesList findAllMessagesBySender(String sender);
	
	public MessagesList findAllMessagesByReceiver(String receiver);
	
	public MessagesList findAllMessages();
	
	public Messages save(Messages messages);
}
