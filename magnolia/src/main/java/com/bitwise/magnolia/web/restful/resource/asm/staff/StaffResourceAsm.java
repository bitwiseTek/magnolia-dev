package com.bitwise.magnolia.web.restful.resource.asm.staff;
/**
 *  
 * @author Sika Kay
 * @date 04/03/17
 *
 */
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import com.bitwise.magnolia.model.staff.Staff;
import com.bitwise.magnolia.web.restful.controller.staff.StaffController;
import com.bitwise.magnolia.web.restful.resource.staff.StaffResource;

public class StaffResourceAsm extends ResourceAssemblerSupport<Staff, StaffResource> {

	public StaffResourceAsm() {
		super(StaffController.class, StaffResource.class);
	}
	
	@Override
	public StaffResource toResource(Staff staff) {
		StaffResource res = new StaffResource();
		res.setRid(staff.getId());
		res.setApiKey(staff.getApiKey());
		res.setIsTemp(staff.getIsTemporary());
		res.setIsAcademic(staff.getIsAcademic());
		res.setTitle(staff.getTitle());
		res.setStaffId(staff.getStaffId());
		res.setStatus(staff.getStatus());
		res.setStaffDepartment(staff.getStaffDepartment().getName());
		res.setUser(staff.getUser().getUsername());
		res.add(linkTo(methodOn(StaffController.class).findStaff(staff.getId())).withSelfRel());
		return res;
	}

}
