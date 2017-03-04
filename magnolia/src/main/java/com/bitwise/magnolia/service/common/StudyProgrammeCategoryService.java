package com.bitwise.magnolia.service.common;
/**
 *  
 * @author Sika Kay
 * @date 02/03/17
 *
 */
import com.bitwise.magnolia.model.common.StudyProgrammeCategory;
import com.bitwise.magnolia.util.ProgrammeCategoryList;

public interface StudyProgrammeCategoryService {

	public StudyProgrammeCategory findById(Long id);
	
	public StudyProgrammeCategory findByName(String name);
	
	public ProgrammeCategoryList findAll();
	
	public StudyProgrammeCategory save(StudyProgrammeCategory category);
}
