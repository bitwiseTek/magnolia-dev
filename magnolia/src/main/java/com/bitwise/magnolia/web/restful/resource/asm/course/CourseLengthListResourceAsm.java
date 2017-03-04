package com.bitwise.magnolia.web.restful.resource.asm.course;
/**
 *  
 * @author Sika Kay
 * @date 03/03/17
 *
 */
import java.util.List;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import com.bitwise.magnolia.util.CourseLengthList;
import com.bitwise.magnolia.web.restful.controller.course.CourseLengthController;
import com.bitwise.magnolia.web.restful.resource.course.CourseLengthListResource;
import com.bitwise.magnolia.web.restful.resource.course.CourseLengthResource;

public class CourseLengthListResourceAsm extends ResourceAssemblerSupport<CourseLengthList, CourseLengthListResource> {

	public CourseLengthListResourceAsm() {
		super(CourseLengthController.class, CourseLengthListResource.class);
	}
	
	@Override
	public CourseLengthListResource toResource(CourseLengthList lengthList) {
		List<CourseLengthResource> resList = new CourseLengthResourceAsm().toResources(lengthList.getLengths());
		CourseLengthListResource finalRes = new CourseLengthListResource();
		finalRes.setLengths(resList);
		return finalRes;
	}

}
