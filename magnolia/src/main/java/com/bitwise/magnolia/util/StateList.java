package com.bitwise.magnolia.util;
/**
 *  
 * @author Sika Kay
 * @date 24/02/17
 *
 */
import java.util.ArrayList;
import java.util.List;

import com.bitwise.magnolia.model.common.State;

public class StateList {

	public StateList(List<State> states) {
		this.states = states;
	}
	
	private List<State> states = new ArrayList<State>();

	public List<State> getStates() {
		return states;
	}

	public void setStates(List<State> states) {
		this.states = states;
	}
}
