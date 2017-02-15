package com.bitwise.magnolia.service.school;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitwise.magnolia.dao.common.Response;
import com.bitwise.magnolia.dao.school.FacultyDao;
import com.bitwise.magnolia.domain.school.Faculty;

@Service("facultyService")
@Transactional
public class FacultyServiceImpl implements FacultyService{

	@Autowired
	private FacultyDao facultyDao;

	@Override
	public Response getActiveFaculties(String schoolAlias) {
		Response response = new Response();
		try{
			List<Faculty> facultyList = facultyDao.fetchActiveFaculties(schoolAlias);
			if(facultyList != null && facultyList.size() > 0){
				response.setObject(facultyList);
				response.setSuccess(true);
			}
			else{
				response.setSuccess(false);
				response.setMessage("Empty ResultSet");
			}
		}
		catch(Exception e){
			response.setSuccess(false);
			response.setMessage("Empty ResultSet");
			System.err.println("ERROR:: " + this.getClass().getSimpleName());
		}
		return response;
	}
	
}
