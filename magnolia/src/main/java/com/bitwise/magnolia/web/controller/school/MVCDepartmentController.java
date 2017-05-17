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
import com.bitwise.magnolia.model.school.Department;
import com.bitwise.magnolia.model.school.Faculty;
import com.bitwise.magnolia.service.school.DepartmentService;
import com.bitwise.magnolia.service.school.FacultyService;
import com.bitwise.magnolia.validation.DepartmentValidator;
import com.bitwise.magnolia.web.util.UrlUtil;

@Controller
public class MVCDepartmentController {

	@Autowired
	private DepartmentService deptService;
	
	@Autowired
	private FacultyService facultyService;
	
	@InitBinder("dept")
	public void initBinder(WebDataBinder binder) {
		binder.setValidator(new DepartmentValidator());
	}
	
	@RequestMapping(value="/admin/departments/list", method={RequestMethod.GET})
	public String requestDepartments(ModelMap model) {
		List<Department> depts = deptService.findAll();
		model.addAttribute("depts", depts);
		return "admin/departments/list";
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMIN')")
	@RequestMapping(value="/admin/departments/add", method={RequestMethod.GET})
	public String requestAddDept(ModelMap model) {
		List<Faculty> faculties = facultyService.findAll();
		model.addAttribute("faculties", faculties);
		return "admin/departments/add";
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMIN')")
	@RequestMapping(value="/admin/departments/edit/department/{id}", method={RequestMethod.GET})
	public String requestEditDept(@PathVariable("id") Long id, @ModelAttribute Department dept, ModelMap model, HttpServletRequest request) {
		dept = deptService.findByDepartmentId(id);
		model.addAttribute("dept", dept);
		List<Faculty> faculties = facultyService.findAll();
		model.addAttribute("faculties", faculties);
		Map<String, String> statuses = Utils.getStatuses();
		model.addAttribute("statuses", statuses);
		String currentStatus = dept.getStatus();
		model.addAttribute("currentStatus", currentStatus);
		return "admin/departments/edit/department";
	}
	
	@RequestMapping(value="/admin/departments/show/department/{id}", method={RequestMethod.GET})
	public String requestShowDept(@PathVariable("id") Long id, @ModelAttribute Department dept, ModelMap model, HttpServletRequest request) {
		dept = deptService.findByDepartmentId(id);
		model.addAttribute("dept", dept);
		List<Faculty> faculties = facultyService.findAll();
		model.addAttribute("faculties", faculties);
		Map<String, String> statuses = Utils.getStatuses();
		model.addAttribute("statuses", statuses);
		String currentStatus = dept.getStatus();
		model.addAttribute("currentStatus", currentStatus);
		return "admin/departments/show/department";
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMIN')")
	@RequestMapping(value="/admin/departments/edit/department/{id}", method={RequestMethod.PUT})
	public String editDept(@Valid @ModelAttribute Department dept, BindingResult result, HttpServletRequest request) {
		if (!result.hasErrors()) {
			this.deptService.update(dept);
			return "redirect:/admin/departments/edit/department/" + UrlUtil.encodeUrlPathSegment(dept.getDepartmentId().toString(), request);
		} else {
			return "redirect:/admin/departments/edit/department/" + UrlUtil.encodeUrlPathSegment(dept.getDepartmentId().toString(), request);
		}
	}
}
