package com.bitwise.magnolia.model.school;
import java.io.Serializable;

import javax.persistence.Column;
/**
 *  
 * @author Sika Kay
 * @date 22/02/17
 *
 */
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
/**
 *  
 * @author Sika Kay
 * @date 22/02/17
 *
 */
@Entity
@Table(name="STAFF")
public class Staff implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private Department staffDepartment;

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name="DEPARTMENT_ID")
	public Department getStaffDepartment() {
		return staffDepartment;
	}

	public void setStaffDepartment(Department staffDepartment) {
		this.staffDepartment = staffDepartment;
	}
}
