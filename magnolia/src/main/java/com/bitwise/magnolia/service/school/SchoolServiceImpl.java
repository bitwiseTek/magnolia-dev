package com.bitwise.magnolia.service.school;

//import java.io.File;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.bitwise.magnolia.dao.common.ApplicationConstant;
import com.bitwise.magnolia.dao.common.Response;
import com.bitwise.magnolia.dao.common.Utils;
import com.bitwise.magnolia.dao.school.SchoolDao;
import com.bitwise.magnolia.domain.school.School;
import com.bitwise.magnolia.vo.school.SchoolVo;

@Service("schoolService")
@Transactional
public class SchoolServiceImpl implements SchoolService{
	
	@Autowired
	private SchoolDao schoolDao;

	@Override
	public boolean isSchoolExist(String alias) {
		boolean isExist = false;
		try{
			isExist = schoolDao.isSchoolExist(alias);
		}
		catch(Exception e){
			isExist = false;
		}
		return isExist;
	}

	@Override
	public boolean isValidDays(String alias) {
		boolean isValidDays = false;
		try{
			School school = schoolDao.findSchoolByAlias(alias);
			long remainingDays = Utils.remainingDays(school.getCreatedAt());
			if(remainingDays > school.getValidDays()){
				isValidDays = false;
			}
			else{
				isValidDays = true;
			}
		}
		catch(Exception e){
			isValidDays = false;
		}
		return isValidDays;
	}

	@Override
	public Response retrieveSchoolDetails(String alias) {
		Response response = new Response();
		School school = schoolDao.findSchoolByAlias(alias);
		SchoolVo vo = new SchoolVo();
		vo.setValidDays(school.getValidDays());
		vo.setCreatedAt(school.getCreatedAt());
		vo.setEmail(school.getEmail());
		vo.setSchoolAddress(school.getSchoolAddress());
		vo.setSchoolLogo(school.getSchoolLogo());
		vo.setSchoolName(school.getSchoolName());
		vo.setAlias(school.getAlias());
		vo.setWebSite(school.getWebsite());
		
		//String imageBase64 = Utils.convertFileToBase64(ApplicationConstant.MAGNOLIA_PATH + vo.getAlias(), vo.getSchoolLogo());
		//vo.setSchoolLogo(imageBase64);
		response.setObject(vo);
		response.setSuccess(true);
		
		return response;
	}

}
