package com.bitwise.magnolia.web.restful.resource.asm.common;
/**
 *  
 * @author Sika Kay
 * @date 02/03/17
 *
 */
import java.util.List;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import com.bitwise.magnolia.util.ProgrammeCategoryList;
import com.bitwise.magnolia.web.restful.controller.common.StudyProgrammeCategoryController;
import com.bitwise.magnolia.web.restful.resource.common.StudyProgrammeCategoryListResource;
import com.bitwise.magnolia.web.restful.resource.common.StudyProgrammeCategoryResource;

public class StudyProgrammeCategoryListResourceAsm extends ResourceAssemblerSupport<ProgrammeCategoryList, StudyProgrammeCategoryListResource>{

	public StudyProgrammeCategoryListResourceAsm() {
		super(StudyProgrammeCategoryController.class, StudyProgrammeCategoryListResource.class);
	}
	@Override
	public StudyProgrammeCategoryListResource toResource(ProgrammeCategoryList categoryList) {
		List<StudyProgrammeCategoryResource> resList = new StudyProgrammeCategoryResourceAsm().toResources(categoryList.getCategories());
		StudyProgrammeCategoryListResource finalRes = new StudyProgrammeCategoryListResource();
		finalRes.setCategories(resList);
		return finalRes;
	}

}
