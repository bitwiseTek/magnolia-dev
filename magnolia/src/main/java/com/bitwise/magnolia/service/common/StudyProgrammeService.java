package com.bitwise.magnolia.service.common;
import java.util.List;

/**
 *  
 * @author Sika Kay
 * @date 27/02/17
 *
 */
import com.bitwise.magnolia.model.common.StudyProgramme;
import com.bitwise.magnolia.util.ProgrammeList;
/**
 *  
 * @author Sika Kay
 * @date 27/02/17
 *
 */
public interface StudyProgrammeService {

	public StudyProgramme findById(Long id);
	
	public StudyProgramme findByName(String name);
	
	public StudyProgramme findByCode(String code);
	
	public ProgrammeList findProgrammesByDepartmentId(Long deptId);
	
	public ProgrammeList findAllProgrammes();
	
	public List<StudyProgramme> findAll();
	
	public StudyProgramme save(StudyProgramme data);
	
	public StudyProgramme update(StudyProgramme data);
}
