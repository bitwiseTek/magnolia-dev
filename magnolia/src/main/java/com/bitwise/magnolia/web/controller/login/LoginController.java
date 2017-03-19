package com.bitwise.magnolia.web.controller.login;
/**
 *  
 * @author Sika Kay
 * @date 22/02/17
 *
 */
import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitwise.magnolia.common.ApplicationConstant;
import com.bitwise.magnolia.common.Utils;
import com.bitwise.magnolia.model.school.School;
import com.bitwise.magnolia.model.user.User;
import com.bitwise.magnolia.service.email.EmailService;
import com.bitwise.magnolia.service.school.SchoolService;
import com.bitwise.magnolia.service.user.UserService;
import com.bitwise.magnolia.validation.UserValidator;

@Controller
public class LoginController {
	
	final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private SchoolService schoolService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private EmailService emailService;
	
	@InitBinder("user")
	public void initBinder(WebDataBinder binder) {
		binder.setDisallowedFields("id");
		binder.setValidator(new UserValidator());
	}
	
	@RequestMapping(value = "/auth/login", method = RequestMethod.GET)
	public String logIn(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, HttpSession session,
			HttpServletRequest request, ModelMap model) {
		{
			CsrfToken token = (CsrfToken) request.getAttribute(CsrfToken.class.getName());
			String schoolAlias = ApplicationConstant.SCHOOL_ALIAS;
			School school = this.schoolService.retrieveSchoolDetails(schoolAlias);
			model.addAttribute("school", school);
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
	
	@RequestMapping(value = "/auth/password/recover", method = RequestMethod.GET)
	public String requestRecoverPassword(HttpServletRequest request, ModelMap model) {
		{
			CsrfToken token = (CsrfToken) request.getAttribute(CsrfToken.class.getName());
			if (token != null) {
				model.addAttribute("csrfParameterName", token.getParameterName());
				model.addAttribute("csrfToken", token.getToken());
			}
			model.addAttribute("user", new User());
			return "auth/password/recover";
		}
	}
	
	@RequestMapping(value="/auth/logout", method=RequestMethod.GET)
	public String logOut(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/auth/login?logout";
	}
	
	@RequestMapping(value = "/auth/password/recover/token", method = RequestMethod.POST)
	public String generatePasswordToken(@Valid @ModelAttribute User user, BindingResult result) throws MessagingException {
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
			return "redirect:/auth/password/recover/token";
		}
	}
	
	@RequestMapping(value = "/auth/password/recover/check?token={token}&email={email}", method = RequestMethod.GET)
	public String recoverPassword(@RequestParam("token") String token, @RequestParam("email") String email, 
			@ModelAttribute User user, BindingResult result) {
		user = this.userService.findByEmailAndToken(email, token);
		token = user.getUsername();
		email = user.getPrimaryEmail();
		if (!token.isEmpty() && !email.isEmpty()) {
			if (user.getRecoveryTime().isAfter(new DateTime(DateTime.now().plusMinutes(30)))) {
				//Session Context Attr
				return "redirect:/auth/password/recover?";
			}
		} else {
			return "redirect:/auth/password/recover";
		}
		return "redirect:/auth/password/recover";
	}
}
