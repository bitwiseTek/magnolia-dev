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
import com.bitwise.magnolia.model.school.School;
import com.bitwise.magnolia.model.school.SubSchool;
import com.bitwise.magnolia.service.school.SchoolService;
import com.bitwise.magnolia.service.school.SubSchoolService;
import com.bitwise.magnolia.validation.SubSchoolValidator;
import com.bitwise.magnolia.web.util.UrlUtil;

@Controller
public class MVCSubSchoolController {

	@Autowired
	private SubSchoolService subSchoolService;
	
	@Autowired
	private SchoolService schoolService;
	
	@InitBinder("subSchool")
	public void initBinder(WebDataBinder binder) {
		binder.setValidator(new SubSchoolValidator());
	}
	
	@RequestMapping(value="/admin/subschools/list", method={RequestMethod.GET})
	public String requestSubSchools(ModelMap model) {
		List<SubSchool> schools = subSchoolService.findAll();
		model.addAttribute("schools", schools);
		return "admin/subschools/list";
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMIN')")
	@RequestMapping(value="/admin/subschools/add", method={RequestMethod.GET})
	public String requestAddSubSchool(ModelMap model) {
		List<School> schools = schoolService.findAll();
		model.addAttribute("schools", schools);
		return "admin/subschools/add";
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMIN')")
	@RequestMapping(value="/admin/subschools/edit/subschool/{id}", method={RequestMethod.GET})
	public String requestEditSubSchool(@PathVariable("id") Long id, @ModelAttribute SubSchool subSchool, ModelMap model, HttpServletRequest request) {
		subSchool = subSchoolService.findById(id);
		model.addAttribute("subSchool", subSchool);
		List<School> schools = schoolService.findAll();
		model.addAttribute("schools", schools);
		Map<String, String> statuses = Utils.getStatuses();
		model.addAttribute("statuses", statuses);
		String currentStatus = subSchool.getStatus();
		model.addAttribute("currentStatus", currentStatus);
		Map<String, String> types = Utils.getSchoolTypes();
		model.addAttribute("types", types);
		String currentType = subSchool.getType();
		model.addAttribute("currentType", currentType);
		return "admin/subschools/edit/subschool";
	}
	
	@RequestMapping(value="/admin/subschools/show/subschool/{id}", method={RequestMethod.GET})
	public String requestShowSubSchool(@PathVariable("id") Long id, @ModelAttribute SubSchool subSchool, ModelMap model, HttpServletRequest request) {
		subSchool = subSchoolService.findById(id);
		model.addAttribute("subSchool", subSchool);
		List<School> schools = schoolService.findAll();
		model.addAttribute("schools", schools);
		Map<String, String> statuses = Utils.getStatuses();
		model.addAttribute("statuses", statuses);
		String currentStatus = subSchool.getStatus();
		model.addAttribute("currentStatus", currentStatus);
		Map<String, String> types = Utils.getSchoolTypes();
		model.addAttribute("types", types);
		String currentType = subSchool.getType();
		model.addAttribute("currentType", currentType);
		return "admin/subschools/show/subschool";
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMIN')")
	@RequestMapping(value="/admin/subschools/edit/subschool/{id}", method={RequestMethod.PUT})
	public String editSubSchool(@Valid @ModelAttribute SubSchool subSchool, BindingResult result, HttpServletRequest request) {
		if (!result.hasErrors()) {
			this.subSchoolService.update(subSchool);
			return "redirect:/admin/subschools/edit/subschool/" + UrlUtil.encodeUrlPathSegment(subSchool.getSubSchoolId().toString(), request);
		} else {
			return "redirect:/admin/subschools/edit/subschool/" + UrlUtil.encodeUrlPathSegment(subSchool.getSubSchoolId().toString(), request);
		}
	}
}
