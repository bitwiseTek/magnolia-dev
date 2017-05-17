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
import com.bitwise.magnolia.model.school.SubSchool;
import com.bitwise.magnolia.service.school.CampusService;
import com.bitwise.magnolia.service.school.SubSchoolService;
import com.bitwise.magnolia.validation.CampusValidator;
import com.bitwise.magnolia.web.util.UrlUtil;

@Controller
public class MVCCampusController {

	@Autowired
	private CampusService campusService;
	
	@Autowired
	private SubSchoolService subSchoolService;
	
	@InitBinder("campus")
	public void initBinder(WebDataBinder binder) {
		binder.setValidator(new CampusValidator());
	}
	
	@RequestMapping(value="/admin/campuses/list", method={RequestMethod.GET})
	public String requestCampuses(ModelMap model) {
		List<Campus> campuses = campusService.findAll();
		model.addAttribute("campuses", campuses);
		return "admin/campuses/list";
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMIN')")
	@RequestMapping(value="/admin/campuses/add", method={RequestMethod.GET})
	public String requestAddCampus(ModelMap model) {
		List<SubSchool> schools = subSchoolService.findAll();
		model.addAttribute("schools", schools);
		return "admin/campuses/add";
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMIN')")
	@RequestMapping(value="/admin/campuses/edit/campus/{id}", method={RequestMethod.GET})
	public String requestEditCampus(@PathVariable("id") Long id, @ModelAttribute Campus campus, ModelMap model, HttpServletRequest request) {
		campus = campusService.findById(id);
		model.addAttribute("campus", campus);
		List<SubSchool> schools = subSchoolService.findAll();
		model.addAttribute("schools", schools);
		Map<String, String> statuses = Utils.getStatuses();
		model.addAttribute("statuses", statuses);
		String currentStatus = campus.getStatus();
		model.addAttribute("currentStatus", currentStatus);
		return "admin/campuses/edit/campus";
	}
	
	@RequestMapping(value="/admin/campuses/show/campus/{id}", method={RequestMethod.GET})
	public String requestShowCampus(@PathVariable("id") Long id, @ModelAttribute Campus campus, ModelMap model, HttpServletRequest request) {
		campus = campusService.findById(id);
		model.addAttribute("campus", campus);
		List<SubSchool> schools = subSchoolService.findAll();
		model.addAttribute("schools", schools);
		Map<String, String> statuses = Utils.getStatuses();
		model.addAttribute("statuses", statuses);
		String currentStatus = campus.getStatus();
		model.addAttribute("currentStatus", currentStatus);
		return "admin/campuses/show/campus";
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMIN')")
	@RequestMapping(value="/admin/campuses/edit/campus/{id}", method={RequestMethod.PUT})
	public String editCampus(@Valid @ModelAttribute Campus campus, BindingResult result, HttpServletRequest request) {
		if (!result.hasErrors()) {
			this.campusService.update(campus);
			return "redirect:/admin/campuses/edit/campus/" + UrlUtil.encodeUrlPathSegment(campus.getCampusId().toString(), request);
		} else {
			return "redirect:/admin/campuses/edit/campus/" + UrlUtil.encodeUrlPathSegment(campus.getCampusId().toString(), request);
		}
	}
}
