package com.bitwise.magnolia.model.school;
/**
 *  
 * @author Sika Kay
 * @date 22/02/17
 *
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SUB_SCHOOLS")
public class SubSchool implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "SUB_SCHOOL_ID")
	private Long subSchoolId;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "TYPE")
	private String type;
	
	@Column(name = "ADDRESS")
	private String address;
	
	@Column(name = "CREATED_AT")
	private String createdAt;
	
	@Column(name = "STATUS")
	private String status;
	
	@JoinColumn(name = "SCHOOL_ID", referencedColumnName = "SCHOOL_ID")
	@ManyToOne
	School school;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "subSchool", orphanRemoval = true)
	private List<Campus> campusList = new ArrayList<Campus>();
	
	public SubSchool() {
		
	}
	
	public SubSchool(Long id) {
		this.subSchoolId = id;
	}

	public Long getSubSchoolId() {
		return subSchoolId;
	}

	public void setSubSchoolId(Long subSchoolId) {
		this.subSchoolId = subSchoolId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public List<Campus> getCampusList() {
		return campusList;
	}

	public void setCampusList(List<Campus> campusList) {
		this.campusList = campusList;
	}

	@Override
	public String toString() {
		return "SubSchool [subSchoolId=" + subSchoolId + ", name=" + name + ", type=" + type + ", address=" + address
				+ ", createdAt=" + createdAt + ", status=" + status + "]";
	}
	

}
