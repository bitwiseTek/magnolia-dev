package com.bitwise.magnolia.dao.schoolImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.bitwise.magnolia.common.AbstractDao;
import com.bitwise.magnolia.dao.school.StudentDao;
import com.bitwise.magnolia.model.school.Student;

@Repository("studentDao")
public class StudentDaoImpl extends AbstractDao<Student> implements StudentDao{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Student findByStudentId(String studentId) {
		String sql = "from Student s where s.studentId = :studentId";
		return (Student) this.em.createQuery(sql).setParameter("studentId", studentId).getSingleResult();
	}

	@Override
	public Student findByStudentApiKey(String studentApiKey) {
		String sql = "from Student s where s.apiKey = :apiKey";
		return (Student) this.em.createQuery(sql).setParameter("apiKey", studentApiKey).getSingleResult();
	}

}
