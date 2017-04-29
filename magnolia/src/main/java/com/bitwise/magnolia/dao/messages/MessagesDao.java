package com.bitwise.magnolia.dao.messages;
/**
 *  
 * @author Sika Kay
 * @date 22/04/17
 *
 */
import java.util.List;

import com.bitwise.magnolia.model.messages.Messages;

public interface MessagesDao {

	public Messages findById(Long id);
	
	public List<Messages> findAllBySender(String sender);
	
	public List<Messages> findAllByReceiver(String receiver);
	
	public List<Messages> findAll();
	
	public Messages save(Messages messages);
}
