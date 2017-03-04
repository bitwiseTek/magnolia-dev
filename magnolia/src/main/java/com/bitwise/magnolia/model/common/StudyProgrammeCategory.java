package com.bitwise.magnolia.model.common;
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
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "STUDY_PROGRAMME_CATEGORIES", uniqueConstraints = @UniqueConstraint(columnNames = {
		"name" }))
@NamedQueries({
		@NamedQuery(name = "StudyProgrammeCategory.findById", query = "select distinct s from StudyProgrammeCategory s where s.id=:id"),
		@NamedQuery(name = "StudyProgrammeCategory.findByName", query = "select distinct s from StudyProgrammeCategory s where s.name=:name"),
		@NamedQuery(name = "StudyProgrammeCategory.findAll", query = "select s from StudyProgrammeCategory s") })
public class StudyProgrammeCategory implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String name;

	private String createdAt;
	
	private String updatedAt;
	
	private String status;
	
	public StudyProgrammeCategory() {
		
	}
	
	public StudyProgrammeCategory(Long id) {
		this.id = id;
	}
	
	@Id
	@Column(name = "STUDY_PROGRAMME_CATEGORY_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@NotNull
	@Column(name = "NAME")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "CREATED_AT", nullable=false)
	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	@Column(name = "UPDATED_AT", nullable=false)
	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Column(name = "STATUS", nullable=false)
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
