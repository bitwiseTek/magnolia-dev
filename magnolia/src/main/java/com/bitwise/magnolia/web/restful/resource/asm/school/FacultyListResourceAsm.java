package com.bitwise.magnolia.web.restful.resource.asm.school;
/**
 *  
 * @author Sika Kay
 * @date 24/02/17
 *
 */
import java.util.List;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import com.bitwise.magnolia.util.FacultyList;
import com.bitwise.magnolia.web.restful.controller.school.FacultyController;
import com.bitwise.magnolia.web.restful.resource.school.FacultyListResource;
import com.bitwise.magnolia.web.restful.resource.school.FacultyResource;

public class FacultyListResourceAsm extends ResourceAssemblerSupport<FacultyList, FacultyListResource> {

	public FacultyListResourceAsm() {
		super(FacultyController.class, FacultyListResource.class);
	}
	
	@Override
	public FacultyListResource toResource(FacultyList facList) {
		List<FacultyResource> resList = new FacultyResourceAsm().toResources(facList.getFaculties());
		FacultyListResource finalRes = new FacultyListResource();
		finalRes.setFaculties(resList);
		return finalRes;
	}

}
