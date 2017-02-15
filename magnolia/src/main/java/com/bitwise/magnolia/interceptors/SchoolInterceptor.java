/**
 * @author js4otto
 */

package com.bitwise.magnolia.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.bitwise.magnolia.dao.common.ApplicationConstant;
import com.bitwise.magnolia.exceptions.NoValidDaysException;
import com.bitwise.magnolia.exceptions.ResourceNotFoundException;
import com.bitwise.magnolia.service.school.SchoolService;


public class SchoolInterceptor extends HandlerInterceptorAdapter{

	@Autowired
	private SchoolService schoolService;
	
	/**
	 * <p>
	 * 	This interceptor intercepts any post request from the controller
	 *  A SCHOOL_ALIAS static variable of @see #ApplicationConstant is set, after been set
	 *  this posthandle interceptor intercepts the request, gets the request name i.e schoolAlias and performs some 
	 *  checks.
	 *  If it passes the condition, the school details is returned to the modelAndView object
	 * </p>
	 * @see #schoolService
	 * @param request
	 * @param response
	 * @param handler
	 * @param modelAndView
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception{
		String schoolAlias = ApplicationConstant.SCHOOL_ALIAS;
		//Tests if a school exist in the school database
		if(!schoolService.isSchoolExist(schoolAlias)){
			//If a school doesn't exist, a ResourceNotFoundException will be thrown
			throw new ResourceNotFoundException("Oops. Broken link, check and try again");
		}
		else{
			//Check if free trial has expired
			if(!schoolService.isValidDays(schoolAlias)){
				//If a school doesn't have any valid days, that means the school has expired or deactivated, 
				//a NoValidDaysException will the thrown
				throw new NoValidDaysException("School deactivated...Pls contact administration");
			}
			else{
				//School hasn't expired, retrieve the school Details
				modelAndView.addObject("school", schoolService.retrieveSchoolDetails(schoolAlias).getObject());
			}
		}
	}
}
