package com.bitwise.magnolia.web.restful.resource.asm.school;
/**
 *  
 * @author Sika Kay
 * @date 04/03/17
 *
 */
import java.util.List;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import com.bitwise.magnolia.util.CampusList;
import com.bitwise.magnolia.web.restful.controller.school.CampusController;
import com.bitwise.magnolia.web.restful.resource.school.CampusListResource;
import com.bitwise.magnolia.web.restful.resource.school.CampusResource;

public class CampusListResourceAsm extends ResourceAssemblerSupport<CampusList, CampusListResource> {

	public CampusListResourceAsm() {
		super(CampusController.class, CampusListResource.class);
	}
	
	@Override
	public CampusListResource toResource(CampusList campusList) {
		List<CampusResource> resList = new CampusResourceAsm().toResources(campusList.getCampuses());
		CampusListResource finalRes = new CampusListResource();
		finalRes.setCampuses(resList);
		return finalRes;
	}

}
