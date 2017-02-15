package com.bitwise.magnolia.dao.school;

import java.util.List;

import com.bitwise.magnolia.dao.common.BaseDao;
import com.bitwise.magnolia.domain.school.Faculty;

public interface FacultyDao extends BaseDao<Faculty>{

	//Gets a list of active Faculties with type @see #Faculty 
	public List<Faculty> fetchActiveFaculties(String schoolAlias);
	
}
