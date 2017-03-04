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
/**
 *  
 * @author Sika Kay
 * @date 02/03/17
 *
 */
import com.bitwise.magnolia.model.common.StudyProgrammeCategory;
import com.bitwise.magnolia.web.restful.controller.common.StudyProgrammeCategoryController;
import com.bitwise.magnolia.web.restful.resource.common.StudyProgrammeCategoryResource;

public class StudyProgrammeCategoryResourceAsm extends ResourceAssemblerSupport<StudyProgrammeCategory, StudyProgrammeCategoryResource> {

	public StudyProgrammeCategoryResourceAsm() {
		super(StudyProgrammeCategoryController.class, StudyProgrammeCategoryResource.class);
	}

	@Override
	public StudyProgrammeCategoryResource toResource(StudyProgrammeCategory category) {
		StudyProgrammeCategoryResource res = new StudyProgrammeCategoryResource();
		res.setRid(category.getId());
		res.setName(category.getName());
		res.setStatus(category.getStatus());
		res.setCreatedAt(category.getCreatedAt());
		res.setUpdatedAt(category.getUpdatedAt());
		res.add(linkTo(methodOn(StudyProgrammeCategoryController.class).findCategory(category.getId())).withSelfRel());
		return res;
	}
	
	
}
