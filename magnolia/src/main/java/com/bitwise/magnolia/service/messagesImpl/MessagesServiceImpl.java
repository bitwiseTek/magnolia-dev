package com.bitwise.magnolia.service.messagesImpl;
/**
 *  
 * @author Sika Kay
 * @date 22/04/17
 *
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bitwise.magnolia.dao.messages.MessagesDao;
import com.bitwise.magnolia.model.messages.Messages;
import com.bitwise.magnolia.service.messages.MessagesService;
import com.bitwise.magnolia.util.MessagesList;

@Transactional
@Service("messagesService")
public class MessagesServiceImpl implements MessagesService {

	@Autowired
	private MessagesDao messagesDao;
	
	@Override
	@Transactional(readOnly=true)
	public Messages findById(Long id) {
		return this.messagesDao.findById(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Messages> findAllBySender(String sender) {
		return this.messagesDao.findAllBySender(sender);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Messages> findAllByReceiver(String receiver) {
		return this.messagesDao.findAllByReceiver(receiver);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Messages> findAll() {
		return this.messagesDao.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public MessagesList findAllMessagesBySender(String sender) {
		return new MessagesList(this.messagesDao.findAllBySender(sender));
	}

	@Override
	@Transactional(readOnly=true)
	public MessagesList findAllMessagesByReceiver(String receiver) {
		return new MessagesList(this.messagesDao.findAllByReceiver(receiver));
	}

	@Override
	@Transactional(readOnly=true)
	public MessagesList findAllMessages() {
		return new MessagesList(this.messagesDao.findAll());
	}

	@Override
	@Transactional(readOnly=false)
	public Messages save(Messages messages) {
		return this.messagesDao.save(messages);
	}

}
