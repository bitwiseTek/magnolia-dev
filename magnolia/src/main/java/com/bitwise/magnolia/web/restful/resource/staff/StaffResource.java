package com.bitwise.magnolia.web.restful.resource.staff;
/**
 *  
 * @author Sika Kay
 * @date 02/03/17
 *
 */
import org.joda.time.DateTime;
import org.springframework.hateoas.ResourceSupport;

import com.bitwise.magnolia.common.Utils;
import com.bitwise.magnolia.model.school.Department;
import com.bitwise.magnolia.model.staff.Staff;
import com.bitwise.magnolia.model.user.User;

public class StaffResource extends ResourceSupport {

	public StaffResource() {
		
	}
	
	private Long rid;
	
	private String title;
	
	private String apiKey;
	
	private Boolean isAcademic;
	
	private Boolean isTemp;
	
	private String staffId;
	
	private String status;
	
	private String user;
	
	private String staffDepartment;

	public Long getRid() {
		return rid;
	}

	public void setRid(Long rid) {
		this.rid = rid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	public Boolean getIsAcademic() {
		return isAcademic;
	}

	public void setIsAcademic(Boolean isAcademic) {
		this.isAcademic = isAcademic;
	}

	public Boolean getIsTemp() {
		return isTemp;
	}

	public void setIsTemp(Boolean isTemp) {
		this.isTemp = isTemp;
	}

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getStaffDepartment() {
		return staffDepartment;
	}

	public void setStaffDepartment(String staffDepartment) {
		this.staffDepartment = staffDepartment;
	}
	
	public Staff toStaff() {
		Staff staff = new Staff();
		staff.setId(rid);
		staff.setApiKey(Utils.randomString(30));
		staff.setIsAcademic(Boolean.TRUE);
		staff.setIsTemporary(Boolean.FALSE);
		staff.setStaffId("STF".concat("/").concat(org.joda.time.format.DateTimeFormat.forPattern("yyyy").print(new DateTime(DateTime.now()))).concat("/").concat(new Department().getCode()).concat("/").concat(new User().getId().toString()));
		staff.setTitle(title);
		staff.setStatus(status);
		return staff;
	}
}
