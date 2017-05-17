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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="FACULTIES", uniqueConstraints = @UniqueConstraint(columnNames = {
"name" }))
@NamedQueries({
	@NamedQuery(name="Faculty.findById", query="select distinct f from Faculty f where f.facultyId=:id"),
	@NamedQuery(name="Faculty.findByCampusId", query="select f from Faculty f where f.campus.campusId=:campusId"),
	@NamedQuery(name="Faculty.findByName", query="select distinct f from Faculty f where f.name=:name"),
	@NamedQuery(name="Faculty.findAll", query="select f from Faculty f")
})
public class Faculty implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "FACULTY_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long facultyId;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "CREATED_AT")
	private String createdAt;
	
	@Column(name = "UPDATED_AT")
	private String updatedAt;
	
	@Column(name = "STATUS")
	private String status;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "faculty")
	private List<Department> departmentList = new ArrayList<Department>();
	
	@ManyToOne
	@JoinColumn(name = "CAMPUS_ID", referencedColumnName = "CAMPUS_ID")
	private Campus campus;
	
	public Faculty(){
		
	}
	
	public Faculty(Long facultyId){
		this.facultyId = facultyId;
	}

	public Long getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(Long facultyId) {
		this.facultyId = facultyId;
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

	public List<Department> getDepartmentList() {
		return departmentList;
	}

	public void setDepartmentList(List<Department> departmentList) {
		this.departmentList = departmentList;
	}

	public Campus getCampus() {
		return campus;
	}

	public void setCampus(Campus campus) {
		this.campus = campus;
	}

}
