package com.bitwise.magnolia.web.restful.resource.asm.course;
/**
 *  
 * @author Sika Kay
 * @date 03/03/17
 *
 */
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import com.bitwise.magnolia.model.course.CourseLength;
import com.bitwise.magnolia.web.restful.controller.course.CourseLengthController;
import com.bitwise.magnolia.web.restful.resource.course.CourseLengthResource;

public class CourseLengthResourceAsm extends ResourceAssemblerSupport<CourseLength, CourseLengthResource> {

	public CourseLengthResourceAsm() {
		super(CourseLengthController.class, CourseLengthResource.class);
	}
	
	@Override
	public CourseLengthResource toResource(CourseLength length) {
		CourseLengthResource res = new CourseLengthResource();
		res.setRid(length.getId());
		res.setName(length.getName());
		res.settCH(length.gettCH());
		res.settCU(length.gettCU());
		res.add(linkTo(methodOn(CourseLengthController.class).findLength(length.getId())).withSelfRel());
		return res;
	}

}
