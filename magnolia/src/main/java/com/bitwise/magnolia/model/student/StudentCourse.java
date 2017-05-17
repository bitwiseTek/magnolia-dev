package com.bitwise.magnolia.model.student;
/**
 *  
 * @author Sika Kay
 * @date 27/02/17
 *
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.bitwise.magnolia.common.ApplicationConstant;
import com.bitwise.magnolia.model.course.Course;
import com.bitwise.magnolia.model.finance.BillingDetails;

@Entity
@Table(name="STUDENT_COURSES")
@NamedQueries({
	@NamedQuery(name="StudentCourse.findById", query="select distinct s from StudentCourse s where s.id=:id"),
	@NamedQuery(name="StudentCourse.findByBillingIdAndCourseId", query="select distinct s from StudentCourse s where s.billing.id=:billingId and s.course.id=:courseId"),
	@NamedQuery(name="StudentCourse.findAllRegisteredOne", query="select s from StudentCourse s where s.course.semester.id=:semesterId and s.toggleOnOff=:toggle"),
	@NamedQuery(name="StudentCourse.findAllRegisteredTwo", query="select s from StudentCourse s where s.course.semester.id=:semesterId and s.toggleOnOff=:toggle"),
	@NamedQuery(name="StudentCourse.findAllPendingOne", query="select s from StudentCourse s where s.course.semester.id=:semesterId and s.courseStatus=:status"),
	@NamedQuery(name="StudentCourse.findAllPendingTwo", query="select s from StudentCourse s where s.course.semester.id=:semesterId and s.courseStatus=:status"),
	@NamedQuery(name="StudentCourse.findAllCompletedOne", query="select s from StudentCourse s where s.course.semester.id=:semesterId and s.courseStatus=:status"),
	@NamedQuery(name="StudentCourse.findAllCompletedTwo", query="select s from StudentCourse s where s.course.semester.id=:semesterId and s.courseStatus=:status"),
	@NamedQuery(name="StudentCourse.findAllOne", query="select s from StudentCourse s where s.course.semester.id=:semesterId"),
	@NamedQuery(name="StudentCourse.findAllTwo", query="select s from StudentCourse s where s.course.semester.id=:semesterId"),
	@NamedQuery(name="StudentCourse.findAll", query="select s from StudentCourse s")
})
public class StudentCourse implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private Boolean toggleOnOff = Boolean.FALSE;
	
	private String courseStatus;

	private DateTime startDate;
	
	private DateTime endDate;
	
	private Course course;
	
	private BillingDetails billing;
	
	private List<Student> students = new ArrayList<Student>();
	
	public StudentCourse() {
		
	}
	
	public StudentCourse(Long id) {
		this.id = id;
	}
	
	@Id
	@Column(name="STUDENT_COURSE_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name="SELECTED")
	public Boolean getToggleOnOff() {
		return toggleOnOff;
	}

	public void setToggleOnOff(Boolean toggleOnOff) {
		this.toggleOnOff = toggleOnOff;
	}

	@ManyToOne
	@JoinColumn(name="COURSE_ID")
	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="LINK_STUDENT_COURSES_STUDENTS", joinColumns={@JoinColumn(name="STUDENT_COURSE_ID")}, inverseJoinColumns={@JoinColumn(name="STUDENT_ID")})
	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
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
		return org.joda.time.format.DateTimeFormat.forPattern("dd-MM-yyyy HH:mm:ss").print(startDate);
	}

	@DateTimeFormat(iso=ISO.DATE_TIME)
	@Column(name="END_DATE", nullable=false)
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	public DateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(DateTime endDate) {
		this.endDate = endDate;
	}

	@Transient
	public String getEndDateString() {
		return org.joda.time.format.DateTimeFormat.forPattern("dd-MM-yyyy HH:mm:ss").print(endDate);
	}
	
	@Transient
	public boolean getHasStartedCourse() {
		return startDate != null && startDate.isBeforeNow();
	}
	
	@Transient
	public boolean getHasFinishedCourse() {
		return endDate != null && endDate.isBeforeNow();
	}
	
	@Column(name="STATUS", nullable=false)
	public String getCourseStatus() {
		if (getHasStartedCourse()) {
			return ApplicationConstant.PENDING_STATUS;
		} else if (getHasFinishedCourse()) {
			return ApplicationConstant.COMPLETED_STATUS;
		}
		return courseStatus;
	}

	public void setCourseStatus(String courseStatus) {
		this.courseStatus = courseStatus;
	}

	@ManyToOne
	@JoinColumn(name="BILLING_ID")
	public BillingDetails getBilling() {
		return billing;
	}

	public void setBilling(BillingDetails billing) {
		this.billing = billing;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((toggleOnOff == null) ? 0 : toggleOnOff.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof StudentCourse))
			return false;
		StudentCourse other = (StudentCourse) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (toggleOnOff == null) {
			if (other.toggleOnOff != null)
				return false;
		} else if (!toggleOnOff.equals(other.toggleOnOff))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "StudentCourse [id=" + id + ", toggleOnOff=" + toggleOnOff + "]";
	}
}
