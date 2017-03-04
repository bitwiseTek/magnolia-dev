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

import com.bitwise.magnolia.model.school.Campus;
import com.bitwise.magnolia.web.restful.controller.school.CampusController;
import com.bitwise.magnolia.web.restful.resource.school.CampusResource;

public class CampusResourceAsm extends ResourceAssemblerSupport<Campus, CampusResource> {

	public CampusResourceAsm() {
		super(CampusController.class, CampusResource.class);
	}
	
	@Override
	public CampusResource toResource(Campus campus) {
		CampusResource res =  new CampusResource();
		res.setRid(campus.getCampusId());
		res.setName(campus.getName());
		res.setStatus(campus.getStatus());
		res.setCreatedAt(campus.getCreatedAt());
		res.setUpdatedAt(campus.getUpdatedAt());
		res.setSubSchool(campus.getSubSchool().getName());
		res.add(linkTo(methodOn(CampusController.class).findCampus(campus.getCampusId())).withSelfRel());
		return res;
	}

}
