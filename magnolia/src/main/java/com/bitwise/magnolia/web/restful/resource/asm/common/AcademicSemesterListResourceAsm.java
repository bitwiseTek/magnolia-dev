package com.bitwise.magnolia.web.restful.resource.asm.common;
/**
 *  
 * @author Sika Kay
 * @date 02/03/17
 *
 */
import java.util.List;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import com.bitwise.magnolia.util.SemesterList;
import com.bitwise.magnolia.web.restful.controller.common.AcademicSemesterController;
import com.bitwise.magnolia.web.restful.resource.common.AcademicSemesterListResource;
import com.bitwise.magnolia.web.restful.resource.common.AcademicSemesterResource;

public class AcademicSemesterListResourceAsm extends ResourceAssemblerSupport<SemesterList, AcademicSemesterListResource> {

	public AcademicSemesterListResourceAsm() {
		super(AcademicSemesterController.class, AcademicSemesterListResource.class);
	}
	
	@Override
	public AcademicSemesterListResource toResource(SemesterList semList) {
		List<AcademicSemesterResource> resList = new AcademicSemesterResourceAsm().toResources(semList.getSemesters());
		AcademicSemesterListResource finalRes = new AcademicSemesterListResource();
		finalRes.setSemesters(resList);
		return finalRes;
	}

}
