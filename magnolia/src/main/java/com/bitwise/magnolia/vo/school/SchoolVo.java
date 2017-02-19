package com.bitwise.magnolia.vo.school;

public class SchoolVo {

	private long schoolId;
	private String email;
	private String schoolAddress;
	private String schoolName;
	private String schoolLogo;
	private String alias;
	private String createdAt;
	private int validDays;
	private String webSite;
	
	public SchoolVo(){
		
	}

	public long getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(long schoolId) {
		this.schoolId = schoolId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSchoolAddress() {
		return schoolAddress;
	}

	public void setSchoolAddress(String schoolAddress) {
		this.schoolAddress = schoolAddress;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getSchoolLogo() {
		return schoolLogo;
	}

	public void setSchoolLogo(String schoolLogo) {
		this.schoolLogo = schoolLogo;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
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

	public String getWebSite() {
		return webSite;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	@Override
	public String toString() {
		return "SchoolVo [schoolId=" + schoolId + ", email=" + email + ", schoolAddress=" + schoolAddress
				+ ", schoolName=" + schoolName + ", schoolLogo=" + schoolLogo + ", alias=" + alias + ", createdAt="
				+ createdAt + ", validDays=" + validDays + ", webSite=" + webSite + "]";
	}
	
}
