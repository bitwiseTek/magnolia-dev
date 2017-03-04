package com.bitwise.magnolia.web.restful.resource.asm.school;
/**
 *  
 * @author Sika Kay
 * @date 04/03/17
 *
 */
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import com.bitwise.magnolia.model.school.School;
import com.bitwise.magnolia.web.restful.controller.school.SchoolController;
import com.bitwise.magnolia.web.restful.resource.school.SchoolResource;

public class SchoolResourceAsm extends ResourceAssemblerSupport<School, SchoolResource> {

	public SchoolResourceAsm() {
		super(SchoolController.class, SchoolResource.class);
	}
	
	@Override
	public SchoolResource toResource(School school) {
		SchoolResource res = new SchoolResource();
		res.setRid(school.getSchoolId());
		res.setSchoolName(school.getSchoolName());
		res.setAlias(school.getAlias());
		res.setEmail(school.getEmail());
		res.setApiKey(school.getApiKey());
		res.setSchoolAddress(school.getSchoolAddress());
		res.setSchoolLogo(school.getSchoolLogo());
		res.setStatus(school.getStatus());
		res.setValidDays(school.getValidDays());
		res.setCreatedAt(school.getCreatedAt());
		res.setWebsite(school.getWebsite());
		res.add(linkTo(methodOn(SchoolController.class).findSchool(school.getSchoolId())).withSelfRel());
		return res;
	}

}
