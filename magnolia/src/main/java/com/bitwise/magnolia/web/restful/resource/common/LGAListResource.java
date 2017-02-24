package com.bitwise.magnolia.web.restful.resource.common;
/**
 *  
 * @author Sika Kay
 * @date 24/02/17
 *
 */
import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.ResourceSupport;

public class LGAListResource extends ResourceSupport {

	private List<LGAResource> lgas = new ArrayList<LGAResource>();

	public List<LGAResource> getLgas() {
		return lgas;
	}

	public void setLgas(List<LGAResource> lgas) {
		this.lgas = lgas;
	}
}
