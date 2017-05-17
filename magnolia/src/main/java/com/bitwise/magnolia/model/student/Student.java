package com.bitwise.magnolia.model.student;
/**
 *  
 * @author Sika Kay
 * @date 22/02/17
 *
 */
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.NamedQueries;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.bitwise.magnolia.common.ApplicationConstant;
import com.bitwise.magnolia.model.common.StudyProgramme;
import com.bitwise.magnolia.model.school.Department;
import com.bitwise.magnolia.model.user.User;

@Entity
@Table(name="STUDENTS", uniqueConstraints = @UniqueConstraint(columnNames = {
"student_id" }))
@NamedQueries({
	@NamedQuery(name="Student.findById", query="select distinct s from Student s where s.id=:id"),
	@NamedQuery(name="Student.findByStudentId", query="select distinct s from Student s where s.studentId=:studentId"),
	@NamedQuery(name="Student.findByUserId", query="select distinct s from Student s where s.user.id=:userId"),
	@NamedQuery(name="Student.findByApiKey", query="select distinct s from Student s where s.apiKey=:apiKey"),
	@NamedQuery(name="Student.findByDepartmentId", query="select s from Student s where s.studentDepartment.departmentId=:deptId"),
	@NamedQuery(name="Student.findByProgrammeId", query="select s from Student s where s.studyProgramme.id=:programmeId"),
	@NamedQuery(name="Student.findAll", query="select s from Student s")
})
public class Student implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String studentId;
	
	private String studyEndReason;
	
	private String studyEndText;
	
	private String studyStatus;
	
	private String lodging;
	
	private String participationType;
	
	private String courseEnrolmentType;
	
	private String apiKey;
	
	private String status;
	
	private DateTime startDate;
	
	private DateTime actualEndDate;
	
	private StudyProgramme studyProgramme;
	
	private DateTime programmeEndDate;
	
	private Department studentDepartment;
	
	private User user;
	
	public Student() {
		
	}
	
	public Student(String studentId){
		this.studentId = studentId;
	}
	
	public Student(Long id){
		this.id = id;
	}
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@NotNull
	@Column(name = "STUDENT_ID")
	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	@Column(name = "API_KEY", nullable=false)
	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	@Column(name = "STATUS", nullable=false)
	public String getStatus() {
		return status;
	}
	
	@DateTimeFormat(iso=ISO.DATE_TIME)
	@Column(name="START_DATE", nullable=false)
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	public DateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(DateTime startDate) {
		this.startDate = startDate;
	}
	
	@Transient
	public String getStartDateString() {
		return org.joda.time.format.DateTimeFormat.forPattern("E, dd MMM Y h:mm a").print(startDate);
	}
	
	@DateTimeFormat(iso=ISO.DATE_TIME)
	@Column(name="ACTUAL_END_DATE", nullable=false)
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	public DateTime getActualEndDate() {
		return actualEndDate;
	}

	public void setActualEndDate(DateTime actualEndDate) {
		this.actualEndDate = actualEndDate;
	}

	@Transient
	public String getActualEndDateString() {
		if (getHasFinishedStudies()) {
			return org.joda.time.format.DateTimeFormat.forPattern("dd-MM-yyyy HH:mm:ss").print(actualEndDate);
		} else {
			return org.joda.time.format.DateTimeFormat.forPattern("dd-MM-yyyy HH:mm:ss").print(studyProgramme.getEndDate());
		}
	}
	
	@Transient
	public boolean getHasStartedStudies() {
		return startDate != null && startDate.isBeforeNow();
	}
	
	@Transient
	public boolean getHasFinishedStudies() {
		return programmeEndDate != null && programmeEndDate.isBeforeNow();
	}
	
	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "STUDY_END_REASON", nullable=false)
	public String getStudyEndReason() {
		return studyEndReason;
	}

	public void setStudyEndReason(String studyEndReason) {
		this.studyEndReason = studyEndReason;
	}

	@Column(name = "STUDY_END_TEXT")
	public String getStudyEndText() {
		return studyEndText;
	}

	public void setStudyEndText(String studyEndText) {
		this.studyEndText = studyEndText;
	}

	@Column(name="STUDY_STATUS", nullable=false)
	public String getStudyStatus() {
		if (getHasStartedStudies()) {
			return ApplicationConstant.INVIEW_STATUS;
		} else if (getHasFinishedStudies()) {
			return ApplicationConstant.COMPLETED_STATUS;
		}
		return studyStatus;
	}

	public void setStudyStatus(String studyStatus) {
		this.studyStatus = studyStatus;
	}

	@Column(name = "LODGING", nullable=false)
	public String getLodging() {
		return lodging;
	}

	public void setLodging(String lodging) {
		this.lodging = lodging;
	}

	@Column(name="PART_TYPE", nullable=false)
	public String getParticipationType() {
		return participationType;
	}

	public void setParticipationType(String participationType) {
		this.participationType = participationType;
	}

	@Column(name="ENROL_TYPE", nullable=false)
	public String getCourseEnrolmentType() {
		return courseEnrolmentType;
	}

	public void setCourseEnrolmentType(String courseEnrolmentType) {
		this.courseEnrolmentType = courseEnrolmentType;
	}

	@ManyToOne
	@JoinColumn(name = "STUDY_PROGRAMME_ID", referencedColumnName = "STUDY_PROGRAMME_ID")
	public StudyProgramme getStudyProgramme() {
		return studyProgramme;
	}

	public void setStudyProgramme(StudyProgramme studyProgramme) {
		this.studyProgramme = studyProgramme;
	}

	@DateTimeFormat(iso=ISO.DATE_TIME)
	@Column(name="END_DATE", nullable=false)
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	public DateTime getProgrammeEndDate() {
		return programmeEndDate;
	}

	public void setProgrammeEndDate(DateTime programmeEndDate) {
		this.programmeEndDate = programmeEndDate;
	}

	@ManyToOne
	@JoinColumn(name = "DEPARTMENT_ID", referencedColumnName = "DEPARTMENT_ID")
	public Department getStudentDepartment() {
		return studentDepartment;
	}

	public void setStudentDepartment(Department studentDepartment) {
		this.studentDepartment = studentDepartment;
	}

	@OneToOne
	@JoinColumn(name="USER_ID")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", status=" + status + ", studyEndReason=" + studyEndReason
				+ ", studyEndText=" + studyEndText + ", studyStatus=" + studyEndReason + ", apiKey=" + apiKey + ", "
				+ "status=" + status +  ", department=" + studentDepartment + "]";
	}
}
