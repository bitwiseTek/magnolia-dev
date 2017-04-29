package com.bitwise.magnolia.model.messages;
/**
 *  
 * @author Sika Kay
 * @date 22/04/17
 *
 */
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name="MESSAGES")
@Cache(usage=CacheConcurrencyStrategy.TRANSACTIONAL)
@NamedQueries({
	@NamedQuery(name="Messages.findById", query="select distinct m from Messages m where m.id=:id"),
	@NamedQuery(name="Messages.findAllBySenderName", query="select m from Messages m where m.sender=:sender"),
	@NamedQuery(name="Messages.findAllByReceiverName", query="select m from Messages m where m.receiver=:receiver"),
	@NamedQuery(name="Messages.findAll", query="select m from Messages m")
})
public class Messages implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public Messages() {
		
	}
	
	private Long id;
	
	private String subject;
	
	private String message;
	
	private String sender;
	
	private String receiver;
	
	private DateTime sentAt;
	
	private DateTime receivedAt;

	@Id
	@Column(name="USER_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name="SUBJECT")
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@NotNull
	@Column(name="MESSAGE", length=3000)
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@NotNull
	@Column(name="SENDER")
	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	@NotNull
	@Column(name="RECEIVER")
	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	@DateTimeFormat(iso=ISO.DATE_TIME)
	@Column(name="SENT_AT", nullable=false)
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	public DateTime getSentAt() {
		return sentAt;
	}

	public void setSentAt(DateTime sentAt) {
		this.sentAt = sentAt;
	}
	
	@Transient
	public String getSentAtString() {
		return org.joda.time.format.DateTimeFormat.forPattern("M dd H:mm:ss").print(sentAt);
	}

	@DateTimeFormat(iso=ISO.DATE_TIME)
	@Column(name="RECEIVED_AT", nullable=false)
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	public DateTime getReceivedAt() {
		return receivedAt;
	}

	public void setReceivedAt(DateTime receivedAt) {
		this.receivedAt = receivedAt;
	}
	
	@Transient
	public String getRecievedAtString() {
		return org.joda.time.format.DateTimeFormat.forPattern("M dd H:mm:ss").print(receivedAt);
	}
}
