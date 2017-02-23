package com.bitwise.magnolia.model.support;

import org.springframework.stereotype.Component;

import com.bitwise.magnolia.model.common.State;

@Component
public class StateBuilder extends EntityBuilder<State>{

	@Override
	void initProduct() {
		this.product = new State();
		
	}
	
	public StateBuilder state(String name) {
		this.product.setName(name);
		return this;
	}

	@Override
	State assembleProduct() {
		return this.product;
	}

}
