package com.bitwise.magnolia.dao.common;
/**
 *  
 * @author Sika Kay
 * @date 01/03/17
 *
 */
import java.util.List;

import com.bitwise.magnolia.model.common.StudyProgramme;

public interface StudyProgrammeDao {

	public StudyProgramme findById(Long id);
	
	public StudyProgramme findByName(String name);
	
	public StudyProgramme findByCode(String code);
	
	public List<StudyProgramme> findProgrammesByDepartmentId(Long deptId);
	
	public List<StudyProgramme> findByCategoryId(Long categoryId);
	
	public List<StudyProgramme> findAllProgrammes();
	
	public StudyProgramme save(StudyProgramme programme);
}
