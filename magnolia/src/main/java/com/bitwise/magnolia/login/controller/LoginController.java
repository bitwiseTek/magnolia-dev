package com.bitwise.magnolia.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bitwise.magnolia.common.ApplicationConstant;
import com.bitwise.magnolia.service.FacultyService;

@Controller
public class LoginController {
	
	@Autowired
	private FacultyService facultyService;
	
	@RequestMapping(value = "/auth/login", method = RequestMethod.GET)
	public ModelAndView getLoginPage(){
		ModelAndView mv = new ModelAndView("login");
		mv.addObject("facultyList", facultyService.getActiveFaculties(ApplicationConstant.SCHOOL_ALIAS));
		return mv;
	}
	

}
