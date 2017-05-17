package com.bitwise.magnolia.web.controller.course;
import java.util.List;

/**
 *  
 * @author Sika Kay
 * @date 01/05/17
 *
 */
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.bitwise.magnolia.model.course.CourseLength;
import com.bitwise.magnolia.service.course.CourseLengthService;
import com.bitwise.magnolia.validation.CourseLengthValidator;
import com.bitwise.magnolia.web.util.UrlUtil;

@Controller
public class MVCCourseLengthController {

	@Autowired
	private CourseLengthService lengthService;
	
	@InitBinder("length")
	public void initBinder(WebDataBinder binder) {
		binder.setValidator(new CourseLengthValidator());
	}
	
	@RequestMapping(value="/course/lengths/list", method={RequestMethod.GET})
	public String requestLengths(ModelMap model) {
		List<CourseLength> lengths = lengthService.findAll();
		model.addAttribute("lengths", lengths);
		return "course/lengths/list";
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMIN')")
	@RequestMapping(value="/course/lengths/add", method={RequestMethod.GET})
	public String requestAddLength() {
		return "course/lengths/add";
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMIN')")
	@RequestMapping(value="/course/lengths/edit/courselength/{id}", method={RequestMethod.GET})
	public String requestEditLength(@PathVariable("id") Long id, @ModelAttribute CourseLength length, ModelMap model, HttpServletRequest request) {
		length = lengthService.findById(id);
		model.addAttribute("length", length);
		return "course/lengths/edit/courselength";
	}
	
	@RequestMapping(value="/course/lengths/show/courselength/{id}", method={RequestMethod.GET})
	public String requestShowLength(@PathVariable("id") Long id, @ModelAttribute CourseLength length, ModelMap model, HttpServletRequest request) {
		length = lengthService.findById(id);
		model.addAttribute("length", length);
		return "course/lengths/show/courselength";
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMIN')")
	@RequestMapping(value="/course/lengths/edit/courselength/{id}", method={RequestMethod.PUT})
	public String editCategory(@Valid @ModelAttribute CourseLength length, BindingResult result, HttpServletRequest request) {
		if (!result.hasErrors()) {
			this.lengthService.update(length);
			return "redirect:/course/lengths/edit/courselength/" + UrlUtil.encodeUrlPathSegment(length.getId().toString(), request);
		} else {
			return "redirect:/course/lengths/edit/courselength/" + UrlUtil.encodeUrlPathSegment(length.getId().toString(), request);
		}
	}
}
