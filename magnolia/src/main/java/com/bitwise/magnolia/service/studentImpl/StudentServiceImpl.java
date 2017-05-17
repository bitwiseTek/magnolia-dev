package com.bitwise.magnolia.service.studentImpl;
import java.util.List;
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
import com.bitwise.magnolia.exception.EntityDoesNotExistException;
import com.bitwise.magnolia.exception.EntityExistsException;
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
	public Student findByUserId(Long userId) {
		return this.studentDao.findByUserId(userId);
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
	public Student save(Student data) {
		Student student = studentDao.findByUserId(data.getUser().getId());
		if (student != null) {
			throw new EntityExistsException("Student already exists");
		}
		return this.studentDao.save(data);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Student> findAll() {
		return this.studentDao.findAllStudents();
	}

	@Override
	public Student updateStudent(Student data) {
		Student student = studentDao.findById(data.getId());
		try {
			if (student != null) {
				student.setStudentId(data.getStudentId());
				student.setStudentDepartment(data.getStudentDepartment());
				student.setStudyEndReason(data.getStudyEndReason());
				student.setStudyEndText(data.getStudyEndText());
				student.setStudyProgramme(data.getStudyProgramme());
				student.setStudyStatus(data.getStudyStatus());
				student.setApiKey(data.getApiKey());
				student.setLodging(data.getLodging());
				student.setStatus(data.getStatus());
				student.setCourseEnrolmentType(data.getCourseEnrolmentType());
				student.setStartDate(data.getStartDate());
				student.setProgrammeEndDate(data.getProgrammeEndDate());
				student.setActualEndDate(data.getActualEndDate());
				student.setParticipationType(data.getParticipationType());
				student.setUser(data.getUser());
			} else {
				throw new EntityDoesNotExistException("Student does not exist");
			}
		} catch(Exception e) {
			throw new EntityDoesNotExistException("Student does not exist");
		}
		return this.studentDao.update(student);
	}
}
