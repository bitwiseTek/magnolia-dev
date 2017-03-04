package com.bitwise.magnolia.web.restful.resource.asm.school;
/**
 *  
 * @author Sika Kay
 * @date 04/03/17
 *
 */
import java.util.List;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import com.bitwise.magnolia.util.SchoolList;
import com.bitwise.magnolia.web.restful.controller.school.SchoolController;
import com.bitwise.magnolia.web.restful.resource.school.SchoolListResource;
import com.bitwise.magnolia.web.restful.resource.school.SchoolResource;

public class SchoolListResourceAsm extends ResourceAssemblerSupport<SchoolList, SchoolListResource> {

	public SchoolListResourceAsm() {
		super(SchoolController.class, SchoolListResource.class);
	}
	
	@Override
	public SchoolListResource toResource(SchoolList schoolList) {
		List<SchoolResource> resList = new SchoolResourceAsm().toResources(schoolList.getSchools());
		SchoolListResource finalRes = new SchoolListResource();
		finalRes.setSchoolResources(resList);
		return finalRes;
	}
}
