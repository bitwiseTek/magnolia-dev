/**
 * 
 */
/**
 * @author js4otto
 *
 */
package com.bitwise.magnolia.common;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
 
public abstract class AbstractDao<E> {
	
	@PersistenceContext
	private EntityManager em;
	
	public void create(final E entity) {
		this.em.persist(entity);
	}
    
    public void update(final E entity) {
 		this.em.merge(entity);
 	}
    
    public void saveOrUpdate(final E entity) {
    	this.em.merge(entity);
 	}
    
    public void delete(final E entity) {
 		this.em.remove(em.merge(entity));
 	}
	
    
}