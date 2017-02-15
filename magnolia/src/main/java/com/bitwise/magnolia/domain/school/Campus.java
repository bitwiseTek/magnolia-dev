package com.bitwise.magnolia.domain.school;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CAMPUSES")
public class Campus implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CAMPUS_ID")
	private Long campusId;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "CREATED_AT")
	private String createdAt;
	
	@Column(name = "UPDATED_AT")
	private String updatedAt;
	
	@Column(name = "STATUS")
	private String status;
	
	@JoinColumn(name = "SUB_SCHOOL_ID", referencedColumnName = "SUB_SCHOOL_ID")
	@ManyToOne
	SubSchool subSchool;
	
	public Campus(){
		
	}

	public Long getCampusId() {
		return campusId;
	}

	public void setCampusId(Long campusId) {
		this.campusId = campusId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public SubSchool getSubSchool() {
		return subSchool;
	}

	public void setSubSchool(SubSchool subSchool) {
		this.subSchool = subSchool;
	}

	@Override
	public String toString() {
		return "Campus [campusId=" + campusId + ", name=" + name + ", createdAt=" + createdAt + ", updatedAt="
				+ updatedAt + ", status=" + status + ", subSchool=" + subSchool + "]";
	}

}
