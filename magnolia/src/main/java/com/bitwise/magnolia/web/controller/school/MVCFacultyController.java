package com.bitwise.magnolia.web.controller.school;
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
import com.bitwise.magnolia.model.school.Campus;
import com.bitwise.magnolia.model.school.Faculty;
import com.bitwise.magnolia.service.school.CampusService;
import com.bitwise.magnolia.service.school.FacultyService;
import com.bitwise.magnolia.validation.FacultyValidator;
import com.bitwise.magnolia.web.util.UrlUtil;

@Controller
public class MVCFacultyController {

	@Autowired
	private FacultyService facultyService;
	
	@Autowired
	private CampusService campusService;
	
	@InitBinder("faculty")
	public void initBinder(WebDataBinder binder) {
		binder.setValidator(new FacultyValidator());
	}
	
	@RequestMapping(value="/admin/faculties/list", method={RequestMethod.GET})
	public String requestFaculties(ModelMap model) {
		List<Faculty> faculties = facultyService.findAll();
		model.addAttribute("faculties", faculties);
		return "admin/faculties/list";
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMIN')")
	@RequestMapping(value="/admin/faculties/add", method={RequestMethod.GET})
	public String requestAddFaculty(ModelMap model) {
		List<Campus> campuses = campusService.findAll();
		model.addAttribute("campuses", campuses);
		return "admin/faculties/add";
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMIN')")
	@RequestMapping(value="/admin/faculties/edit/faculty/{id}", method={RequestMethod.GET})
	public String requestEditFaculty(@PathVariable("id") Long id, @ModelAttribute Faculty faculty, ModelMap model, HttpServletRequest request) {
		faculty = facultyService.findById(id);
		model.addAttribute("faculty", faculty);
		List<Campus> campuses = campusService.findAll();
		model.addAttribute("campuses", campuses);
		Map<String, String> statuses = Utils.getStatuses();
		model.addAttribute("statuses", statuses);
		String currentStatus = faculty.getStatus();
		model.addAttribute("currentStatus", currentStatus);
		return "admin/faculties/edit/faculty";
	}
	
	@RequestMapping(value="/admin/faculties/show/faculty/{id}", method={RequestMethod.GET})
	public String requestShowFaculty(@PathVariable("id") Long id, @ModelAttribute Faculty faculty, ModelMap model, HttpServletRequest request) {
		faculty = facultyService.findById(id);
		model.addAttribute("faculty", faculty);
		List<Campus> campuses = campusService.findAll();
		model.addAttribute("campuses", campuses);
		Map<String, String> statuses = Utils.getStatuses();
		model.addAttribute("statuses", statuses);
		String currentStatus = faculty.getStatus();
		model.addAttribute("currentStatus", currentStatus);
		return "admin/faculties/show/faculty";
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMIN')")
	@RequestMapping(value="/admin/faculties/edit/faculty/{id}", method={RequestMethod.PUT})
	public String editFaculty(@Valid @ModelAttribute Faculty faculty, BindingResult result, HttpServletRequest request) {
		if (!result.hasErrors()) {
			this.facultyService.update(faculty);
			return "redirect:/admin/faculties/edit/faculty/" + UrlUtil.encodeUrlPathSegment(faculty.getFacultyId().toString(), request);
		} else {
			return "redirect:/admin/faculties/edit/faculty/" + UrlUtil.encodeUrlPathSegment(faculty.getFacultyId().toString(), request);
		}
	}
}
