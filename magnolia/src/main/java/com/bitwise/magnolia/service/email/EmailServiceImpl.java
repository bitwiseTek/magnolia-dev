package com.bitwise.magnolia.service.email;
/**
 *  
 * @author Sika Kay
 * @date 19/02/17
 *
 */
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;

import com.bitwise.magnolia.web.restful.resource.user.UserResource;

@Service("emailService")
public class EmailServiceImpl implements EmailService {
	
	private JavaMailSender mailSender;
	
	private VelocityEngine velocityEngine;
	
	@Autowired
	public EmailServiceImpl(JavaMailSender mailSender, VelocityEngine velocityEngine) {
		this.mailSender = mailSender;
		this.velocityEngine = velocityEngine;
	}

	@Override
	public void sendEmailWithAttachment(String toEmail, UserResource account) throws MessagingException {
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		Resource image = new ClassPathResource("top_logo.png");
		String firstName = account.getFirstName();
		String lastName = account.getLastName();
		String username = account.getUsername();
		String password = account.getTempPassword();
		String thanksMessage = "Thank You for registering with Magnolia Academy";
		String loginDetails = "Your login details;";
		helper.addInline("magnoliaImage", image);
		helper.setFrom("support@ntradex.com");
		helper.setTo(account.getPrimaryEmail());
		helper.setSubject("Welcome to Magnolia Academy " + firstName + " " + lastName);
		helper.setSentDate(new Date());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("firstName", firstName);
		model.put("lastName", lastName);
		model.put("thanksMessage", thanksMessage);
		model.put("loginDetails", loginDetails);
		model.put("username", username);
		model.put("password", password);
		String emailText = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "emailTemplate.vm", "UTF-8", model);
		helper.setText(emailText, true);
		mailSender.send(message);
	}

}
