package com.bitwise.magnolia.web.controller.staff;
/**
 *  
 * @author Sika Kay
 * @date 24/04/17
 *
 */
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.joda.time.DateTime;
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
import com.bitwise.magnolia.model.school.Department;
import com.bitwise.magnolia.model.staff.Staff;
import com.bitwise.magnolia.model.student.Student;
import com.bitwise.magnolia.model.user.User;
import com.bitwise.magnolia.service.common.StudyProgrammeService;
import com.bitwise.magnolia.service.email.EmailService;
import com.bitwise.magnolia.service.school.DepartmentService;
import com.bitwise.magnolia.service.staff.StaffService;
import com.bitwise.magnolia.service.student.StudentService;
import com.bitwise.magnolia.service.user.UserService;
import com.bitwise.magnolia.validation.StaffValidator;
import com.bitwise.magnolia.web.util.UrlUtil;

@Controller
public class MVCStaffController {

	@Autowired
	private StaffService staffService;
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private DepartmentService deptService;
	
	@Autowired
	private StudyProgrammeService programmeService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private EmailService emailService;
	
	@InitBinder("staff")
	public void initBinder(WebDataBinder binder) {
		binder.setValidator(new StaffValidator());
	}
	
	@PreAuthorize("hasRole('STAFF')")
	@RequestMapping(value="/staff/register", method=RequestMethod.GET)
	public String requestStaffRegisterPage(ModelMap model) {
		List<Department> depts = deptService.findAll();
		model.addAttribute("depts", depts);
		List<StudyProgramme> programmes = programmeService.findAll();
		model.addAttribute("programmes", programmes);
		List<User> users = userService.findAll();
		model.addAttribute("users", users);
		return "staff/register";
	}
	
	@PreAuthorize("hasRole('STAFF')")
	@RequestMapping(value="/staff/edit", method=RequestMethod.GET)
	public String requestEditStaffPage(ModelMap model) {
		List<Staff> staff = staffService.findAll();
		model.addAttribute("staff", staff);
		String currentTime = org.joda.time.format.DateTimeFormat.forPattern("E, MMM Y h:mm a").print(DateTime.now());
		model.addAttribute("currentTime", currentTime);
		return "staff/edit";
	}
	
	@PreAuthorize("hasRole('STAFF')")
	@RequestMapping(value="/staff/edit/staff/{id}", method={RequestMethod.GET})
	public String requestStaffEditPage(@PathVariable("id") Long id, @ModelAttribute Staff staff, ModelMap model) {
		staff = staffService.findById(id);
		model.addAttribute("staff", staff);
		List<Department> depts = deptService.findAll();
		model.addAttribute("depts", depts);
		Map<String, String> titles = Utils.getTitles();
		model.addAttribute("titles", titles);
		Map<String, String> statuses = Utils.getStatuses();
		model.addAttribute("statuses", statuses);
		String currentStatus = staff.getStatus();
		model.addAttribute("currentStatus", currentStatus);
		return "staff/edit/staff";
	}
	
	@PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER')")
	@RequestMapping(value="/admin/staff/edit/staff/{id}", method={RequestMethod.GET})
	public String requestAdminStaffEditPage(@PathVariable("id") Long id, @ModelAttribute Staff staff, ModelMap model) {
		staff = staffService.findById(id);
		model.addAttribute("staff", staff);
		List<Department> depts = deptService.findAll();
		model.addAttribute("depts", depts);
		Map<String, String> statuses = Utils.getStatuses();
		model.addAttribute("statuses", statuses);
		String currentStatus = staff.getStatus();
		model.addAttribute("currentStatus", currentStatus);
		return "admin/staff/edit/staff";
	}
	
	@PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER')")
	@RequestMapping(value = "/admin/staff/list", method = RequestMethod.GET)
	public String requestStaffList(ModelMap model) {
		List<Staff> staff = staffService.findAll();
		model.addAttribute("staff", staff);
		return "admin/staff/list";
	}
	
	@PreAuthorize("hasRole('STAFF')")
	@RequestMapping(value = "/staff/students/list", method = RequestMethod.GET)
	public String requestStudentsList(ModelMap model) {
		List<Student> students = studentService.findAll();
		model.addAttribute("students", students);
		return "staff/students/list";
	}
	
	@PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER')")
	@RequestMapping(value="/admin/staff/edit/staff/{id}", method={RequestMethod.PUT})
	public String editAdminStaff(@PathVariable("id") Long id, @Valid @ModelAttribute Staff staff, BindingResult result, HttpServletRequest request) throws MessagingException {
		if (!result.hasErrors()) {
			staff = staffService.findById(id);
			this.staffService.updateStaff(staff);
			this.emailService.sendUpdateAdminStaffEmail(staff.getUser().getPrimaryEmail(), staff);
			return "redirect:/admin/staff/edit/staff/" + UrlUtil.encodeUrlPathSegment(staff.getId().toString(), request);
		} else {
			return "redirect:/admin/staff/edit/staff/" + UrlUtil.encodeUrlPathSegment(staff.getId().toString(), request);
		}
	}
	
	@PreAuthorize("hasRole('STAFF')")
	@RequestMapping(value="/staff/edit/staff/{id}", method={RequestMethod.PUT})
	public String editStudent(@Valid @ModelAttribute Staff staff, BindingResult result, HttpServletRequest request) throws MessagingException {
		if (!result.hasErrors()) {
			this.staffService.updateStaff(staff);
			this.emailService.sendUpdateStaffEmail(staff.getUser().getPrimaryEmail(), staff);
			return "redirect:/staff/edit/staff/" + UrlUtil.encodeUrlPathSegment(staff.getId().toString(), request);
		} else {
			return "redirect:/staff/edit/staff/" + UrlUtil.encodeUrlPathSegment(staff.getId().toString(), request);
		}
	}
}
