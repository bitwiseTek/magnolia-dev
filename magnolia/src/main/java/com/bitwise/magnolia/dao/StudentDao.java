package com.bitwise.magnolia.dao;

import com.bitwise.magnolia.common.BaseDao;
import com.bitwise.magnolia.model.Student;

public interface StudentDao extends BaseDao<Student>{

	//Get student's record by studentId
	Student findByStudentId(String studentId);

	//Get student's record by studentApiKey
	Student findByStudentApiKey(String studentApiKey);

}
