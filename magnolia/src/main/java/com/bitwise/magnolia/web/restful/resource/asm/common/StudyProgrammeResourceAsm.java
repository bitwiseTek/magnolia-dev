package com.bitwise.magnolia.web.restful.resource.asm.common;
/**
 *  
 * @author Sika Kay
 * @date 02/03/17
 *
 */
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import com.bitwise.magnolia.model.common.StudyProgramme;
import com.bitwise.magnolia.web.restful.controller.common.StudyProgrammeController;
import com.bitwise.magnolia.web.restful.resource.common.StudyProgrammeResource;

public class StudyProgrammeResourceAsm extends ResourceAssemblerSupport<StudyProgramme, StudyProgrammeResource> {

	public StudyProgrammeResourceAsm() {
		super(StudyProgrammeController.class, StudyProgrammeResource.class);
	}
	
	@Override
	public StudyProgrammeResource toResource(StudyProgramme programme) {
		StudyProgrammeResource res = new StudyProgrammeResource();
		res.setRid(programme.getId());
		res.setName(programme.getName());
		res.setCode(programme.getCode());
		res.setDescription(programme.getDescription());
		res.setMaxParticipants(programme.getMaxParticipationCount());
		res.setParticipants(programme.getParticipants());
		res.setProgramDays(programme.getProgramDays());
		res.setCreatedAt(programme.getCreatedAtString());
		res.setUpdatedAt(programme.getUpdatedAtString());
		res.setEndDate(programme.getEndDateString());
		res.setCreatedBy(programme.getCreatedBy().getUsername());
		res.setUpdatedBy(programme.getUpdatedBy().getUsername());
		res.setDepartment(programme.getDepartment().getName());
		res.setCourseLength(programme.getCourseLength().getName());
		res.setCategory(programme.getCategory().getName());
		res.setStatus(programme.getStatus());
		res.add(linkTo(methodOn(StudyProgrammeController.class).findProgramme(programme.getId())).withSelfRel());
		return res;
	}

}
