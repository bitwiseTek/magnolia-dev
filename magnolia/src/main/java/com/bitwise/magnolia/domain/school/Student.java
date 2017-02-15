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
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "STUDENTS")
public class Student implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;
	
	@NotNull
	@Column(name = "STUDENT_ID")
	private String studentId;
	
	@Column(name = "FIRST_NAME")
	private String firstName;
	
	@Column(name = "OTHER_NAMES")
	private String otherNames;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "DOB")
	private String dob;
	
	@Column(name = "GENDER")
	private String gender;
	
	@Column(name = "TELEPHONE")
	private String telephone;
	
	@Column(name = "ADDRESS")
	private String address;
	
	@Column(name = "CREATED_AT")
	private String createdAt;
	
	@Column(name = "API_KEY")
	private String apiKey;
	
	@Column(name = "STATUS")
	private String status;
	
	@Column(name = "PHOTO_BASE64")
	private String photoBase64;
	
	@JoinColumn(name = "DEPARTMENT_ID", referencedColumnName = "DEPARTMENT_ID")
	@ManyToOne
	Department department;
	
	public Student(){
		
	}
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Student(String studentId){
		this.studentId = studentId;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getOtherNames() {
		return otherNames;
	}

	public void setOtherNames(String otherNames) {
		this.otherNames = otherNames;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
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

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPhotoBase64() {
		return photoBase64;
	}

	public void setPhotoBase64(String photoBase64) {
		this.photoBase64 = photoBase64;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", firstName=" + firstName + ", otherNames=" + otherNames
				+ ", email=" + email + ", dob=" + dob + ", gender=" + gender + ", telephone=" + telephone + ", address="
				+ address + ", createdAt=" + createdAt + ", apiKey=" + apiKey + ", status=" + status + ", photoBase64="
				+ photoBase64 + ", department=" + department + "]";
	}

	

}
