package com.bitwise.magnolia.web.controller.student;
/**
 *  
 * @author Sika Kay
 * @date 16/04/17
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
import com.bitwise.magnolia.model.student.Student;
import com.bitwise.magnolia.model.user.User;
import com.bitwise.magnolia.service.common.StudyProgrammeService;
//import com.bitwise.magnolia.service.email.EmailService;
import com.bitwise.magnolia.service.school.DepartmentService;
import com.bitwise.magnolia.service.student.StudentService;
import com.bitwise.magnolia.service.user.UserService;
import com.bitwise.magnolia.validation.StudentValidator;
import com.bitwise.magnolia.web.util.UrlUtil;

@Controller
public class MVCStudentController {

	@Autowired
	private StudentService studentService;
	
	@Autowired
	private DepartmentService deptService;
	
	@Autowired
	private StudyProgrammeService programmeService;
	
	@Autowired
	private UserService userService;
	
	/*@Autowired
	private EmailService emailService;*/
	
	@InitBinder("student")
	public void initBinder(WebDataBinder binder) {
		binder.setValidator(new StudentValidator());
	}
	
	@PreAuthorize("hasRole('STUDENT')")
	@RequestMapping(value="/students/register", method=RequestMethod.GET)
	public String requestStudentRegisterPage(ModelMap model) {
		List<Department> depts = deptService.findAll();
		model.addAttribute("depts", depts);
		List<StudyProgramme> programmes = programmeService.findAll();
		model.addAttribute("programmes", programmes);
		List<User> users = userService.findAll();
		model.addAttribute("users", users);
		return "students/register";
	}
	
	@PreAuthorize("hasRole('STUDENT')")
	@RequestMapping(value="/students/edit", method=RequestMethod.GET)
	public String requestEditStudentPage(ModelMap model) {
		List<Student> students = studentService.findAll();
		model.addAttribute("students", students);
		String currentTime = org.joda.time.format.DateTimeFormat.forPattern("E, MMM Y h:mm a").print(DateTime.now());
		model.addAttribute("currentTime", currentTime);
		return "students/edit";
	}
	
	@PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER')")
	@RequestMapping(value="/admin/students/edit", method=RequestMethod.GET)
	public String requestEdiAdminStudentPage(ModelMap model) {
		List<Student> students = studentService.findAll();
		model.addAttribute("students", students);
		String currentTime = org.joda.time.format.DateTimeFormat.forPattern("E, MMM Y h:mm a").print(DateTime.now());
		model.addAttribute("currentTime", currentTime);
		return "admin/students/edit";
	}
	
	@PreAuthorize("hasRole('STUDENT')")
	@RequestMapping(value="/students/edit/student/{id}", method={RequestMethod.GET})
	public String requestStudentEditPage(@PathVariable("id") Long id, @ModelAttribute Student student, ModelMap model) {
		student = studentService.findById(id);
		model.addAttribute("student", student);
		List<Department> depts = deptService.findAll();
		model.addAttribute("depts", depts);
		String username = student.getUser().getUsername();
		model.addAttribute("username", username);
		List<StudyProgramme> programmes = programmeService.findAll();
		model.addAttribute("programmes", programmes);
		Map<String, String> enrolTypes = Utils.getEnrolmentTypes();
		model.addAttribute("enrolTypes", enrolTypes);
		String currentEnrolType = student.getCourseEnrolmentType();
		model.addAttribute("currentEnrolType", currentEnrolType);
		Map<String, String> partTypes = Utils.getPartTypes();
		model.addAttribute("partTypes", partTypes);
		String currentPartType = student.getParticipationType();
		model.addAttribute("currentPartType", currentPartType);
		Map<String, String> lodgings = Utils.getLodgings();
		model.addAttribute("lodgings", lodgings);
		String currentLodging = student.getLodging();
		model.addAttribute("currentLodging", currentLodging);
		Map<String, String> endReasons = Utils.getEndReasons();
		model.addAttribute("endReasons", endReasons);
		String currentEndReason = student.getStudyEndReason();
		model.addAttribute("currentEndReason", currentEndReason);
		return "students/edit/student";
	}
	
	@PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER')")
	@RequestMapping(value="/admin/students/edit/student/{id}", method={RequestMethod.GET})
	public String requestAdminStudentEditPage(@PathVariable("id") Long id, @ModelAttribute Student student, ModelMap model) {
		student = studentService.findById(id);
		model.addAttribute("student", student);
		List<Department> depts = deptService.findAll();
		model.addAttribute("depts", depts);
		String username = student.getUser().getUsername();
		model.addAttribute("username", username);
		List<StudyProgramme> programmes = programmeService.findAll();
		model.addAttribute("programmes", programmes);
		Map<String, String> enrolTypes = Utils.getEnrolmentTypes();
		model.addAttribute("enrolTypes", enrolTypes);
		String currentEnrolType = student.getCourseEnrolmentType();
		model.addAttribute("currentEnrolType", currentEnrolType);
		Map<String, String> partTypes = Utils.getPartTypes();
		model.addAttribute("partTypes", partTypes);
		String currentPartType = student.getParticipationType();
		model.addAttribute("currentPartType", currentPartType);
		Map<String, String> lodgings = Utils.getLodgings();
		model.addAttribute("lodgings", lodgings);
		String currentLodging = student.getLodging();
		model.addAttribute("currentLodging", currentLodging);
		Map<String, String> statuses = Utils.getStatuses();
		model.addAttribute("statuses", statuses);
		String currentStatus = student.getStatus();
		model.addAttribute("currentStatus", currentStatus);
		Map<String, String> endReasons = Utils.getEndReasons();
		model.addAttribute("endReasons", endReasons);
		String currentEndReason = student.getStudyEndReason();
		model.addAttribute("currentEndReason", currentEndReason);
		String disabled = "true";
		model.addAttribute("disabled", disabled);
		return "admin/students/edit/student";
	}
	
	@PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER')")
	@RequestMapping(value = "/admin/students/list", method = RequestMethod.GET)
	public String requestStudentsList(ModelMap model) {
		List<Student> students = studentService.findAll();
		model.addAttribute("students", students);
		return "admin/students/list";
	}
	
	@PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER')")
	@RequestMapping(value="/admin/students/edit/student/{id}", method={RequestMethod.PUT})
	public String editAdminStudent(@PathVariable("id") Long id, @Valid @ModelAttribute Student student, BindingResult result, HttpServletRequest request) throws MessagingException {
		if (!result.hasErrors()) {
			this.studentService.updateStudent(student);
			//this.emailService.sendUpdateAdminStudentEmail(student.getUser().getPrimaryEmail(), student);
			return "redirect:/admin/students/edit/student/" + UrlUtil.encodeUrlPathSegment(student.getId().toString(), request);
		} else {
			return "redirect:/admin/students/edit/student/" + UrlUtil.encodeUrlPathSegment(student.getId().toString(), request);
		}
	}
	
	@PreAuthorize("hasRole('STUDENT')")
	@RequestMapping(value="/students/edit/student/{id}", method={RequestMethod.PUT})
	public String editStudent(@Valid @ModelAttribute Student student, BindingResult result, HttpServletRequest request) throws MessagingException {
		if (!result.hasErrors()) {
			this.studentService.updateStudent(student);
			//this.emailService.sendUpdateStudentEmail(student.getUser().getPrimaryEmail(), student);
			return "redirect:/students/edit/student/" + UrlUtil.encodeUrlPathSegment(student.getId().toString(), request);
		} else {
			return "redirect:/students/edit/student/" + UrlUtil.encodeUrlPathSegment(student.getId().toString(), request);
		}
	}
}
