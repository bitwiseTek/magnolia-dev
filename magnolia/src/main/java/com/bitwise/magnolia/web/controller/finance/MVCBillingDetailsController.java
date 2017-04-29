package com.bitwise.magnolia.web.controller.finance;
/**
 *  
 * @author Sika Kay
 * @date 25/04/17
 *
 */
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
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
import com.bitwise.magnolia.model.finance.BillingDetails;
import com.bitwise.magnolia.model.student.Student;
import com.bitwise.magnolia.model.user.User;
import com.bitwise.magnolia.service.common.AcademicSemesterService;
import com.bitwise.magnolia.service.email.EmailService;
import com.bitwise.magnolia.service.finance.BillingDetailsService;
import com.bitwise.magnolia.service.student.StudentService;
import com.bitwise.magnolia.service.user.UserService;
import com.bitwise.magnolia.validation.StudentValidator;
import com.bitwise.magnolia.web.util.UrlUtil;

@Controller
public class MVCBillingDetailsController {

	@Autowired
	private BillingDetailsService billingService;
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AcademicSemesterService semesterService;
	
	@Autowired
	private EmailService emailService;
	
	@InitBinder("billing")
	public void initBinder(WebDataBinder binder) {
		binder.setValidator(new StudentValidator());
	}
	
	@PreAuthorize("hasRole('STUDENT')")
	@RequestMapping(value="/students/billing/pay", method=RequestMethod.GET)
	public String requestBillingPage(ModelMap model) {
		List<BillingDetails> bills = billingService.findAll();
		model.addAttribute("bills", bills);
		List<Student> students = studentService.findAll();
		model.addAttribute("students", students);
		List<User> users = userService.findAll();
		model.addAttribute("users", users);
		List<AcademicSemester> semesters = semesterService.findAllSemesters();
		model.addAttribute("semesters", semesters);
		return "students/billing/pay";
	}
	
	@PreAuthorize("hasRole('STUDENT')")
	@RequestMapping(value="/students/billing/pay/review/{id}", method=RequestMethod.GET)
	public String requestBillingReviewPage(@PathVariable("id") Long id, ModelMap model) {
		BillingDetails bill = new BillingDetails();
		bill = billingService.findById(id);
		model.addAttribute("bill", bill);
		List<BillingDetails> bills = billingService.findAll();
		model.addAttribute("bills", bills);
		List<Student> students = studentService.findAll();
		model.addAttribute("students", students);
		List<User> users = userService.findAll();
		model.addAttribute("users", users);
		List<AcademicSemester> semesters = semesterService.findAllSemesters();
		model.addAttribute("semesters", semesters);
		return "students/billing/pay/review";
	}
	
	@PreAuthorize("hasRole('MANAGER') or hasRole('ACCOUNTANT')")
	@RequestMapping(value="/finance/billing/status/edit/{id}", method={RequestMethod.GET})
	public String requestEditStudentBillingPage(@PathVariable("id") Long id, @ModelAttribute BillingDetails bill, ModelMap model) {
		bill = billingService.findById(id);
		model.addAttribute("bill", bill);
		Map<String, String> statuses = Utils.getStatuses();
		model.addAttribute("statuses", statuses);
		String currentStatus = bill.getStatus();
		model.addAttribute("currentStatus", currentStatus);
		Map<String, String> statements = Utils.getStatements();
		model.addAttribute("statements", statements);
		String currentStatement = bill.getStatement();
		model.addAttribute("currentStatement", currentStatement);
		return "finance/billing/status/edit";
	}
	
	@PreAuthorize("hasRole('MANAGER') or hasRole('ACCOUNTANT')")
	@RequestMapping(value="/finance/billing/status", method=RequestMethod.GET)
	public String requestAdminBillingStatusPage(ModelMap model) {
		List<BillingDetails> bills = billingService.findAll();
		model.addAttribute("bills", bills);
		return "finance/billing/status";
	}
	
	@PreAuthorize("hasRole('STUDENT')")
	@RequestMapping(value="/students/billing/status", method=RequestMethod.GET)
	public String requestBillingStatusPage(ModelMap model) {
		List<BillingDetails> bills = billingService.findAll();
		model.addAttribute("bills", bills);
		return "students/billing/status";
	}
	
	@PreAuthorize("hasRole('STUDENT')")
	@RequestMapping(value="/students/billing/status/view/{id}", method=RequestMethod.GET)
	public String requestBillingStatusViewPage(@PathVariable("id") Long id, @ModelAttribute BillingDetails bill, ModelMap model) {
		bill = billingService.findById(id);
		model.addAttribute("bill", bill);
		Map<String, String> statuses = Utils.getStatuses();
		model.addAttribute("statuses", statuses);
		String currentStatus = bill.getStatus();
		model.addAttribute("currentStatus", currentStatus);
		Map<String, String> statements = Utils.getStatements();
		model.addAttribute("statements", statements);
		String currentStatement = bill.getStatement();
		model.addAttribute("currentStatement", currentStatement);
		return "students/billing/status/view";
	}
	
	@PreAuthorize("hasRole('MANAGER') or hasRole('ACCOUNTANT')")
	@RequestMapping(value="/finance/billing/status/edit/{id}", method={RequestMethod.PUT})
	public String editSystemUser(@PathVariable("id") Long id, @Valid @ModelAttribute BillingDetails bill, BindingResult result, HttpServletRequest request) throws MessagingException {
		if (!result.hasErrors()) {
			bill = billingService.findById(id);
			this.billingService.update(bill);
			this.emailService.sendUpdateAdminBillingEmail(bill.getUserId().getPrimaryEmail(), bill);
			return "redirect:/finance/billing/status/edit/" + UrlUtil.encodeUrlPathSegment(bill.getId().toString(), request);
		} else {
			return "redirect:/finance/billing/status/edit/" + UrlUtil.encodeUrlPathSegment(bill.getId().toString(), request);
		}
	}
}
