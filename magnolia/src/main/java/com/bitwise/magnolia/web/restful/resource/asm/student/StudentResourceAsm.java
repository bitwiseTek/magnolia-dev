package com.bitwise.magnolia.web.restful.resource.asm.student;
/**
 *  
 * @author Sika Kay
 * @date 04/03/17
 *
 */
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import com.bitwise.magnolia.model.student.Student;
import com.bitwise.magnolia.web.restful.controller.student.StudentController;
import com.bitwise.magnolia.web.restful.resource.student.StudentResource;

public class StudentResourceAsm extends ResourceAssemblerSupport<Student, StudentResource>{

	public StudentResourceAsm() {
		super(StudentController.class, StudentResource.class);
	}
	
	@Override
	public StudentResource toResource(Student student) {
		StudentResource res = new StudentResource();
		res.setRid(student.getId());
		res.setStudentId(student.getStudentId());
		res.setApiKey(student.getApiKey());
		res.setParticipationType(student.getParticipationType());
		res.setCourseEnrolmentType(student.getCourseEnrolmentType());
		res.setStudyEndText(student.getStudyEndText());
		res.setStudyEndReason(student.getStudyEndReason());
		res.setLodging(student.getLodging());
		res.setStatus(student.getStatus());
		res.setStudyStatus(student.getStudyStatus());
		res.setStartDate(student.getStartDateString());
		res.setProgrammeEndDate(student.getStudyProgramme().getEndDateString());
		res.setActualEndDate(student.getActualEndDateString());
		res.setStudentDepartment(student.getStudentDepartment().getName());
		res.setStudyProgramme(student.getStudyProgramme().getName());
		res.setUser(student.getUser().getUsername());
		res.add(linkTo(methodOn(StudentController.class).findStudent(student.getId())).withSelfRel());
		return res;
	}

}
