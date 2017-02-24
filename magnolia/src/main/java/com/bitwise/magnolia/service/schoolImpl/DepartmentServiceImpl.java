package com.bitwise.magnolia.service.schoolImpl;
/**
 *  
 * @author Sika Kay
 * @date 24/02/17
 */
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public DepartmentList findActiveDepartmentsByFacultyId(String apiKey, Long facultyId) {
		return new DepartmentList(departmentDao.findActiveDepartmentsByFacultyId(apiKey, facultyId));
	}

	@Override
	public DepartmentList findDepartmentsByFacultyId(Long facultyId) {
		return new DepartmentList(departmentDao.findDepartmentsByFacultyId(facultyId));
	}

	@Override
	public DepartmentList findAllDepartments() {
		return new DepartmentList(departmentDao.findAllDepartments());
	}

	@Override
	public Department findByDepartmentId(Long id) {
		return this.departmentDao.findByDepartmentId(id);
	}

	@Override
	public Department findByName(String name) {
		return this.departmentDao.findByName(name);
	}
	
	
	
}
