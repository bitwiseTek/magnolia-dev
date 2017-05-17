package com.bitwise.magnolia.dao.school;
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
import com.bitwise.magnolia.model.school.SubSchool;

public interface SubSchoolDao {

	public SubSchool findById(Long id);
	
	public SubSchool findByName(String name);
	
	public List<SubSchool> findSubSchoolsBySchoolId(Long schoolId);
	
	public List<SubSchool> findAllSubSchools();
	
	public SubSchool save(SubSchool school);
	
	public SubSchool update(SubSchool school);
}
