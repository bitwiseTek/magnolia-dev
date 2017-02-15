package com.bitwise.magnolia.web.controller.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bitwise.magnolia.dao.common.ApplicationConstant;
import com.bitwise.magnolia.service.school.FacultyService;

@Controller
public class LoginController {
	
	@Autowired
	private FacultyService facultyService;
	
	@RequestMapping(value = "/auth/login", method = RequestMethod.GET)
	public ModelAndView getLoginPage(){
		ModelAndView mv = new ModelAndView("login");
		mv.addObject("facultyList", facultyService.getActiveFaculties(ApplicationConstant.SCHOOL_ALIAS));
		mv.setViewName("auth/login");
		return mv;
	}
	

}
