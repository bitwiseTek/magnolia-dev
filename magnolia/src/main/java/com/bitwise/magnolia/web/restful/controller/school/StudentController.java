package com.bitwise.magnolia.web.restful.controller.school;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bitwise.magnolia.dao.common.ApplicationConstant;
import com.bitwise.magnolia.dao.common.Response;
import com.bitwise.magnolia.service.school.DepartmentService;
import com.bitwise.magnolia.service.school.StudentService;
import com.bitwise.magnolia.vo.school.StudentVo;

@RestController
public class StudentController {

	@Autowired
	private DepartmentService departmentService;
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/studentRegistration/getDepartmentByFaculty",
			"**/*" + ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/studentRegistration/getDepartmentByFaculty"}, 
	method = RequestMethod.GET, consumes = "application/json")
	public Response getDepartmentByFacultyId(String apiKey, long facultyId){
		Response response = new Response();
		response = departmentService.getActiveDepartmentsByFacultyId(apiKey, facultyId);
		return response;
	}
	
	@RequestMapping(value = {ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/studentRegistration/registerStudent",
			"**/*" + ApplicationConstant.API +  ApplicationConstant.VERSION + "/" + ApplicationConstant.SCHOOL_ALIAS + "/studentRegistration/registerStudent"}, 
	method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<?> handleUpdate(@RequestBody StudentVo studentVo){
		Response response = new Response();
		response = studentService.validateStudent(studentVo);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
	
	
}
