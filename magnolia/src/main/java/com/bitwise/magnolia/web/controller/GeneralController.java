package com.bitwise.magnolia.web.controller;
/**
 *  
 * @author Sika Kay
 * @date 22/03/17
 *
 */
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GeneralController {

	@RequestMapping(value="/accessdenied", method=RequestMethod.GET)
	public ModelAndView requestAccessDeniedPage() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("accessdenied");
		return mav;
	}
	
	@RequestMapping(value="/school-deactivated", method=RequestMethod.GET)
	public ModelAndView requestSchoolDeactivatedPage() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("schooldeactivated");
		return mav;
	}
	
	@RequestMapping(value="/defaulterror", method=RequestMethod.GET)
	public ModelAndView request500Page() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("defaulterror");
		return mav;
	}
	
	@RequestMapping(value="/dataAccessError", method=RequestMethod.GET)
	public ModelAndView requestDataFailurePage() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("dataAccessError");
		return mav;
	}
	
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public ModelAndView requestHomePage() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("home");
		return mav;
	}
	
	@RequestMapping(value="/success", method=RequestMethod.GET)
	public ModelAndView requestErrorPage() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("success");
		return mav;
	}
	
	@RequestMapping(value="/privacy", method=RequestMethod.GET)
	public ModelAndView requestPrivacyPage() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("privacy");
		return mav;
	}
	
	@RequestMapping(value="/terms", method=RequestMethod.GET)
	public ModelAndView requestTermsPage() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("terms");
		return mav;
	}
	
	@RequestMapping(value="/help", method=RequestMethod.GET)
	public ModelAndView requestHelpPage() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("help");
		return mav;
	}
	
	@RequestMapping(value="/contactus", method=RequestMethod.GET)
	public ModelAndView requestContactPage() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("contactus");
		return mav;
	}
	
	@RequestMapping(value="/resourceNotFound", method=RequestMethod.GET)
	public ModelAndView request404Page() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("resourceNotFound");
		return mav;
	}
}
