package com.bitwise.magnolia.model.support;
/**
 *  
 * @author Sika Kay
 * @date 22/02/16
 *
 */
import org.springframework.stereotype.Component;

import com.bitwise.magnolia.model.common.LGA;
import com.bitwise.magnolia.model.common.State;

@Component
public class LGABuilder extends EntityBuilder<LGA> {

	@Override
	void initProduct() {
		this.product = new LGA();
	}
	
	public LGABuilder state(State state) {
		this.product.setStateCode(state);
		return this;
	}
	
	public LGABuilder lga(String name) {
		this.product.setName(name);
		return this;
	}

	@Override
	LGA assembleProduct() {
		return this.product;
	}

}
