package com.bitwise.magnolia.service.common;
import java.util.List;

/**
 *  
 * @author Sika Kay
 * @date 02/03/17
 *
 */
import com.bitwise.magnolia.model.common.StudyProgrammeCategory;
import com.bitwise.magnolia.util.ProgrammeCategoryList;
/**
 *  
 * @author Sika Kay
 * @date 27/02/17
 *
 */
public interface StudyProgrammeCategoryService {

	public StudyProgrammeCategory findById(Long id);
	
	public StudyProgrammeCategory findByName(String name);
	
	public ProgrammeCategoryList findAll();
	
	public List<StudyProgrammeCategory> findAllCategories();
	
	public StudyProgrammeCategory save(StudyProgrammeCategory category);
}
