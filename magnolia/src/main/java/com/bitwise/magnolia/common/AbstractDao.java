/**
 * 
 */
/**
 * @author js4otto
 *
 */
package com.bitwise.magnolia.common;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
 
public abstract class AbstractDao<E> extends HibernateDaoSupport{
	
	@Autowired
	public void currSess(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
    
	public Session getCurrentSession(){
    	return this.getHibernateTemplate().getSessionFactory().getCurrentSession();
    }
	
	public void create(final E entity) {
		getHibernateTemplate().save(entity);	
	}
    
    public void update(final E entity) {
 		getHibernateTemplate().update(entity);	
 	}
    
    public void saveOrUpdate(final E entity) {
 		getHibernateTemplate().saveOrUpdate(entity);	
 	}
    
    public void delete(final E entity) {
 		getHibernateTemplate().delete(entity);	
 	}

	
    
}