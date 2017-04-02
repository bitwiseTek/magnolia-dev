package com.bitwise.magnolia.web.controller.user;
/**
 *  
 * @author Sika Kay
 * @date 25/03/17
 *
 */
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bitwise.magnolia.common.Utils;
import com.bitwise.magnolia.messages.Message;
import com.bitwise.magnolia.model.common.LGA;
import com.bitwise.magnolia.model.common.State;
import com.bitwise.magnolia.model.security.Role;
import com.bitwise.magnolia.model.user.User;
import com.bitwise.magnolia.service.common.LGAService;
import com.bitwise.magnolia.service.common.StateService;
import com.bitwise.magnolia.service.security.RoleService;
import com.bitwise.magnolia.service.user.UserService;
import com.bitwise.magnolia.validation.UserValidator;
import com.bitwise.magnolia.web.util.UrlUtil;

@Controller
public class MVCUserController {
	
	@Autowired
	private StateService stateService;
	
	@Autowired
	private LGAService lgaService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private MessageSource messageSource;

	@InitBinder("user")
	public void initBinder(WebDataBinder binder) {
		binder.setValidator(new UserValidator());
	}
	
	@RequestMapping(value="/users/register", method=RequestMethod.GET)
	public String requestSignUpPage(ModelMap model) {
		List<State> states = stateService.findAll();
		model.addAttribute("states", states);
		return "users/register";
	}
	
	@RequestMapping(value="/users/profile/edit", method=RequestMethod.GET)
	public String requestProfileUsersPage(ModelMap model) {
		List<User> users = userService.findAll();
		model.addAttribute("users", users);
		return "users/profile/edit";
	}
	
	@RequestMapping(value="/users/edit", method=RequestMethod.GET)
	public String requestSystemUsersPage(ModelMap model) {
		List<User> users = userService.findAll();
		model.addAttribute("users", users);
		List<Role> roles = roleService.findAll();
		model.addAttribute("roles", roles);
		return "users/edit";
	}
	
	@RequestMapping(value="/users/profile/edit/user/{id}", method={RequestMethod.GET})
	public String requestProfile(@PathVariable("id") Long id, @ModelAttribute User user, ModelMap model, HttpServletRequest request) {
		user = userService.findById(id);
		model.addAttribute("user", user);
		String username = user.getUsername();
		model.addAttribute("username", username);
		Map<String, String> sexes = Utils.getSexes();
		model.addAttribute("sexes", sexes);
		Map<String, String> questions = Utils.getQuestions();
		model.addAttribute("questions", questions);
		String currentSex = user.getSex();
		model.addAttribute("currentSex", currentSex);
		Map<String, String> statuses = Utils.getStatuses();
		model.addAttribute("statuses", statuses);
		String currentStatus = user.getStatus();
		model.addAttribute("currentStatus", currentStatus);
		List<State> states = stateService.findAll();
		model.addAttribute("states", states);
		List<LGA> lgas = lgaService.findAll();
		model.addAttribute("lgas", lgas);
		String currentQuestion = user.getSecretQuestion();
		model.addAttribute("currentQuestion", currentQuestion);
		return "users/profile/edit/user";
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMIN')")
	@RequestMapping(value="/users/edit/user/{id}", method={RequestMethod.GET})
	public String requestSystemUser(@PathVariable("id") Long id, @ModelAttribute User user, ModelMap model, HttpServletRequest request) {
		user = userService.findById(id);
		List<Role> roles = roleService.findAll();
		model.addAttribute("user", user);
		model.addAttribute("roles", roles);
		String username = user.getUsername();
		model.addAttribute("username", username);
		Map<String, String> sexes = Utils.getSexes();
		model.addAttribute("sexes", sexes);
		Map<String, String> questions = Utils.getQuestions();
		model.addAttribute("questions", questions);
		String currentSex = user.getSex();
		model.addAttribute("currentSex", currentSex);
		Map<String, String> statuses = Utils.getStatuses();
		model.addAttribute("statuses", statuses);
		String currentStatus = user.getStatus();
		model.addAttribute("currentStatus", currentStatus);
		List<State> states = stateService.findAll();
		model.addAttribute("states", states);
		List<LGA> lgas = lgaService.findAll();
		model.addAttribute("lgas", lgas);
		String currentQuestion = user.getSecretQuestion();
		model.addAttribute("currentQuestion", currentQuestion);
		return "users/edit/user";
	}
	
	@RequestMapping(value = "/users/password/update/{id}", method = RequestMethod.GET)
	public String requestUpdatePassword(@PathVariable("id") Long id, @ModelAttribute User user, ModelMap model) {
		user = userService.findById(id);
		model.addAttribute("user", user);
		return "users/password/update";
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMIN')")
	@RequestMapping(value="/users/edit/user/{id}", method={RequestMethod.PUT})
	public String editSystemUser(@Valid @ModelAttribute User user, BindingResult result, HttpServletRequest request) {
		if (!result.hasErrors()) {
			this.userService.update(user);
			return "redirect:/users/edit/user/" + UrlUtil.encodeUrlPathSegment(user.getId().toString(), request);
		} else {
			return "redirect:/users/edit/user/" + UrlUtil.encodeUrlPathSegment(user.getId().toString(), request);
		}
	}
	
	@RequestMapping(value="/users/profile/edit/user/{id}", method={RequestMethod.PUT})
	public String editProfileUser(@Valid @ModelAttribute User user, BindingResult result, HttpServletRequest request) {
		if (!result.hasErrors()) {
			this.userService.update(user);
			return "redirect:/users/profile/edit/user/" + UrlUtil.encodeUrlPathSegment(user.getId().toString(), request);
		} else {
			return "redirect:/users/profile/edit/user/" + UrlUtil.encodeUrlPathSegment(user.getId().toString(), request);
		}
	}
	
	@RequestMapping(value = "/users/password/update/{id}", method = RequestMethod.PUT)
	public String updatePassword(@Valid @ModelAttribute User user, BindingResult result, RedirectAttributes redirectAttr, 
			Locale locale, ModelMap model, HttpServletRequest request) {
		if (!result.hasErrors()) {
			this.userService.update(user);
			model.addAttribute("message", new Message("success", messageSource.getMessage("users.editSystemUser.password.updated", new Object[]{}, locale)));
			return "redirect:/users/password/update/" + UrlUtil.encodeUrlPathSegment(user.getId().toString(), request);
		} else {
			return "redirect:/users/password/update/" + UrlUtil.encodeUrlPathSegment(user.getId().toString(), request);
		}
	}
	
}
