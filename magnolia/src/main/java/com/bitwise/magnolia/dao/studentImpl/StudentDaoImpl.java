package com.bitwise.magnolia.dao.studentImpl;
/**
 *  
 * @author Sika Kay
 * @date 27/02/17
 *
 */
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.bitwise.magnolia.common.AbstractDao;
import com.bitwise.magnolia.dao.student.StudentDao;
import com.bitwise.magnolia.model.student.Student;

@Repository("studentDao")
public class StudentDaoImpl extends AbstractDao<Object> implements StudentDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Student findByStudentId(String studentId) {
		TypedQuery<Student> query = em.createNamedQuery("Student.findByStudentId", Student.class).setParameter("studentId", studentId);
		List<Student> students = query.getResultList();
		return students.size() == 1 ? students.get(0) : null;
	}

	@Override
	public Student findByStudentApiKey(String apiKey) {
		TypedQuery<Student> query = em.createNamedQuery("Student.findByApiKey", Student.class).setParameter("apiKey", apiKey);
		List<Student> students = query.getResultList();
		return students.size() == 1 ? students.get(0) : null;
	}

	@Override
	public Student findById(Long id) {
		return this.em.createNamedQuery("Student.findById", Student.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public List<Student> findStudentsByProgrammeId(Long programmeId) {
		TypedQuery<Student> query = em.createNamedQuery("Student.findByProgrammeId", Student.class).setParameter("programmeId", programmeId);
		List<Student> students = query.getResultList();
		return students;
	}

	@Override
	public List<Student> findStudentsByDepartmentId(Long deptId) {
		TypedQuery<Student> query = em.createNamedQuery("Student.findByDepartmentId", Student.class).setParameter("deptId", deptId);
		List<Student> students = query.getResultList();
		return students;
	}

	@Override
	public List<Student> findAllStudents() {
		return this.em.createNamedQuery("Student.findAll", Student.class).getResultList();
	}

	@Override
	@Transactional
	public Student save(Student student) {
		return this.em.merge(student);
	}

}
