package com.bitwise.magnolia.web.controller.common;
/**
 *  
 * @author Sika Kay
 * @date 01/05/17
 *
 */
import java.util.List;
import java.util.Map;

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

import com.bitwise.magnolia.common.Utils;
import com.bitwise.magnolia.model.common.StudyProgramme;
import com.bitwise.magnolia.model.common.StudyProgrammeCategory;
import com.bitwise.magnolia.model.course.CourseLength;
import com.bitwise.magnolia.model.school.Department;
import com.bitwise.magnolia.model.user.User;
import com.bitwise.magnolia.service.common.StudyProgrammeCategoryService;
import com.bitwise.magnolia.service.common.StudyProgrammeService;
import com.bitwise.magnolia.service.course.CourseLengthService;
import com.bitwise.magnolia.service.school.DepartmentService;
import com.bitwise.magnolia.service.user.UserService;
import com.bitwise.magnolia.validation.ProgrammeValidator;
import com.bitwise.magnolia.web.util.UrlUtil;

@Controller
public class MVCProgrammeController {

	@Autowired
	private StudyProgrammeService programmeService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private DepartmentService deptService;
	
	@Autowired
	private CourseLengthService lengthService;
	
	@Autowired
	private StudyProgrammeCategoryService categoryService;
	
	@InitBinder("programme")
	public void initBinder(WebDataBinder binder) {
		binder.setValidator(new ProgrammeValidator());
	}
	
	@RequestMapping(value="/programmes/list", method={RequestMethod.GET})
	public String requestProgrammes(ModelMap model) {
		List<StudyProgramme> programmes = programmeService.findAll();
		model.addAttribute("programmes", programmes);
		return "programmes/list";
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMIN')")
	@RequestMapping(value="/programmes/add", method={RequestMethod.GET})
	public String requestAddProgramme(ModelMap model) {
		List<StudyProgrammeCategory> categories = categoryService.findAllCategories();
		model.addAttribute("categories", categories);
		List<CourseLength> lengths = lengthService.findAll();
		model.addAttribute("lengths", lengths);
		List<Department> depts = deptService.findAll();
		model.addAttribute("depts", depts);
		List<User> users = userService.findAll();
		model.addAttribute("users", users);
		return "programmes/add";
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMIN')")
	@RequestMapping(value="/programmes/edit/programme/{id}", method={RequestMethod.GET})
	public String requestEditProgramme(@PathVariable("id") Long id, @ModelAttribute StudyProgramme programme, ModelMap model, HttpServletRequest request) {
		programme = programmeService.findById(id);
		model.addAttribute("programme", programme);
		List<StudyProgrammeCategory> categories = categoryService.findAllCategories();
		model.addAttribute("categories", categories);
		List<CourseLength> lengths = lengthService.findAll();
		model.addAttribute("lengths", lengths);
		List<Department> depts = deptService.findAll();
		model.addAttribute("depts", depts);
		List<User> users = userService.findAll();
		model.addAttribute("users", users);
		Map<String, String> statuses = Utils.getStatuses();
		model.addAttribute("statuses", statuses);
		String currentStatus = programme.getStatus();
		model.addAttribute("currentStatus", currentStatus);
		return "programmes/edit/programme";
	}
	
	@RequestMapping(value="/programmes/show/programme/{id}", method={RequestMethod.GET})
	public String requestShowProgramme(@PathVariable("id") Long id, @ModelAttribute StudyProgramme programme, ModelMap model, HttpServletRequest request) {
		programme = programmeService.findById(id);
		model.addAttribute("programme", programme);
		List<StudyProgrammeCategory> categories = categoryService.findAllCategories();
		model.addAttribute("categories", categories);
		List<CourseLength> lengths = lengthService.findAll();
		model.addAttribute("lengths", lengths);
		List<Department> depts = deptService.findAll();
		model.addAttribute("depts", depts);
		List<User> users = userService.findAll();
		model.addAttribute("users", users);
		Map<String, String> statuses = Utils.getStatuses();
		model.addAttribute("statuses", statuses);
		String currentStatus = programme.getStatus();
		model.addAttribute("currentStatus", currentStatus);
		return "programmes/show/programme";
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMIN')")
	@RequestMapping(value="/programmes/edit/programme/{id}", method={RequestMethod.PUT})
	public String editProgramme(@Valid @ModelAttribute StudyProgramme programme, BindingResult result, HttpServletRequest request) {
		if (!result.hasErrors()) {
			this.programmeService.update(programme);
			return "redirect:/programmes/edit/programme/" + UrlUtil.encodeUrlPathSegment(programme.getId().toString(), request);
		} else {
			return "redirect:/programmes/edit/programme/" + UrlUtil.encodeUrlPathSegment(programme.getId().toString(), request);
		}
	}
}
