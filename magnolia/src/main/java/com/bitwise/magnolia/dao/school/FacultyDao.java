package com.bitwise.magnolia.dao;

import java.util.List;

import com.bitwise.magnolia.common.BaseDao;
import com.bitwise.magnolia.model.Faculty;

public interface FacultyDao extends BaseDao<Faculty>{

	//Gets a list of active Faculties with type @see #Faculty 
	public List<Faculty> fetchActiveFaculties(String schoolAlias);
	
}
