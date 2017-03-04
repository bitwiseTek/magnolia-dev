package com.bitwise.magnolia.web.restful.resource.common;
import org.joda.time.DateTime;
/**
 *  
 * @author Sika Kay
 * @date 02/03/17
 *
 */
import org.springframework.hateoas.ResourceSupport;

import com.bitwise.magnolia.model.common.AcademicSemester;

public class AcademicSemesterResource extends ResourceSupport {

	public AcademicSemesterResource() {
		
	}
	
	private Long rid;
	
	private String session;
	
	private String name;
	
	private String startDate;
	
	private String endDate;

	private String updatedAt;
	
	public Long getRid() {
		return rid;
	}

	public void setRid(Long rid) {
		this.rid = rid;
	}

	public String getSession() {
		return session;
	}

	public void setSession(String session) {
		this.session = session;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	public AcademicSemester toSemester() {
		AcademicSemester semester = new AcademicSemester();
		semester.setId(rid);
		semester.setName(name);
		semester.setSession(session);
		semester.setStartDate(new DateTime(DateTime.now()));
		semester.setUpdatedAt(new DateTime(DateTime.now()));
		semester.setEndDate(new DateTime(DateTime.now()).plusDays(90));
		return semester;
	}
}

