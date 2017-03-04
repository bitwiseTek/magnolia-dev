package com.bitwise.magnolia.service.schoolImpl;
/**
 *  
 * @author Sika Kay
 * @date 24/02/17
 */
//import java.io.File;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import com.bitwise.magnolia.common.ApplicationConstant;
//import com.bitwise.magnolia.common.Response;
import com.bitwise.magnolia.common.Utils;
import com.bitwise.magnolia.dao.school.SchoolDao;
import com.bitwise.magnolia.model.school.School;
import com.bitwise.magnolia.service.school.SchoolService;
//import com.bitwise.magnolia.vo.school.SchoolVo;
import com.bitwise.magnolia.util.SchoolList;

@Transactional
@Service("schoolService")
public class SchoolServiceImpl implements SchoolService {
	
	final Logger logger = LoggerFactory.getLogger(SchoolServiceImpl.class);
	
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
	@Transactional(readOnly=true)
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
	@Transactional(readOnly=true)
	public School retrieveSchoolDetails(String alias) {
		//Response response = new Response();
		return this.schoolDao.findSchoolByAlias(alias);
		//SchoolVo vo = new SchoolVo();
		//vo.setValidDays(school.getValidDays());
		//vo.setCreatedAt(school.getCreatedAt());
		//vo.setEmail(school.getEmail());
		//vo.setSchoolAddress(school.getSchoolAddress());
		//vo.setSchoolLogo(school.getSchoolLogo());
		//vo.setSchoolName(school.getSchoolName());
		//vo.setAlias(school.getAlias());
		//vo.setWebSite(school.getWebsite());
		
		//String imageBase64 = Utils.convertFileToBase64(ApplicationConstant.MAGNOLIA_PATH + vo.getAlias() + File.separator + vo.getAlias(), vo.getSchoolLogo());
		//vo.setSchoolLogo(imageBase64);
		//response.setObject(vo);
		//response.setSuccess(true);
		
		//return response;
	}

	@Override
	@Transactional(readOnly=true)
	public School findById(Long id) {
		return this.schoolDao.findById(id);
	}

	@Override
	@Transactional(readOnly=true)
	public School findByName(String name) {
		return this.schoolDao.findByName(name);
	}

	@Override
	@Transactional(readOnly=true)
	public SchoolList findAllSchools() {
		return new SchoolList(this.schoolDao.findAllSchools());
	}

	@Override
	@Transactional(readOnly=false)
	public School save(School school) {
		logger.info("Adding school with ID " + school.getSchoolId());
		return this.schoolDao.save(school);
	}

}
