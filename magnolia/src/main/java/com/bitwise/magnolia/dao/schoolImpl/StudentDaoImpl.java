package com.bitwise.magnolia.dao.schoolImpl;

import org.springframework.stereotype.Repository;

import com.bitwise.magnolia.common.AbstractDao;
import com.bitwise.magnolia.dao.school.StudentDao;
import com.bitwise.magnolia.model.school.Student;

@Repository("studentDao")
public class StudentDaoImpl extends AbstractDao<Student> implements StudentDao{

	@Override
	public Student findByStudentId(String studentId) {
		String sql = "from Student student where student.studentId = :studentId";
		return (Student) this.getCurrentSession().createQuery(sql).setParameter("studentId", studentId).uniqueResult();
	}

	@Override
	public Student findByStudentApiKey(String studentApiKey) {
		String sql = "from Student student where student.apiKey = :apiKey";
		return (Student) this.getCurrentSession().createQuery(sql).setParameter("apiKey", studentApiKey).uniqueResult();
	}

}
