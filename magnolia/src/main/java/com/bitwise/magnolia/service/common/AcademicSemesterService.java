package com.bitwise.magnolia.service.common;
import java.util.List;

/**
 *  
 * @author Sika Kay
 * @date 27/02/17
 *
 */
import com.bitwise.magnolia.model.common.AcademicSemester;
import com.bitwise.magnolia.util.SemesterList;

public interface AcademicSemesterService {

	public AcademicSemester findById(Long id);
	
	public AcademicSemester findByName(String name);
	
	public List<AcademicSemester> findAllSemesters();
	
	public SemesterList findAll();
	
	public AcademicSemester save(AcademicSemester semester);
}
