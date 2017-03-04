package com.bitwise.magnolia.web.restful.resource.asm.student;
/**
 *  
 * @author Sika Kay
 * @date 04/03/17
 *
 */
import java.util.List;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import com.bitwise.magnolia.util.StudentCourseList;
import com.bitwise.magnolia.web.restful.controller.student.StudentCourseController;
import com.bitwise.magnolia.web.restful.resource.student.StudentCourseListResource;
import com.bitwise.magnolia.web.restful.resource.student.StudentCourseResource;

public class StudentCourseListResourceAsm extends ResourceAssemblerSupport<StudentCourseList, StudentCourseListResource> {

	public StudentCourseListResourceAsm() {
		super(StudentCourseController.class, StudentCourseListResource.class);
	}
	
	@Override
	public StudentCourseListResource toResource(StudentCourseList studentCourseList) {
		List<StudentCourseResource> resList = new StudentCourseResourceAsm().toResources(studentCourseList.getStudentCourses());
		StudentCourseListResource finalRes = new StudentCourseListResource();
		finalRes.setStudentCourses(resList);
		return finalRes;
	}

}
