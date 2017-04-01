package com.bitwise.magnolia.dao.student;
import java.util.List;

/**
 *  
 * @author Sika Kay
 * @date 24/02/17
 *
 */
import com.bitwise.magnolia.model.student.Student;

public interface StudentDao {

	public Student findById(Long id);
	
	//Get student's record by studentId
	public Student findByStudentId(String studentId);

	//Get student's record by studentApiKey
	public Student findByStudentApiKey(String apiKey);
	
	public List<Student> findStudentsByProgrammeId(Long programmeId);
	
	public List<Student> findStudentsByDepartmentId(Long deptId);
	
	public List<Student> findAllStudents();
	
	public Student save(Student student);

}
