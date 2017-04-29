package com.bitwise.magnolia.service.email;
/**
 *  
 * @author Sika Kay
 * @date 19/02/17
 *
 */
import javax.mail.MessagingException;

import com.bitwise.magnolia.model.finance.BillingDetails;
import com.bitwise.magnolia.model.staff.Staff;
import com.bitwise.magnolia.model.student.Student;
import com.bitwise.magnolia.model.user.User;
import com.bitwise.magnolia.web.restful.resource.user.UserResource;;

public interface EmailService {
	
	public void sendEmailWithAttachment(String toEmail, UserResource account) throws MessagingException;
	
	public void sendUpdateEmail(String toEmail, UserResource account) throws MessagingException;
	
	public void sendUpdateStudentEmail(String toEmail, Student account) throws MessagingException;
	
	public void sendUpdateAdminStudentEmail(String toEmail, Student account) throws MessagingException;
	
	public void sendUpdateAdminBillingEmail(String toEmail, BillingDetails account) throws MessagingException;
	
	public void sendStudentBillingEmail(String toEmail, BillingDetails account) throws MessagingException;
	
	public void sendUpdateStaffEmail(String toEmail, Staff account) throws MessagingException;
	
	public void sendUpdateAdminStaffEmail(String toEmail, Staff account) throws MessagingException;
	
	public void sendEmailWithToken(String toEmail, User user) throws MessagingException;
}
