package com.bitwise.magnolia.web.restful.resource.staff;
/**
 *  
 * @author Sika Kay
 * @date 02/03/17
 *
 */
import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.ResourceSupport;

public class StaffListResource extends ResourceSupport {

	private List<StaffResource> staff = new ArrayList<StaffResource>();

	public List<StaffResource> getStaff() {
		return staff;
	}

	public void setStaff(List<StaffResource> staff) {
		this.staff = staff;
	}
}
