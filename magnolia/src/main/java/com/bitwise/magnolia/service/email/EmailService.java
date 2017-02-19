package com.bitwise.magnolia.service.email;
/**
 *  
 * @author Sika Kay
 * @date 19/02/17
 *
 */
import javax.mail.MessagingException;

import com.bitwise.magnolia.vo.user.UserVo;;

public interface EmailService {
	public void sendEmailWithAttachment(String toEmail, UserVo account) throws MessagingException;
}
