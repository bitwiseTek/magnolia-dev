package com.bitwise.magnolia.dao.schoolImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
	public List<Department> fetchActiveDepartmentsByFacultyId(String apiKey, long facultyId) {
		String sql = "from Department d where d.status = :status and d.faculty.facultyId = :facultyId and "
				+ "d.faculty.subSchool.school.apiKey = :apiKey";
		List<?> list = this.em.createQuery(sql)
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


}
