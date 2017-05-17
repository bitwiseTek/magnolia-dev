package com.bitwise.magnolia.service.school;
import java.util.List;

/**
 *  
 * @author Sika Kay
 * @date 02/03/17
 *
 */
import com.bitwise.magnolia.model.school.SubSchool;
import com.bitwise.magnolia.util.SubSchoolList;
/**
 *  
 * @author Sika Kay
 * @date 25/03/17
 *
 */
public interface SubSchoolService {

	public SubSchool findById(Long id);
	
	public SubSchool findByName(String name);
	
	public SubSchoolList findSubSchoolsBySchoolId(Long id);
	
	public SubSchoolList findAllSubSchools();
	
	public List<SubSchool> findAll();
	
	public SubSchool save(SubSchool data);
	
	public SubSchool update(SubSchool data);
}
