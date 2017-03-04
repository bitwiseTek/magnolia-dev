package com.bitwise.magnolia.model.support;
/**
 *  
 * @author Sika Kay
 * @date 27/02/17
 *
 */
import org.springframework.stereotype.Component;

import com.bitwise.magnolia.model.common.StudyProgrammeCategory;

@Component
public class StudyProgrammeCategoryBuilder extends EntityBuilder<StudyProgrammeCategory> {

	@Override
	void initProduct() {
		this.product = new StudyProgrammeCategory();
	}
	
	public StudyProgrammeCategoryBuilder category(String name, String createdAt, String updatedAt, String status) {
		this.product.setName(name);
		this.product.setCreatedAt(createdAt);
		this.product.setUpdatedAt(updatedAt);
		this.product.setStatus(status);
		return this;
	}

	@Override
	StudyProgrammeCategory assembleProduct() {
		return this.product;
	}

}
