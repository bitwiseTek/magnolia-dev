/**
 * 
 */
/**
 * @author js4otto
 *
 */

package com.bitwise.magnolia.common;

public interface BaseDao<E> {

	public void create(final E entity);
	
	public void update(final E entity);
	
	public void saveOrUpdate(final E entity);
	
	public void delete(final E entity);
}
