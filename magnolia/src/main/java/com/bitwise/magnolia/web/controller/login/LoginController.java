package com.bitwise.magnolia.web.controller.login;
/**
 *  
 * @author Sika Kay
 * @date 22/02/17
 *
 */
import java.util.Locale;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bitwise.magnolia.common.Utils;
import com.bitwise.magnolia.messages.Message;
import com.bitwise.magnolia.model.user.User;
import com.bitwise.magnolia.service.email.EmailService;
import com.bitwise.magnolia.service.user.UserService;
import com.bitwise.magnolia.validation.UserValidator;
import com.bitwise.magnolia.web.util.UrlUtil;

@Controller
public class LoginController {
	
	final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private MessageSource messageSource;
	
	@InitBinder("user")
	public void initBinder(WebDataBinder binder) {
		binder.setDisallowedFields("id");
		binder.setValidator(new UserValidator());
	}
	
	@RequestMapping(value = "/auth/login", method = RequestMethod.GET)
	public String logIn(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "locked", required = false) String locked, 
			@RequestParam(value = "deactivated", required = false) String deactivated,
			@RequestParam(value = "logout", required = false) String logout, HttpSession session,
			HttpServletRequest request, ModelMap model) {
		{
			CsrfToken token = (CsrfToken) request.getAttribute(CsrfToken.class.getName());
			if (token != null) {
				model.addAttribute("csrfParameterName", token.getParameterName());
				model.addAttribute("csrfToken", token.getToken());
			}
			return "auth/login";
		}
	}
	
	@RequestMapping(value = "/auth/password/recover/token", method = RequestMethod.GET)
	public String requestRecoverPasswordToken(HttpServletRequest request, ModelMap model) {
		{
			CsrfToken token = (CsrfToken) request.getAttribute(CsrfToken.class.getName());
			if (token != null) {
				model.addAttribute("csrfParameterName", token.getParameterName());
				model.addAttribute("csrfToken", token.getToken());
			}
			model.addAttribute("user", new User());
			return "auth/password/recover/token";
		}
	}
	
	@RequestMapping(value = "/auth/password/recover/{id}", method = RequestMethod.GET)
	public String requestRecoverPassword(@PathVariable("id") Long id, HttpServletRequest request, ModelMap model) {
		{
			CsrfToken token = (CsrfToken) request.getAttribute(CsrfToken.class.getName());
			if (token != null) {
				model.addAttribute("csrfParameterName", token.getParameterName());
				model.addAttribute("csrfToken", token.getToken());
			}
			User user = userService.findById(id);
			model.addAttribute("user", user);
			return "auth/password/recover";
		}
	}
	
	@RequestMapping(value = "/auth/password/recover/token", method = RequestMethod.POST)
	public String generatePasswordToken(@Valid @ModelAttribute User user, BindingResult result, RedirectAttributes redirectAttr, 
			Locale locale, ModelMap model) throws MessagingException {
		boolean userNameDoesNotExist = user.getUsername() == null
				&& (userService.findByUsername(user.getUsername()) == null);
		boolean securityQandADontMatch = user.getSecretAnswer().equals(userService.findByUsername(user.getSecretAnswer()));
		if (result.hasErrors() || userNameDoesNotExist) {
			if (userNameDoesNotExist) {
				result.rejectValue("username", "validation.username.NotExist", "Username does not exist");
			}
			return "auth/password/recover/token";
		} else if(result.hasErrors() || securityQandADontMatch) { 
			if (securityQandADontMatch) {
				result.rejectValue("secretAns", "validation.secretAnswer.mismatch", "Secret Answer is incorrect");
			}
			return "auth/password/recover/token";
		} else {
			user.setRecoveryToken(Utils.generateUUID());
			user.setRecoveryTime(new DateTime(DateTime.now().plusMinutes(20)));
			this.userService.update(user);
			this.emailService.sendEmailWithToken(user.getPrimaryEmail(), user);
			model.addAttribute("message", new Message("success", messageSource.getMessage("password.recovery.token.sent", new Object[]{}, locale)));
			return "redirect:/auth/password/recover/token";
		}
	}
	
	@RequestMapping(value = "/auth/password/recover/check?token={token}&email={email}", method = RequestMethod.GET)
	public String verifyPasswordToken(@RequestParam("token") String token, @RequestParam("email") String email, 
			@ModelAttribute User user, BindingResult result, HttpServletRequest request, RedirectAttributes redirectAttr, 
			Locale locale, ModelMap model) {
		user = this.userService.findByEmailAndToken(email, token);
		token = user.getUsername();
		email = user.getPrimaryEmail();
		if (!token.isEmpty() && !email.isEmpty()) {
			if (user.getRecoveryTime().isAfter(new DateTime(DateTime.now().plusMinutes(30)))) {
				model.addAttribute("message", new Message("error", messageSource.getMessage("password.recovery.token.expired", new Object[]{}, locale)));
				return "redirect:/auth/password/recover/token/bad";
			}
		} else {
			return "redirect:/auth/password/recover/" + UrlUtil.encodeUrlPathSegment(user.getId().toString(), request);
		}
		return "redirect:/auth/password/recover";
	}
	
	@RequestMapping(value = "/auth/password/recover/{id}", method = RequestMethod.PUT)
	public String recoverPassword(@Valid @ModelAttribute User user, BindingResult result, RedirectAttributes redirectAttr, 
			Locale locale, ModelMap model) {
		if (!result.hasErrors()) {
			this.userService.update(user);
			model.addAttribute("message", new Message("success", messageSource.getMessage("recovery.password.success", new Object[]{}, locale)));
			return "redirect:/auth/password/recover/{id}";
		} else {
			model.addAttribute("message", new Message("error", messageSource.getMessage("recovery.password.failed", new Object[]{}, locale)));
			return "redirect:/auth/password/recover/{id}";
		}
	}
	
	@RequestMapping(value="/passwordRecovered", method=RequestMethod.GET)
	public ModelAndView requestPasswordRecoveredPage() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("passwordRecovered");
		return mav;
	}
}
