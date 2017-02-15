package com.bitwise.magnolia.dao.school;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.bitwise.magnolia.dao.common.AbstractDao;
import com.bitwise.magnolia.dao.common.ApplicationConstant;
import com.bitwise.magnolia.dao.school.DepartmentDao;
import com.bitwise.magnolia.domain.school.Department;

@Repository("departmentDao")
public class DepartmentDaoImpl extends AbstractDao<Department> implements DepartmentDao{

	@Override
	public List<Department> fetchActiveDepartmentsByFacultyId(String apiKey, long facultyId) {
		String sql = "from Department department where department.status = :status and department.faculty.facultyId = :facultyId and "
				+ "department.faculty.subSchool.school.apiKey = :apiKey";
		List<?> list = this.getCurrentSession().createQuery(sql)
											   .setParameter("status", ApplicationConstant.ACTIVE_STATUS)
											   .setLong("facultyId", facultyId)
											   .setParameter("apiKey", apiKey)
											   .list();
		List<Department> departmentList = new ArrayList<Department>();
		for(Object object : list){
			Department temp = (Department) object;
			departmentList.add(temp);
		}
		
		return departmentList;
	}

}
