package com.bitwise.magnolia.dao.schoolImpl;

import org.springframework.stereotype.Repository;

import com.bitwise.magnolia.common.AbstractDao;
import com.bitwise.magnolia.common.ApplicationConstant;
import com.bitwise.magnolia.dao.school.SchoolDao;
import com.bitwise.magnolia.model.school.School;

@Repository("schoolDao")
public class SchoolDaoImpl extends AbstractDao<Object> implements SchoolDao{

	@Override
	public boolean isSchoolExist(String alias) {
		String sql = "from School school where school.alias  = :alias and school.status = :status";
		School school = (School) this.getCurrentSession().createQuery(sql)
														 .setParameter("alias", alias)
														 .setParameter("status", ApplicationConstant.ACTIVE_STATUS)
														 .uniqueResult();
		if(school != null){
			return true;
		}
		return false;
	}

	@Override
	public School findSchoolByAlias(String alias) {
		String sql = "from School school where school.alias  = :alias and school.status = :status";
		School school = (School) this.getCurrentSession().createQuery(sql)
														 .setParameter("alias", alias)
														 .setParameter("status", ApplicationConstant.ACTIVE_STATUS)
														 .uniqueResult();
		return school;
	}

	@Override
	public boolean isApiKeyExist(String apiKey) {
		String sql = "from School school where school.status = :status and school.apiKey = :apiKey";
		return ((School) this.getCurrentSession().createQuery(sql)
												.setParameter("status", ApplicationConstant.ACTIVE_STATUS)
												.setParameter("apiKey", apiKey)
												.uniqueResult()) == null ? false : true;
	}

}
