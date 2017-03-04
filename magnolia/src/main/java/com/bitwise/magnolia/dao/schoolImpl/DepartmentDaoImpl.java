package com.bitwise.magnolia.dao.schoolImpl;
/**
 *  
 * @author Sika Kay
 * @date 24/02/17
 */
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.bitwise.magnolia.common.AbstractDao;
import com.bitwise.magnolia.common.ApplicationConstant;
import com.bitwise.magnolia.dao.school.DepartmentDao;
import com.bitwise.magnolia.model.school.Department;

@Repository("departmentDao")
public class DepartmentDaoImpl extends AbstractDao<Department> implements DepartmentDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Department> findActiveDepartmentsByFacultyId(String apiKey, long facultyId) {
		String sql = "select d from Department d where d.status = :status and d.faculty.facultyId = :facultyId and "
				+ "d.faculty.subSchool.school.apiKey = :apiKey";
		List<?> list = this.em.createQuery(sql, Department.class)
											   .setParameter("status", ApplicationConstant.ACTIVE_STATUS)
											   .setParameter("facultyId", facultyId)
											   .setParameter("apiKey", apiKey)
											   .getResultList();
		List<Department> departmentList = new ArrayList<Department>();
		for(Object object : list){
			Department temp = (Department) object;
			departmentList.add(temp);
		}
		
		return departmentList;
	}

	@Override
	public List<Department> findDepartmentsByFacultyId(Long facultyId) {
		String sql = "select d from Department d where d.faculty.facultyId = :facultyId";
		TypedQuery<Department> query = em.createQuery(sql, Department.class).setParameter("facultyId", facultyId);
		List<Department> departments = query.getResultList();
		return departments;
	}

	@Override
	public List<Department> findAllDepartments() {
		String sql = "select d from Department d";
		return this.em.createQuery(sql, Department.class).getResultList();
	}

	@Override
	public Department findByDepartmentId(Long id) {
		String sql = "select distinct d from Department d where d.id = :id";
		return this.em.createQuery(sql, Department.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public Department findByName(String name) {
		String sql = "select distinct d from Department d where d.name = :name";
		TypedQuery<Department> query = em.createQuery(sql, Department.class).setParameter("name", name);
		List<Department> departments = query.getResultList();
		return departments.size() == 1 ? departments.get(0) : null;
	}

	@Override
	@Transactional
	public Department save(Department dept) {
		return this.em.merge(dept);
	}
}
