package com.bitwise.magnolia.vo.school;

public class StudentVo {

	private String studentId;
	private String firstName;
	private String otherNames;
	private String apiKey;
	private String studentApiKey;
	private String gender;
	private String telephone;
	private String email;
	private String dob;
	private String departmentName;
	private String address;
	private String photoBase64;
	
	public StudentVo(){
		
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

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	public String getStudentApiKey() {
		return studentApiKey;
	}

	public void setStudentApiKey(String studentApiKey) {
		this.studentApiKey = studentApiKey;
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

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhotoBase64() {
		return photoBase64;
	}

	public void setPhotoBase64(String photoBase64) {
		this.photoBase64 = photoBase64;
	}

	@Override
	public String toString() {
		return "StudentVo [studentId=" + studentId + ", firstName=" + firstName + ", otherNames=" + otherNames
				+ ", apiKey=" + apiKey + ", studentApiKey=" + studentApiKey + ", gender=" + gender + ", telephone="
				+ telephone + ", email=" + email + ", dob=" + dob + ", departmentName=" + departmentName + ", address="
				+ address + ", photoBase64=" + photoBase64 + "]";
	}
	
}
