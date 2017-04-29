package com.bitwise.magnolia.web.restful.resource.finance;
import org.joda.time.DateTime;
/**
 *  
 * @author Sika Kay
 * @date 25/04/17
 *
 */
import org.springframework.hateoas.ResourceSupport;

import com.bitwise.magnolia.common.ApplicationConstant;
import com.bitwise.magnolia.model.common.AcademicSemester;
import com.bitwise.magnolia.model.finance.BillingDetails;
import com.bitwise.magnolia.model.student.Student;
import com.bitwise.magnolia.model.user.User;

public class BillingDetailsResource extends ResourceSupport {

	
	public BillingDetailsResource() {
		
	}
	
	private Long rid;
	
	private String personName;
	
	private String streetAddress;
	
	private String lga;
	
	private String state;
	
	private String emailAddress;
	
	private String studentId;
	
	private Float feesAmount;
	
	private String status;
	
	private String statement;
	
	private String paymentMethod;
	
	private String paymentReference;
	
	private String responseCode;
	
	private String userId;
	
	private String semester;
	
	private String studyProgramme;
	
	private String notes;
	
	private String paidAt;

	public Long getRid() {
		return rid;
	}

	public void setRid(Long rid) {
		this.rid = rid;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getLga() {
		return lga;
	}

	public void setLga(String lga) {
		this.lga = lga;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public Float getFeesAmount() {
		return feesAmount;
	}

	public void setFeesAmount(Float feesAmount) {
		this.feesAmount = feesAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatement() {
		return statement;
	}

	public void setStatement(String statement) {
		this.statement = statement;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getPaymentReference() {
		return paymentReference;
	}

	public void setPaymentReference(String paymentReference) {
		this.paymentReference = paymentReference;
	}

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public String getStudyProgramme() {
		return studyProgramme;
	}

	public void setStudyProgramme(String studyProgramme) {
		this.studyProgramme = studyProgramme;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	public String getPaidAt() {
		return paidAt;
	}

	public void setPaidAt(String paidAt) {
		this.paidAt = paidAt;
	}

	public BillingDetails toBilling() {
		BillingDetails billing = new BillingDetails();
		billing.setId(rid);
		billing.setEmailAddress(new Student(Long.parseLong(emailAddress)));
		billing.setFeesAmount(feesAmount);
		billing.setLga(new Student(Long.parseLong(lga)));
		billing.setState(new Student(Long.parseLong(state)));
		billing.setNotes(notes);
		billing.setPaymentMethod(paymentMethod);
		billing.setPaymentReference(paymentReference);
		billing.setPersonName(new Student(Long.parseLong(personName)));
		billing.setResponseCode(responseCode);
		billing.setSemester(new AcademicSemester(Long.parseLong(semester)));
		billing.setStudyProgramme(new Student(Long.parseLong(studyProgramme)));
		billing.setStatement(statement);
		billing.setStatus(ApplicationConstant.PENDING_STATUS);
		billing.setStreetAddress(new Student(Long.parseLong(streetAddress)));
		billing.setStudentId(new Student(Long.parseLong(studentId)));
		billing.setUserId(new User(Long.parseLong(userId)));
		billing.setPaidAt(new DateTime(DateTime.now()));
		return billing;
	}
}
