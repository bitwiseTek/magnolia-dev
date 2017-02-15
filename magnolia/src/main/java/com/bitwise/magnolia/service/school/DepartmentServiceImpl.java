package com.bitwise.magnolia.service.school;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitwise.magnolia.dao.common.Response;
import com.bitwise.magnolia.dao.school.DepartmentDao;
import com.bitwise.magnolia.domain.school.Department;
import com.bitwise.magnolia.vo.school.DepartmentVo;

@Service("departmentService")
@Transactional
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired
	private DepartmentDao departmentDao;

	@Override
	public Response getActiveDepartmentsByFacultyId(String apiKey, long facultyId) {
		Response response = new Response();
		try{
			List<Department> departmentList = departmentDao.fetchActiveDepartmentsByFacultyId(apiKey, facultyId);
			if(departmentList != null && departmentList.size() > 0){
				List<DepartmentVo> voList = new ArrayList<DepartmentVo>();
				for(Department department: departmentList){
					DepartmentVo vo = new DepartmentVo();
					vo.setDepartmentId(department.getDepartmentId());
					vo.setName(department.getName());
					vo.setStatus(department.getStatus());
					voList.add(vo);
				}
				response.setSuccess(true);
				response.setObject(voList);
			}
			else{
				response.setSuccess(false);
				response.setMessage("Empty Resultset");
			}
		}
		catch(Exception e){
			response.setSuccess(false);
			response.setMessage("Empty Resultset");
			System.err.println("ERROR:: " + this.getClass().getSimpleName());
		}
		return response;
	}
	
	
	
}
