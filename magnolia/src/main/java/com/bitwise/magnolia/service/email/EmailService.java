package com.bitwise.magnolia.service.email;
/**
 *  
 * @author Sika Kay
 * @date 19/02/17
 *
 */
import javax.mail.MessagingException;

import com.bitwise.magnolia.model.user.User;
import com.bitwise.magnolia.web.restful.resource.user.UserResource;;

public interface EmailService {
	
	public void sendEmailWithAttachment(String toEmail, UserResource account) throws MessagingException;
	
	public void sendEmailWithToken(String toEmail, User user) throws MessagingException;
}
