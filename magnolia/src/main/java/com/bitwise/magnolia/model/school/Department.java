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

import com.bitwise.magnolia.model.staff.Staff;
import com.bitwise.magnolia.model.student.Student;

@Entity
@Table(name="DEPARTMENTS", uniqueConstraints = @UniqueConstraint(columnNames = {
"name" }))
@NamedQueries({
	@NamedQuery(name="Department.findById", query="select distinct d from Department d where d.departmentId=:id"),
	@NamedQuery(name="Department.findByFacultyId", query="select d from Department d where d.faculty.facultyId=:facultyId"),
	@NamedQuery(name="Department.findByName", query="select distinct d from Department d where d.name=:name"),
	@NamedQuery(name="Department.findAll", query="select d from Department d")
})
public class Department implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "DEPARTMENT_ID")
	private Long departmentId;
	
	@Column(name = "NAME", nullable=false)
	private String name;
	
	@Column(name = "CODE", nullable=false)
	private String code;
	
	@Column(name = "CREATED_AT", nullable=false)
	private String createdAt;
	
	@Column(name = "UPDATED_AT", nullable=false)
	private String updatedAt;
	
	@Column(name = "STATUS", nullable=false)
	private String status;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "studentDepartment")
	private List<Student> students = new ArrayList<Student>();
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "staffDepartment")
	private List<Staff> staff = new ArrayList<Staff>();
	
	@JoinColumn(name = "FACULTY_ID", referencedColumnName = "FACULTY_ID")
	@ManyToOne
	Faculty faculty;
	
	public Department(){
		
	}
	
	public Department(Long departmentId){
		this.departmentId = departmentId;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public List<Staff> getStaff() {
		return staff;
	}

	public void setStaff(List<Staff> staff) {
		this.staff = staff;
	}

	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", name=" + name + ", createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + ", status=" + status + ", faculty=" + faculty + "]";
	}
	

}
