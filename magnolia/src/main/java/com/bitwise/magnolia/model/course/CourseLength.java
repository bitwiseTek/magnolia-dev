package com.bitwise.magnolia.model.course;
/**
 *  
 * @author Sika Kay
 * @date 26/02/17
 *
 */
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="COURSE_LENGTHS")
@NamedQueries({
	@NamedQuery(name="CourseLength.findById", query="select distinct c from CourseLength c where c.id=:id"),
	@NamedQuery(name="CourseLength.findByName", query="select distinct c from CourseLength c where c.name=:name"),
	@NamedQuery(name="CourseLength.findAll", query="select c from CourseLength c")
})
public class CourseLength implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String name;
	
	private Integer tCU;
	
	private Integer tCH;
	
	public CourseLength() {
		
	}
	
	public CourseLength(Long id) {
		this.id = id;
	}

	@Id
	@Column(name="COURSE_LENGTH_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name="NAME", nullable=false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name="TOTAL_CREDIT_UNIT", nullable=false)
	public Integer gettCU() {
		return tCU;
	}

	public void settCU(Integer tCU) {
		this.tCU = tCU;
	}

	@Column(name="TOTAL_CREDIT_HOUR", nullable=false)
	public Integer gettCH() {
		return tCH;
	}

	public void settCH(Integer tCH) {
		this.tCH = tCH;
	}
}
