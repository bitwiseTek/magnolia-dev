package com.bitwise.magnolia.web.restful.resource.asm.common;
/**
 *  
 * @author Sika Kay
 * @date 02/03/17
 *
 */
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import com.bitwise.magnolia.model.common.AcademicSemester;
import com.bitwise.magnolia.web.restful.controller.common.AcademicSemesterController;
import com.bitwise.magnolia.web.restful.resource.common.AcademicSemesterResource;

public class AcademicSemesterResourceAsm extends ResourceAssemblerSupport<AcademicSemester, AcademicSemesterResource> {

	public AcademicSemesterResourceAsm() {
		super(AcademicSemesterController.class, AcademicSemesterResource.class);
	}
	
	@Override
	public AcademicSemesterResource toResource(AcademicSemester semester) {
		AcademicSemesterResource res = new AcademicSemesterResource();
		res.setRid(semester.getId());
		res.setName(semester.getName());
		res.setSession(semester.getSession());
		res.setStartDate(semester.getStartDateString());
		res.setUpdatedAt(semester.getUpdatedAtString());
		res.setEndDate(semester.getEndDateString());
		res.add(linkTo(methodOn(AcademicSemesterController.class).findSemester(semester.getId())).withSelfRel());
		return res;
	}
}
