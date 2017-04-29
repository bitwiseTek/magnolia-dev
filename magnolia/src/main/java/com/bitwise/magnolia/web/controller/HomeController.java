package com.bitwise.magnolia.web.controller;
import org.joda.time.DateTime;
/**
 * @author js4otto
 *
 */
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index(){
		ModelAndView model = new ModelAndView("index");
		String currentDay = org.joda.time.format.DateTimeFormat.forPattern("E").print(DateTime.now());
		model.addObject("currentDay", currentDay);
		return model;
	}
	
}
