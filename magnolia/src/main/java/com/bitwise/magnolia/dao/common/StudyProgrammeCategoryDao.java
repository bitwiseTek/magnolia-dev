package com.bitwise.magnolia.dao.common;
/**
 *  
 * @author Sika Kay
 * @date 01/03/17
 *
 */
import java.util.List;

/**
 *  
 * @author Sika Kay
 * @date 01/03/17
 *
 */
import com.bitwise.magnolia.common.BaseDao;
import com.bitwise.magnolia.model.common.StudyProgrammeCategory;

public interface StudyProgrammeCategoryDao extends BaseDao<Object> {

	public StudyProgrammeCategory findById(Long id);
	
	public StudyProgrammeCategory findByName(String name);
	
	public List<StudyProgrammeCategory> findAll();
	
	public StudyProgrammeCategory save(StudyProgrammeCategory category);
}
