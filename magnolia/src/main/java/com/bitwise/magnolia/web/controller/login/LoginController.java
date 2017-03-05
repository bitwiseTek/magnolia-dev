package com.bitwise.magnolia.web.controller.login;
/**
 *  
 * @author Sika Kay
 * @date 22/02/17
 *
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitwise.magnolia.common.ApplicationConstant;
import com.bitwise.magnolia.model.school.School;
import com.bitwise.magnolia.service.school.SchoolService;

@Controller
public class LoginController {
	
	@Autowired
	private SchoolService schoolService;
	
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
	
	@RequestMapping(value="/auth/logout", method=RequestMethod.GET)
	public String logOut(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/auth/login?logout";
	}
	

}
