package com.bitwise.magnolia.model.support;
/**
 *  
 * @author Sika Kay
 * @date 22/02/17
 *
 */
import org.springframework.stereotype.Component;

import com.bitwise.magnolia.model.school.School;
import com.bitwise.magnolia.model.school.SubSchool;

@Component
public class SubSchoolBuilder extends EntityBuilder<SubSchool> {

	@Override
	void initProduct() {
		this.product = new SubSchool();
	}

	public SubSchoolBuilder school(School school) {
		this.product.setSchool(school);
		return this;
	}
	
	public SubSchoolBuilder subSchool(String name, String address, String type, String createdAt, String status) {
		this.product.setName(name);
		this.product.setAddress(address);
		this.product.setType(type);
		this.product.setCreatedAt(createdAt);
		this.product.setStatus(status);
		return this;
	}
	@Override
	SubSchool assembleProduct() {
		return this.product;
	}

}
