package com.bitwise.magnolia.web.restful.resource.asm.school;
/**
 *  
 * @author Sika Kay
 * @date 24/02/17
 *
 */
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import com.bitwise.magnolia.model.school.Faculty;
import com.bitwise.magnolia.web.controller.school.FacultyController;
import com.bitwise.magnolia.web.restful.resource.school.FacultyResource;

public class FacultyResourceAsm extends ResourceAssemblerSupport<Faculty, FacultyResource> {

	public FacultyResourceAsm() {
		super(FacultyController.class, FacultyResource.class);
	}
	
	@Override
	public FacultyResource toResource(Faculty faculty) {
		FacultyResource res = new FacultyResource();
		res.setRid(faculty.getFacultyId());
		res.setCreatedAt(faculty.getCreatedAt());
		res.setUpdatedAt(faculty.getUpdatedAt());
		res.setName(faculty.getName());
		res.setStatus(faculty.getStatus());
		res.setCampus(faculty.getCampus().getName());
		res.add(linkTo(methodOn(FacultyController.class).findFaculty(faculty.getFacultyId())).withSelfRel());
		return res;
	}

}
