package com.bitwise.magnolia.dao.school;
/**
 *  
 * @author Sika Kay
 * @date 24/02/17
 *
 */
import com.bitwise.magnolia.common.BaseDao;
import com.bitwise.magnolia.model.school.Student;

public interface StudentDao extends BaseDao<Student>{

	//Get student's record by studentId
	Student findByStudentId(String studentId);

	//Get student's record by studentApiKey
	Student findByStudentApiKey(String studentApiKey);

}
