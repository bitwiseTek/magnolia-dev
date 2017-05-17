package com.bitwise.magnolia.dao.messagesImpl;
/**
 *  
 * @author Sika Kay
 * @date 22/04/17
 *
 */
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.bitwise.magnolia.common.AbstractDao;
import com.bitwise.magnolia.dao.messages.MessagesDao;
import com.bitwise.magnolia.model.messages.Messages;

@Repository("messagesDao")
public class MessagesDaoImpl extends AbstractDao<Long, Messages> implements MessagesDao {

	final Logger logger = LoggerFactory.getLogger(MessagesDaoImpl.class);

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Messages findById(Long id) {
		return this.em.createNamedQuery("Messages.findById", Messages.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public List<Messages> findAllBySender(String sender) {
		return this.em.createNamedQuery("Messages.findAllBySenderName", Messages.class).setParameter("sender", sender).getResultList();
	}

	@Override
	public List<Messages> findAllByReceiver(String receiver) {
		return this.em.createNamedQuery("Messages.findAllByReceiverName", Messages.class).setParameter("receiver", receiver).getResultList();
	}

	@Override
	public List<Messages> findAll() {
		return this.em.createNamedQuery("Messages.findAll", Messages.class).getResultList();
	}

	@Override
	@Transactional
	public Messages save(Messages messages) {
		logger.info("Sending message with ID " + messages.getId());
		persist(messages);
		return messages;
	}

}
