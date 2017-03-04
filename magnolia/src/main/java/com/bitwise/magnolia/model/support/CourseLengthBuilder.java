package com.bitwise.magnolia.model.support;
/**
 *  
 * @author Sika Kay
 * @date 28/02/17
 *
 */
import org.springframework.stereotype.Component;

import com.bitwise.magnolia.model.course.CourseLength;

@Component
public class CourseLengthBuilder extends EntityBuilder<CourseLength>{

	@Override
	void initProduct() {
		this.product = new CourseLength();
	}
	
	public CourseLengthBuilder courseLength(String name, Integer tCU, Integer tCH) {
		this.product.setName(name);
		this.product.settCU(tCU);
		this.product.settCH(tCH);
		return this;
	}

	@Override
	CourseLength assembleProduct() {
		return this.product;
	}

}
