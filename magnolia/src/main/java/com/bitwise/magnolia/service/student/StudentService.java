package com.bitwise.magnolia.service.student;

import java.util.List;

import com.bitwise.magnolia.model.student.Student;
import com.bitwise.magnolia.util.StudentList;

/**
 *  
 * @author Sika Kay
 * @date 24/02/17
 */

public interface StudentService {

	public Student findById(Long id);
	
	//Get student's record by studentId
	public Student findByStudentId(String studentId);

	//Get student's record by studentApiKey
	public Student findByStudentApiKey(String apiKey);
	
	public StudentList findStudentsByProgrammeId(Long programmeId);
	
	public StudentList findStudentsByDepartmentId(Long deptId);
	
	public StudentList findAllStudents();
	
	public List<Student> findAll();
	
	public Student save(Student data);
	
	public Student updateStudent(Student data);
}
