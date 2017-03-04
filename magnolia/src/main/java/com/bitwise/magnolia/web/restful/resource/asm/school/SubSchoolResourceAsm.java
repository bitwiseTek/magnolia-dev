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

import com.bitwise.magnolia.model.school.SubSchool;
import com.bitwise.magnolia.web.restful.controller.school.SubSchoolController;
import com.bitwise.magnolia.web.restful.resource.school.SubSchoolResource;

public class SubSchoolResourceAsm extends ResourceAssemblerSupport<SubSchool, SubSchoolResource> {

	public SubSchoolResourceAsm() {
		super(SubSchoolController.class, SubSchoolResource.class);
	}
	
	@Override
	public SubSchoolResource toResource(SubSchool subSchool) {
		SubSchoolResource res = new SubSchoolResource();
		res.setRid(subSchool.getSubSchoolId());
		res.setName(subSchool.getName());
		res.setAddress(subSchool.getAddress());
		res.setStatus(subSchool.getStatus());
		res.setType(subSchool.getType());
		res.setCreatedAt(subSchool.getCreatedAt());
		res.setSchool(subSchool.getSchool().getSchoolName());
		res.add(linkTo(methodOn(SubSchoolController.class).findSubSchool(subSchool.getSubSchoolId())).withSelfRel());
		return res;
	}

}
