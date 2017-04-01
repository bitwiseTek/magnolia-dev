/**
 * 
 */
/**
 * @author js4otto
 *
 */
package com.bitwise.magnolia.common;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
 
public abstract class AbstractDao<PK extends Serializable, T> {
	
	private final Class<T> persistentClass;
	
	@SuppressWarnings("unchecked")
	public AbstractDao(){
		this.persistentClass =(Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
	}
	
	@PersistenceContext
	private EntityManager em;
	
	protected EntityManager getEntityManager(){
		return this.em;
	}

	protected T getByKey(PK key) {
		return (T) em.find(persistentClass, key);
	}

	protected T persist(T entity) {
		em.persist(entity);
		return entity;
	}
	
	protected T update(T entity) {
		em.merge(entity);
		return entity;
	}

	protected void delete(T entity) {
		em.remove(entity);
	}
}