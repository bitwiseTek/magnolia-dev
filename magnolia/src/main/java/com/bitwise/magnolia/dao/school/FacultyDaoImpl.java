package com.bitwise.magnolia.dao.school;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.bitwise.magnolia.dao.common.AbstractDao;
import com.bitwise.magnolia.dao.common.ApplicationConstant;
import com.bitwise.magnolia.dao.school.FacultyDao;
import com.bitwise.magnolia.domain.school.Faculty;

@Repository("facultyDao")
public class FacultyDaoImpl extends AbstractDao<Faculty> implements FacultyDao{

	@Override
	public List<Faculty> fetchActiveFaculties(String schoolAlias) {
		String sql = "from Faculty faculty where faculty.status = :status and faculty.subSchool.school.alias = :alias";
		List<?> list = this.getCurrentSession().createQuery(sql)
											   .setParameter("status", ApplicationConstant.ACTIVE_STATUS)
											   .setParameter("alias", schoolAlias)
											   .list();
		List<Faculty> facultyList = new ArrayList<Faculty>();
		for(Object object : list){
			Faculty temp = (Faculty) object;
			facultyList.add(temp);
		}
		return facultyList;
	}

	

}
