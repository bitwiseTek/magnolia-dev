package com.bitwise.magnolia.util;
/**
 *  
 * @author Sika Kay
 * @date 24/02/17
 *
 */
import java.util.ArrayList;
import java.util.List;

import com.bitwise.magnolia.model.common.LGA;

public class LGAList {

	public LGAList(List<LGA> lgas) {
		this.lgas = lgas;
	}
	
	private List<LGA> lgas = new ArrayList<LGA>();

	public List<LGA> getLgas() {
		return lgas;
	}

	public void setLgas(List<LGA> lgas) {
		this.lgas = lgas;
	}
}
