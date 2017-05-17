package com.bitwise.magnolia.model.finance;
/**
 *  
 * @author Sika Kay
 * @date 25/04/17
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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.bitwise.magnolia.common.Utils;
import com.bitwise.magnolia.model.common.AcademicSemester;
import com.bitwise.magnolia.model.student.Student;
import com.bitwise.magnolia.model.student.StudentCourse;
import com.bitwise.magnolia.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="BILLING_DETAILS")
@NamedQueries({
	@NamedQuery(name="BillingDetails.findById", query="select distinct b from BillingDetails b where b.id=:id"),
	@NamedQuery(name="BillingDetails.findByStudentId", query="select distinct b from BillingDetails b where b.studentId.id=:studentId"),
	@NamedQuery(name="BillingDetails.findAllCompleted", query="select b from BillingDetails b where b.status=:status"),
	@NamedQuery(name="BillingDetails.findAll", query="select b from BillingDetails b")
})
public class BillingDetails implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public BillingDetails() {
		
	}
	
	public BillingDetails(Long id) {
		this.id = id;
	}

	private Long id;
	
	private Student personName;
	
	private Student streetAddress;
	
	private Student lga;
	
	private Student state;
	
	private Student emailAddress;
	
	private String referenceNumber = Utils.generateRandomRef();
	
	private Student studentId;
	
	private Float feesAmount = 65600.00F;
	
	private String status;
	
	private String statement;
	
	private String paymentMethod;
	
	private String paymentReference;
	
	private String responseCode;
	
	private User userId;
	
	private AcademicSemester semester;
	
	private Student studyProgramme;
	
	private List<StudentCourse> studentCourses = new ArrayList<StudentCourse>();
	
	private String notes;
	
	private int productId = 6205;
	
	private int payItemId = 101;
	
	private Float feesAmountKobo = feesAmount*100;
	
	private String siteRedirectUrl = "http://portal.magnoliacad.com/students/bill/pay/success";
	
	private String macKey = "D3D1D05AFE42AD50818167EAC73C109168A0F108F32645C8B59E897FA930DA44F9230910DAC9E20641823799A107A02068F7BC0F4CC41D2952E249552255710F";
	
	private String hashVal = DigestUtils.sha512Hex(referenceNumber + productId + payItemId + feesAmountKobo + siteRedirectUrl + macKey);
	
	private DateTime paidAt;

	@Id
	@Column(name="BILLING_DETAILS_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@OneToOne
	@JoinColumn(name="STUDENT_FULL_NAME")
	public Student getPersonName() {
		return personName;
	}

	public void setPersonName(Student personName) {
		this.personName = personName;
	}

	@OneToOne
	@JoinColumn(name="STREET_ADDRESS")
	public Student getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(Student streetAddress) {
		this.streetAddress = streetAddress;
	}

	@OneToOne
	@JoinColumn(name="LGA")
	public Student getLga() {
		return lga;
	}

	public void setLga(Student lga) {
		this.lga = lga;
	}

	@OneToOne
	@JoinColumn(name="STATE")
	public Student getState() {
		return state;
	}

	public void setState(Student state) {
		this.state = state;
	}

	@OneToOne
	@JoinColumn(name="EMAIL_ADDRESS")
	public Student getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(Student emailAddress) {
		this.emailAddress = emailAddress;
	}

	@JsonIgnore
	@Column(name="REFERENCE_NUMBER", nullable=false)
	public String getReferenceNumber() {
		return referenceNumber;
	}

	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}

	@OneToOne
	@JoinColumn(name="STUDENT_ID")
	public Student getStudentId() {
		return studentId;
	}

	public void setStudentId(Student studentId) {
		this.studentId = studentId;
	}

	@Column(name="FEES_AMOUNT", nullable=false)
	public Float getFeesAmount() {
		return feesAmount;
	}

	public void setFeesAmount(Float feesAmount) {
		this.feesAmount = feesAmount;
	}

	@Column(name="STATUS", nullable=false)
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name="STATEMENT")
	public String getStatement() {
		return statement;
	}

	public void setStatement(String statement) {
		this.statement = statement;
	}

	@Column(name="PAYMENT_METHOD", nullable=false)
	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	
	@Column(name="PAYMENT_REF")
	public String getPaymentReference() {
		return paymentReference;
	}

	public void setPaymentReference(String paymentReference) {
		this.paymentReference = paymentReference;
	}

	@Column(name="RESPONSE_CODE")
	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	@OneToOne
	@JoinColumn(name="USER_ID")
	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	@OneToMany(cascade=CascadeType.ALL, mappedBy="billing", orphanRemoval=true)
	public List<StudentCourse> getStudentCourses() {
		return studentCourses;
	}

	public void setStudentCourses(List<StudentCourse> studentCourses) {
		this.studentCourses = studentCourses;
	}

	@ManyToOne
	@JoinColumn(name="SEMESTER_ID")
	public AcademicSemester getSemester() {
		return semester;
	}

	public void setSemester(AcademicSemester semester) {
		this.semester = semester;
	}

	@OneToOne
	@JoinColumn(name="PROGRAMME_ID")
	public Student getStudyProgramme() {
		return studyProgramme;
	}

	public void setStudyProgramme(Student studyProgramme) {
		this.studyProgramme = studyProgramme;
	}

	@Column(name="HASH_VAL", nullable=false)
	public String getHashVal() {
		return hashVal;
	}

	public void setHashVal(String hashVal) {
		this.hashVal = hashVal;
	}

	@Column(name="NOTES")
	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	@DateTimeFormat(iso=ISO.DATE_TIME)
	@Column(name="PAID_AT", nullable=false)
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	public DateTime getPaidAt() {
		return paidAt;
	}

	public void setPaidAt(DateTime paidAt) {
		this.paidAt = paidAt;
	}
	
	@Transient
	public String getPaidAtString() {
		return org.joda.time.format.DateTimeFormat.forPattern("E, dd MMM Y h:mm a").print(paidAt);
	}

	@Column(name="PRODUCT_ID", nullable=false)
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	@Column(name="PAY_ITEM_ID", nullable=false)
	public int getPayItemId() {
		return payItemId;
	}

	public void setPayItemId(int payItemId) {
		this.payItemId = payItemId;
	}

	@Column(name="FEES_AMOUNT_KOBO", nullable=false)
	public Float getFeesAmountKobo() {
		return feesAmountKobo;
	}

	public void setFeesAmountKobo(Float feesAmountKobo) {
		this.feesAmountKobo = feesAmountKobo;
	}

	@Column(name="SITE_REDIRECT", nullable=false)
	public String getSiteRedirectUrl() {
		return siteRedirectUrl;
	}

	public void setSiteRedirectUrl(String siteRedirectUrl) {
		this.siteRedirectUrl = siteRedirectUrl;
	}

	@Column(name="MAC_KEY", nullable=false)
	public String getMacKey() {
		return macKey;
	}

	public void setMacKey(String macKey) {
		this.macKey = macKey;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((notes == null) ? 0 : notes.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof BillingDetails))
			return false;
		BillingDetails other = (BillingDetails) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", status=" + status + "]";
	}
}
