package com.bitwise.magnolia.web.restful.resource.asm.staff;
/**
 *  
 * @author Sika Kay
 * @date 04/03/17
 *
 */
import java.util.List;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import com.bitwise.magnolia.util.StaffList;
import com.bitwise.magnolia.web.restful.controller.staff.StaffController;
import com.bitwise.magnolia.web.restful.resource.staff.StaffListResource;
import com.bitwise.magnolia.web.restful.resource.staff.StaffResource;

public class StaffListResourceAsm extends ResourceAssemblerSupport<StaffList, StaffListResource> {

	public StaffListResourceAsm() {
		super(StaffController.class, StaffListResource.class);
	}
	
	@Override
	public StaffListResource toResource(StaffList staffList) {
		List<StaffResource> resList = new StaffResourceAsm().toResources(staffList.getStaff());
		StaffListResource finalRes = new StaffListResource();
		finalRes.setStaff(resList);
		return finalRes;
	}

}
