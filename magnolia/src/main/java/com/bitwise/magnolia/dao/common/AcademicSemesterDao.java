package com.bitwise.magnolia.dao.common;
/**
 *  
 * @author Sika Kay
 * @date 26/02/17
 *
 */
import java.util.List;

import com.bitwise.magnolia.common.BaseDao;
import com.bitwise.magnolia.model.common.AcademicSemester;

public interface AcademicSemesterDao extends BaseDao<Object> {

	public AcademicSemester findById(Long id);
	
	public AcademicSemester findByName(String name);
	
	public List<AcademicSemester> findAll();
	
	public AcademicSemester save(AcademicSemester semester);
}
