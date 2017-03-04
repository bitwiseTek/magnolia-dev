package com.bitwise.magnolia.web.restful.resource.asm.student;
/**
 *  
 * @author Sika Kay
 * @date 04/03/17
 *
 */
import java.util.List;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import com.bitwise.magnolia.util.StudentList;
import com.bitwise.magnolia.web.restful.controller.student.StudentController;
import com.bitwise.magnolia.web.restful.resource.student.StudentListResource;
import com.bitwise.magnolia.web.restful.resource.student.StudentResource;

public class StudentListResourceAsm extends ResourceAssemblerSupport<StudentList, StudentListResource> {

	public StudentListResourceAsm() {
		super(StudentController.class, StudentListResource.class);
	}
	
	@Override
	public StudentListResource toResource(StudentList studentList) {
		List<StudentResource> resList = new StudentResourceAsm().toResources(studentList.getStudents());
		StudentListResource finalRes = new StudentListResource();
		finalRes.setStudents(resList);
		return finalRes;
	}

}
