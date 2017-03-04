package com.bitwise.magnolia.web.restful.resource.asm.common;
/**
 *  
 * @author Sika Kay
 * @date 02/03/17
 *
 */
import java.util.List;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import com.bitwise.magnolia.util.ProgrammeList;
import com.bitwise.magnolia.web.restful.controller.common.StudyProgrammeController;
import com.bitwise.magnolia.web.restful.resource.common.StudyProgrammeListResource;
import com.bitwise.magnolia.web.restful.resource.common.StudyProgrammeResource;

public class StudyProgrammeListResourceAsm extends ResourceAssemblerSupport<ProgrammeList, StudyProgrammeListResource> {

	public StudyProgrammeListResourceAsm() {
		super(StudyProgrammeController.class, StudyProgrammeListResource.class);
	}
	
	@Override
	public StudyProgrammeListResource toResource(ProgrammeList programmeList) {
		List<StudyProgrammeResource> resList = new StudyProgrammeResourceAsm().toResources(programmeList.getProgrammes());
		StudyProgrammeListResource finalRes = new StudyProgrammeListResource();
		finalRes.setProgrammes(resList);
		return finalRes;
	}

}
