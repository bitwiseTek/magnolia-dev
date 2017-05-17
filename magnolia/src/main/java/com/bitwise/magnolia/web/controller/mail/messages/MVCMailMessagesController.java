package com.bitwise.magnolia.web.controller.mail.messages;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
/**
 *  
 * @author Sika Kay
 * @date 18/04/17
 *
 */
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitwise.magnolia.model.messages.Messages;
import com.bitwise.magnolia.service.messages.MessagesService;

@Controller
public class MVCMailMessagesController {
	
	@Autowired
	private MessagesService messagesService;

	@RequestMapping(value = "/messages/inbox/{sender}", method = RequestMethod.GET)
	public String requestInbox(@PathVariable("sender") String sender, ModelMap model) {
		List<Messages> messages = messagesService.findAllBySender(sender);
		model.addAttribute("messages", messages);
		return "messages/inbox";
	}
	
	@RequestMapping(value = "/messages/compose", method = RequestMethod.GET)
	public String requestCompose() {
		return "messages/compose";
	}
	
	@RequestMapping(value = "/messages/drafts", method = RequestMethod.GET)
	public String requestDrafts(ModelMap model) {
		List<Messages> messages = messagesService.findAll();
		model.addAttribute("messages", messages);
		return "messages/drafts";
	}
	
	@RequestMapping(value = "/messages/sent/{receiver}", method = RequestMethod.GET)
	public String requestSent(@PathVariable("receiver") String receiver, ModelMap model) {
		List<Messages> messages = messagesService.findAllByReceiver(receiver);
		model.addAttribute("messages", messages);
		return "messages/sent";
	}
	
	@RequestMapping(value = "/messages/trash", method = RequestMethod.GET)
	public String requestTrash(ModelMap model) {
		List<Messages> messages = messagesService.findAll();
		model.addAttribute("messages", messages);
		return "messages/trash";
	}
	
	@RequestMapping(value = "/messages/view", method = RequestMethod.GET)
	public String requestView(ModelMap model) {
		List<Messages> messages = messagesService.findAll();
		model.addAttribute("messages", messages);
		return "messages/view";
	}
}
