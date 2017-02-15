package com.bitwise.magnolia.service.school;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitwise.magnolia.dao.common.ApplicationConstant;
import com.bitwise.magnolia.dao.common.Response;
import com.bitwise.magnolia.dao.common.Utils;
import com.bitwise.magnolia.dao.school.StudentDao;
import com.bitwise.magnolia.domain.school.Department;
import com.bitwise.magnolia.domain.school.Student;
import com.bitwise.magnolia.service.school.StudentService;
import com.bitwise.magnolia.vo.school.StudentVo;

@Service("studentService")
@Transactional
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentDao studentDao;

	@Override
	public Response validateStudent(StudentVo studentVo) {
		Response response = new Response();
		if(!studentVo.getFirstName().isEmpty() && !studentVo.getOtherNames().isEmpty() && !studentVo.getEmail().isEmpty() && 
				!studentVo.getApiKey().isEmpty() && !studentVo.getAddress().isEmpty() && !studentVo.getGender().isEmpty() && 
				!studentVo.getDepartmentName().isEmpty() && !studentVo.getDob().isEmpty() && !studentVo.getPhotoBase64().isEmpty() &&
				!studentVo.getTelephone().isEmpty()){
			this.registerStudent(studentVo);
			response.setSuccess(true);
		}
		else{
			response.setSuccess(false);
			response.setMessage("All fields are required");
		}
		return response;
	}
	
	private boolean registerStudent(StudentVo studentVo){
		do{
			studentVo.setStudentId(Utils.getCustomString(10, ""));
		}
		while(studentDao.findByStudentId(studentVo.getStudentId()) != null);
		
		do{
			studentVo.setStudentApiKey(Utils.randomString(30));
		}
		while(studentDao.findByStudentApiKey(studentVo.getStudentApiKey()) != null);
		
		Student student = new Student();
		student.setStudentId(studentVo.getStudentId());
		student.setFirstName(studentVo.getFirstName());
		student.setOtherNames(studentVo.getOtherNames());
		student.setDob(studentVo.getDob());
		student.setEmail(studentVo.getEmail());
		student.setGender(studentVo.getGender());
		student.setStatus(ApplicationConstant.PENDING_STATUS);
		student.setAddress(studentVo.getAddress());
		student.setDepartment(new Department(Long.parseLong(studentVo.getDepartmentName())));
		student.setApiKey(studentVo.getStudentApiKey());
		student.setTelephone(studentVo.getTelephone());
		student.setCreatedAt(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()));
		student.setPhotoBase64(Utils.saveBase64ToPath(studentVo.getPhotoBase64(), ApplicationConstant.SCHOOL_ALIAS, studentVo.getStudentId() + "_photo"));
		studentDao.create(student);		
		
		return true;
	}
	
	

}
