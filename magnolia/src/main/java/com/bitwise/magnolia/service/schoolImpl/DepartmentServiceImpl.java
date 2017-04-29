package com.bitwise.magnolia.service.schoolImpl;
import java.util.List;

/**
 *  
 * @author Sika Kay
 * @date 24/02/17
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bitwise.magnolia.dao.school.DepartmentDao;
import com.bitwise.magnolia.model.school.Department;
import com.bitwise.magnolia.service.school.DepartmentService;
import com.bitwise.magnolia.util.DepartmentList;

@Transactional
@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired
	private DepartmentDao departmentDao;
	
	@Override
	@Transactional(readOnly=true)
	public DepartmentList findActiveDepartmentsByFacultyId(String apiKey, Long facultyId) {
		return new DepartmentList(departmentDao.findActiveDepartmentsByFacultyId(apiKey, facultyId));
	}

	@Override
	@Transactional(readOnly=true)
	public DepartmentList findDepartmentsByFacultyId(Long facultyId) {
		return new DepartmentList(departmentDao.findDepartmentsByFacultyId(facultyId));
	}

	@Override
	@Transactional(readOnly=true)
	public DepartmentList findAllDepartments() {
		return new DepartmentList(departmentDao.findAllDepartments());
	}

	@Override
	@Transactional(readOnly=true)
	public Department findByDepartmentId(Long id) {
		return this.departmentDao.findByDepartmentId(id);
	}

	@Override
	@Transactional(readOnly=true)
	public Department findByName(String name) {
		return this.departmentDao.findByName(name);
	}

	@Transactional(readOnly=true)
	public List<Department> findAll() {		
		return this.departmentDao.findAllDepartments();
	}
	
	
	
}
