package com.bitwise.magnolia.dao.staffImpl;
/**
 *  
 * @author Sika Kay
 * @date 27/02/17
 *
 */
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.bitwise.magnolia.common.AbstractDao;
import com.bitwise.magnolia.dao.staff.StaffDao;
import com.bitwise.magnolia.model.staff.Staff;

@Repository("staffDao")
public class StaffDaoImpl extends AbstractDao<Object> implements StaffDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Staff findById(Long id) {
		TypedQuery<Staff> query = em.createNamedQuery("Staff.findById", Staff.class).setParameter("id", id);
		List<Staff> staff = query.getResultList();
		return staff.size() == 1 ? staff.get(0) : null;
	}

	@Override
	public Staff findByStaffId(String staffId) {
		TypedQuery<Staff> query = em.createNamedQuery("Staff.findByStaffId", Staff.class).setParameter("staffId", staffId);
		List<Staff> staff = query.getResultList();
		return staff.size() == 1 ? staff.get(0) : null;
	}

	@Override
	public Staff findByStaffApiKey(String apiKey) {
		TypedQuery<Staff> query = em.createNamedQuery("Staff.findByApiKey", Staff.class).setParameter("apiKey", apiKey);
		List<Staff> staff = query.getResultList();
		return staff.size() == 1 ? staff.get(0) : null;
	}

	@Override
	public List<Staff> findStaffByDepartmentId(Long deptId) {
		TypedQuery<Staff> query = em.createNamedQuery("Staff.findByDepartmentId", Staff.class).setParameter("deptId", deptId);
		List<Staff> staff = query.getResultList();
		return staff;
	}

	@Override
	public List<Staff> findAllStaff() {
		TypedQuery<Staff> query = em.createNamedQuery("Staff.findAll", Staff.class);
		List<Staff> staff = query.getResultList();
		return staff;
	}

	@Override
	@Transactional
	public Staff save(Staff staff) {
		return this.em.merge(staff);
	}

}
