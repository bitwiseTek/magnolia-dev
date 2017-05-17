package com.bitwise.magnolia.dao.common;
/**
 *  
 * @author Sika Kay
 * @date 01/03/17
 *
 */
import java.util.List;

import com.bitwise.magnolia.model.common.StudyProgrammeCategory;

public interface StudyProgrammeCategoryDao {

	public StudyProgrammeCategory findById(Long id);
	
	public StudyProgrammeCategory findByName(String name);
	
	public List<StudyProgrammeCategory> findAll();
	
	public StudyProgrammeCategory save(StudyProgrammeCategory category);
	
	public StudyProgrammeCategory update(StudyProgrammeCategory category);
}
