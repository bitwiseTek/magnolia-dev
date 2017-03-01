package com.bitwise.magnolia.service.studentImpl;
/**
 *  
 * @author Sika Kay
 * @date 24/02/17
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bitwise.magnolia.dao.student.StudentDao;
import com.bitwise.magnolia.model.student.Student;
import com.bitwise.magnolia.service.student.StudentService;
import com.bitwise.magnolia.util.StudentList;

@Transactional
@Service("studentService")
public class StudentServiceImpl implements StudentService{
	
	final Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);
	@Autowired
	private StudentDao studentDao;

	@Override
	@Transactional(readOnly=true)
	public Student findById(Long id) {
		return this.studentDao.findById(id);
	}

	@Override
	@Transactional(readOnly=true)
	public Student findByStudentId(String studentId) {
		return this.studentDao.findByStudentId(studentId);
	}

	@Override
	@Transactional(readOnly=true)
	public Student findByStudentApiKey(String apiKey) {
		return this.studentDao.findByStudentApiKey(apiKey);
	}

	@Override
	@Transactional(readOnly=true)
	public StudentList findStudentsByProgrammeId(Long programmeId) {
		return new StudentList(this.studentDao.findStudentsByProgrammeId(programmeId));
	}

	@Override
	@Transactional(readOnly=true)
	public StudentList findStudentsByDepartmentId(Long deptId) {
		return new StudentList(this.studentDao.findStudentsByDepartmentId(deptId));
	}

	@Override
	@Transactional(readOnly=true)
	public StudentList findAllStudents() {
		return new StudentList(this.studentDao.findAllStudents());
	}

	@Override
	@Transactional(readOnly=false)
	public Student save(Student student) {
		logger.info("Adding student with ID " + student.getId());
		return this.studentDao.save(student);
	}

}
