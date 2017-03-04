package com.bitwise.magnolia.web.restful.resource.course;
/**
 *  
 * @author Sika Kay
 * @date 02/03/17
 *
 */
import org.springframework.hateoas.ResourceSupport;

import com.bitwise.magnolia.model.course.CourseLength;

public class CourseLengthResource extends ResourceSupport {

	public CourseLengthResource() {
		
	}
	
	private Long rid;
	
	private String name;
	
	private Integer tCH;
	
	private Integer tCU;

	public Long getRid() {
		return rid;
	}

	public void setRid(Long rid) {
		this.rid = rid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer gettCH() {
		return tCH;
	}

	public void settCH(Integer tCH) {
		this.tCH = tCH;
	}

	public Integer gettCU() {
		return tCU;
	}

	public void settCU(Integer tCU) {
		this.tCU = tCU;
	}
	
	public CourseLength toLength() {
		CourseLength length = new CourseLength();
		length.setId(rid);
		length.setName(name);
		length.settCH(tCH);
		length.settCU(tCU);
		return length;
	}
}
