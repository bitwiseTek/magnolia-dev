package com.bitwise.magnolia.model.support;
/**
 *  
 * @author Sika Kay
 * @date 27/02/17
 *
 */
import org.joda.time.DateTime;
import org.springframework.stereotype.Component;

import com.bitwise.magnolia.model.common.AcademicSemester;

@Component
public class AcademicSemesterBuilder extends EntityBuilder<AcademicSemester> {

	@Override
	void initProduct() {
		this.product = new AcademicSemester();
	}
	
	public AcademicSemesterBuilder semester(String name, String session, DateTime startDate, DateTime endDate, DateTime updatedAt) {
		this.product.setName(name);
		this.product.setSession(session);
		this.product.setStartDate(startDate);
		this.product.setEndDate(endDate);
		this.product.setUpdatedAt(updatedAt);
		return this;
	}

	@Override
	AcademicSemester assembleProduct() {
		return this.product;
	}

}
