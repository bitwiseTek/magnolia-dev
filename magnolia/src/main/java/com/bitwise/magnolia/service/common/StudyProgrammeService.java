package com.bitwise.magnolia.service.common;
/**
 *  
 * @author Sika Kay
 * @date 27/02/17
 *
 */
import com.bitwise.magnolia.model.common.StudyProgramme;
import com.bitwise.magnolia.util.ProgrammeList;

public interface StudyProgrammeService {

	public StudyProgramme findById(Long id);
	
	public StudyProgramme findByName(String name);
	
	public StudyProgramme findByCode(String code);
	
	public ProgrammeList findProgrammesByDepartmentId(Long deptId);
	
	public ProgrammeList findAllProgrammes();
	
	public StudyProgramme save(StudyProgramme programme);
}
