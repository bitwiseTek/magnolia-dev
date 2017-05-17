package com.bitwise.magnolia.web.controller.course;
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
import com.bitwise.magnolia.model.common.AcademicSemester;
import com.bitwise.magnolia.model.common.StudyProgramme;
import com.bitwise.magnolia.model.course.Course;
import com.bitwise.magnolia.model.course.CourseLength;
import com.bitwise.magnolia.model.staff.Staff;
import com.bitwise.magnolia.model.user.User;
import com.bitwise.magnolia.service.common.AcademicSemesterService;
import com.bitwise.magnolia.service.common.StudyProgrammeService;
import com.bitwise.magnolia.service.course.CourseLengthService;
import com.bitwise.magnolia.service.course.CourseService;
import com.bitwise.magnolia.service.staff.StaffService;
import com.bitwise.magnolia.service.user.UserService;
import com.bitwise.magnolia.validation.CourseValidator;
import com.bitwise.magnolia.web.util.UrlUtil;

@Controller
public class MVCCourseController {

	@Autowired
	private CourseService courseService;
	
	@Autowired
	private AcademicSemesterService semesterService;
	
	@Autowired
	private StudyProgrammeService programmeService;
	
	@Autowired
	private CourseLengthService lengthService;
	
	@Autowired
	private StaffService staffService;
	
	@Autowired
	private UserService userService;
	
	@InitBinder("course")
	public void initBinder(WebDataBinder binder) {
		binder.setValidator(new CourseValidator());
	}
	
	@RequestMapping(value="/courses/list", method={RequestMethod.GET})
	public String requestCourses(ModelMap model) {
		List<Course> courses = courseService.findAll();
		model.addAttribute("courses", courses);
		return "courses/list";
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMIN')")
	@RequestMapping(value="/courses/add", method={RequestMethod.GET})
	public String requestAddCourse(ModelMap model) {
		List<CourseLength> lengths = lengthService.findAll();
		model.addAttribute("lengths", lengths);
		List<AcademicSemester> semesters = semesterService.findAllSemesters();
		model.addAttribute("semesters", semesters);
		List<StudyProgramme> programmes = programmeService.findAll();
		model.addAttribute("programmes", programmes);
		List<Staff> staff = staffService.findAll();
		model.addAttribute("staff", staff);
		List<User> users = userService.findAll();
		model.addAttribute("users", users);
		return "courses/add";
	}
	
	@PreAuthorize("hasRole('MANAGER')")
	@RequestMapping(value="/manager/staff/courses/add", method={RequestMethod.GET})
	public String requestAddStaffCourse(ModelMap model) {
		List<CourseLength> lengths = lengthService.findAll();
		model.addAttribute("lengths", lengths);
		List<AcademicSemester> semesters = semesterService.findAllSemesters();
		model.addAttribute("semesters", semesters);
		List<StudyProgramme> programmes = programmeService.findAll();
		model.addAttribute("programmes", programmes);
		List<Staff> staff = staffService.findAll();
		model.addAttribute("staff", staff);
		List<User> users = userService.findAll();
		model.addAttribute("users", users);
		return "manager/staff/courses/add";
	}
	
	@PreAuthorize("hasRole('MANAGER')")
	@RequestMapping(value="/manager/students/courses/add", method={RequestMethod.GET})
	public String requestAddStudentsCourse(ModelMap model) {
		List<CourseLength> lengths = lengthService.findAll();
		model.addAttribute("lengths", lengths);
		List<AcademicSemester> semesters = semesterService.findAllSemesters();
		model.addAttribute("semesters", semesters);
		List<StudyProgramme> programmes = programmeService.findAll();
		model.addAttribute("programmes", programmes);
		List<Staff> staff = staffService.findAll();
		model.addAttribute("staff", staff);
		List<User> users = userService.findAll();
		model.addAttribute("users", users);
		return "manager/students/courses/add";
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMIN')")
	@RequestMapping(value="/courses/edit/course/{id}", method={RequestMethod.GET})
	public String requestEditCourse(@PathVariable("id") Long id, @ModelAttribute Course course, ModelMap model, HttpServletRequest request) {
		course = courseService.findById(id);
		model.addAttribute("course", course);
		List<CourseLength> lengths = lengthService.findAll();
		model.addAttribute("lengths", lengths);
		List<AcademicSemester> semesters = semesterService.findAllSemesters();
		model.addAttribute("semesters", semesters);
		List<StudyProgramme> programmes = programmeService.findAll();
		model.addAttribute("programmes", programmes);
		List<Staff> staff = staffService.findAll();
		model.addAttribute("staff", staff);
		List<User> users = userService.findAll();
		model.addAttribute("users", users);
		Map<String, String> statuses = Utils.getStatuses();
		model.addAttribute("statuses", statuses);
		String currentStatus = course.getStatus();
		model.addAttribute("currentStatus", currentStatus);
		Map<Integer, String> levels = Utils.getLevels();
		model.addAttribute("levels", levels);
		Integer currentLevel = course.getAcademicLevel();
		model.addAttribute("currentLevel", currentLevel);
		Map<String, String> optionalities = Utils.getOptionalities();
		model.addAttribute("optionalities", optionalities);
		String currentOptionality = course.getOptionality();
		model.addAttribute("currentOptionality", currentOptionality);
		Map<Double, String> units = Utils.getUnits();
		model.addAttribute("units", units);
		Double currentUnit = course.getCreditUnit();
		model.addAttribute("currentUnit", currentUnit);
		return "courses/edit/course";
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMIN')")
	@RequestMapping(value="/courses/show/course/{id}", method={RequestMethod.GET})
	public String requestShowCourse(@PathVariable("id") Long id, @ModelAttribute Course course, ModelMap model, HttpServletRequest request) {
		course = courseService.findById(id);
		model.addAttribute("course", course);
		List<CourseLength> lengths = lengthService.findAll();
		model.addAttribute("lengths", lengths);
		List<AcademicSemester> semesters = semesterService.findAllSemesters();
		model.addAttribute("semesters", semesters);
		List<StudyProgramme> programmes = programmeService.findAll();
		model.addAttribute("programmes", programmes);
		List<Staff> staff = staffService.findAll();
		model.addAttribute("staff", staff);
		List<User> users = userService.findAll();
		model.addAttribute("users", users);
		Map<String, String> statuses = Utils.getStatuses();
		model.addAttribute("statuses", statuses);
		String currentStatus = course.getStatus();
		model.addAttribute("currentStatus", currentStatus);
		Map<Integer, String> levels = Utils.getLevels();
		model.addAttribute("levels", levels);
		Integer currentLevel = course.getAcademicLevel();
		model.addAttribute("currentLevel", currentLevel);
		Map<String, String> optionalities = Utils.getOptionalities();
		model.addAttribute("optionalities", optionalities);
		String currentOptionality = course.getOptionality();
		model.addAttribute("currentOptionality", currentOptionality);
		Map<Double, String> units = Utils.getUnits();
		model.addAttribute("units", units);
		Double currentUnit = course.getCreditUnit();
		model.addAttribute("currentUnit", currentUnit);
		return "courses/show/course";
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMIN')")
	@RequestMapping(value="/courses/edit/course/{id}", method={RequestMethod.PUT})
	public String editCourse(@Valid @ModelAttribute Course course, BindingResult result, HttpServletRequest request) {
		if (!result.hasErrors()) {
			this.courseService.update(course);
			return "redirect:/courses/edit/course/" + UrlUtil.encodeUrlPathSegment(course.getId().toString(), request);
		} else {
			return "redirect:/courses/edit/course/" + UrlUtil.encodeUrlPathSegment(course.getId().toString(), request);
		}
	}
}
