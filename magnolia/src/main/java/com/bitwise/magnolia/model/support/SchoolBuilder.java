package com.bitwise.magnolia.model.support;
/**
 *  
 * @author Sika Kay
 * @date 22/02/17
 *
 */
import org.springframework.stereotype.Component;

import com.bitwise.magnolia.model.school.School;

@Component
public class SchoolBuilder extends EntityBuilder<School>{

	@Override
	void initProduct() {
		this.product = new School();
	}

	public SchoolBuilder school(String email, String schoolAddress, 
			String alias, String website, String createdAt, int validDays, String logo, 
			String schoolName, String apiKey, String status) {
		this.product.setAlias(alias);
		this.product.setApiKey(apiKey);
		this.product.setCreatedAt(createdAt);
		this.product.setEmail(email);
		this.product.setWebsite(website);
		this.product.setValidDays(validDays);
		this.product.setSchoolAddress(schoolAddress);
		this.product.setSchoolLogo(logo);
		this.product.setSchoolName(schoolName);
		this.product.setStatus(status);
		return this;
	}
	@Override
	School assembleProduct() {
		return this.product;
	}

}
