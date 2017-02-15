package com.bitwise.magnolia.domain.school;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SCHOOLS")
public class School implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "SCHOOL_ID")
	private Long schoolId;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "SCHOOL_NAME")
	private String schoolName;
	
	@Column(name = "SCHOOL_ADDRESS")
	private String schoolAddress;
	
	@Column(name = "ALIAS")
	private String alias;
	
	@Column(name = "WEBSITE")
	private String website;
	
	@Column(name = "CREATED_AT")
	private String createdAt;
	
	@Column(name = "VALID_DAYS")
	private int validDays;
	
	@Column(name = "SCHOOL_LOGO")
	private String schoolLogo;
	
	@Column(name = "API_KEY")
	private String apiKey;
	
	@Column(name = "STATUS")
	private String status;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "school")
	private List<SubSchool> subSchoolList;
	
	public School(){
		
	}
	
	public School(Long schoolId){
		this.schoolId = schoolId;
	}

	public Long getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(Long schoolId) {
		this.schoolId = schoolId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getSchoolAddress() {
		return schoolAddress;
	}

	public void setSchoolAddress(String schoolAddress) {
		this.schoolAddress = schoolAddress;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public int getValidDays() {
		return validDays;
	}

	public void setValidDays(int validDays) {
		this.validDays = validDays;
	}

	public String getSchoolLogo() {
		return schoolLogo;
	}

	public void setSchoolLogo(String schoolLogo) {
		this.schoolLogo = schoolLogo;
	}

	public String getStatus() {
		return status;
	}

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<SubSchool> getSubSchoolList() {
		return subSchoolList;
	}

	public void setSubSchoolList(List<SubSchool> subSchoolList) {
		this.subSchoolList = subSchoolList;
	}

	@Override
	public String toString() {
		return "School [schoolId=" + schoolId + ", email=" + email + ", schoolName=" + schoolName + ", schoolAddress="
				+ schoolAddress + ", alias=" + alias + ", website=" + website + ", createdAt=" + createdAt
				+ ", validDays=" + validDays + ", schoolLogo=" + schoolLogo + ", status=" + status + "]";
	}

}
