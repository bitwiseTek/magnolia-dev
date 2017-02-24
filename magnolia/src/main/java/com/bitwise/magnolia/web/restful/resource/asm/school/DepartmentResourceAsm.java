package com.bitwise.magnolia.web.restful.resource.asm.school;
/**
 *  
 * @author Sika Kay
 * @date 24/02/17
 *
 */
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import com.bitwise.magnolia.model.school.Department;
import com.bitwise.magnolia.web.controller.common.LGAController;
import com.bitwise.magnolia.web.controller.school.DepartmentController;
import com.bitwise.magnolia.web.restful.resource.school.DepartmentResource;

public class DepartmentResourceAsm extends ResourceAssemblerSupport<Department, DepartmentResource> {

	public DepartmentResourceAsm() {
		super(DepartmentController.class, DepartmentResource.class);
	}
	
	@Override
	public DepartmentResource toResource(Department dept) {
		DepartmentResource res = new DepartmentResource();
		res.setCreatedAt(dept.getCreatedAt());
		res.setUpdatedAt(dept.getUpdatedAt());
		res.setRid(dept.getDepartmentId());
		res.setName(dept.getName());
		res.setStatus(dept.getStatus());
		res.setFaculty(dept.getFaculty().getName());
		res.add(linkTo(methodOn(DepartmentController.class).findDept(dept.getDepartmentId())).withSelfRel());
		return res;
	}

}
