package com.bitwise.magnolia.web.restful.resource.asm.school;
/**
 *  
 * @author Sika Kay
 * @date 24/02/17
 *
 */
import java.util.List;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import com.bitwise.magnolia.util.DepartmentList;
import com.bitwise.magnolia.web.restful.controller.school.DepartmentController;
import com.bitwise.magnolia.web.restful.resource.school.DepartmentListResource;
import com.bitwise.magnolia.web.restful.resource.school.DepartmentResource;

public class DepartmentListResourceAsm extends ResourceAssemblerSupport<DepartmentList, DepartmentListResource> {

	public DepartmentListResourceAsm() {
		super(DepartmentController.class, DepartmentListResource.class);
	}
	
	@Override
	public DepartmentListResource toResource(DepartmentList deptList) {
		List<DepartmentResource> resList = new DepartmentResourceAsm().toResources(deptList.getDepartments());
		DepartmentListResource finalRes = new DepartmentListResource();
		finalRes.setDepartments(resList);
		return finalRes;
	}

}
