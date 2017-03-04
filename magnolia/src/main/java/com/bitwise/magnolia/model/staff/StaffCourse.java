package com.bitwise.magnolia.model.staff;
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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.bitwise.magnolia.common.ApplicationConstant;
import com.bitwise.magnolia.model.course.Course;

@Entity
@Table(name="STAFF_COURSES")
@NamedQueries({
	@NamedQuery(name="StaffCourse.findById", query="select distinct s from StaffCourse s where s.id=:id"),
	@NamedQuery(name="StaffCourse.findAllAttachedOne", query="select s from StaffCourse s where s.course.semester.id=:semesterId and s.toggleOnOff=:toggle"),
	@NamedQuery(name="StaffCourse.findAllAttachedTwo", query="select s from StaffCourse s where s.course.semester.id=:semesterId and s.toggleOnOff=:toggle"),
	@NamedQuery(name="StaffCourse.findAllPendingOne", query="select s from StaffCourse s where s.course.semester.id=:semesterId and s.courseStatus=:status"),
	@NamedQuery(name="StaffCourse.findAllPendingTwo", query="select s from StaffCourse s where s.course.semester.id=:semesterId and s.courseStatus=:status"),
	@NamedQuery(name="StaffCourse.findAllCompletedOne", query="select s from StaffCourse s where s.course.semester.id=:semesterId and s.courseStatus=:status"),
	@NamedQuery(name="StaffCourse.findAllCompletedTwo", query="select s from StaffCourse s where s.course.semester.id=:semesterId and s.courseStatus=:status"),
	@NamedQuery(name="StaffCourse.findAllOne", query="select s from StaffCourse s where s.course.semester.id=:semesterId"),
	@NamedQuery(name="StaffCourse.findAllTwo", query="select s from StaffCourse s where s.course.semester.id=:semesterId"),
	@NamedQuery(name="StaffCourse.findAll", query="select s from StaffCourse s")
})
public class StaffCourse implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;

	private Boolean toggleOnOff;
	
	private String courseStatus;

	private DateTime startDate;
	
	private DateTime endDate;
	
	private Course course;
	
	private List<Staff> staff = new ArrayList<Staff>();
	
	public StaffCourse() {
		
	}
	
	public StaffCourse(Long id) {
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
	@JoinTable(name="LINK_STAFF_COURSES_STAFF", joinColumns={@JoinColumn(name="STAFF_COURSE_ID")}, inverseJoinColumns={@JoinColumn(name="STAFF_ID")})
	public List<Staff> getStaff() {
		return staff;
	}

	public void setStaff(List<Staff> staff) {
		this.staff = staff;
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
		if (!(obj instanceof StaffCourse))
			return false;
		StaffCourse other = (StaffCourse) obj;
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
		return "StudentSubject [id=" + id + ", toggleOnOff=" + toggleOnOff + "]";
	}

}
