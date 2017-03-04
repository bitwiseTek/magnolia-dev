package com.bitwise.magnolia.web.restful.resource.asm.school;
/**
 *  
 * @author Sika Kay
 * @date 04/03/17
 *
 */
import java.util.List;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import com.bitwise.magnolia.util.SubSchoolList;
import com.bitwise.magnolia.web.restful.controller.school.SubSchoolController;
import com.bitwise.magnolia.web.restful.resource.school.SubSchoolListResource;
import com.bitwise.magnolia.web.restful.resource.school.SubSchoolResource;

public class SubSchoolListResourceAsm extends ResourceAssemblerSupport<SubSchoolList, SubSchoolListResource>{

	public SubSchoolListResourceAsm() {
		super(SubSchoolController.class, SubSchoolListResource.class);
	}
	
	@Override
	public SubSchoolListResource toResource(SubSchoolList subSchoolList) {
		List<SubSchoolResource> resList = new SubSchoolResourceAsm().toResources(subSchoolList.getSubSchools());
		SubSchoolListResource finalRes = new SubSchoolListResource();
		finalRes.setSchools(resList);
		return finalRes;
	}

}
