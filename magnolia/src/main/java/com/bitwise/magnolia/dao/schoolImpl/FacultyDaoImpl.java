package com.bitwise.magnolia.dao.schoolImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.bitwise.magnolia.common.AbstractDao;
import com.bitwise.magnolia.common.ApplicationConstant;
import com.bitwise.magnolia.dao.school.FacultyDao;
import com.bitwise.magnolia.model.school.Faculty;

@Repository("facultyDao")
public class FacultyDaoImpl extends AbstractDao<Faculty> implements FacultyDao{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Faculty> fetchActiveFaculties(String schoolAlias) {
		String sql = "from Faculty f where f.status = :status and f.subSchool.school.alias = :alias";
		List<?> list = this.em.createQuery(sql)
											   .setParameter("status", ApplicationConstant.ACTIVE_STATUS)
											   .setParameter("alias", schoolAlias)
											   .getResultList();
		List<Faculty> facultyList = new ArrayList<Faculty>();
		for(Object object : list){
			Faculty temp = (Faculty) object;
			facultyList.add(temp);
		}
		return facultyList;
	}

	

}
