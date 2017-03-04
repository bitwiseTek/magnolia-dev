package com.bitwise.magnolia.model.common;
/**
 *  
 * @author Sika Kay
 * @date 10/06/16
 *
 */
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name="ACADEMIC_SEMESTERS")
@NamedQueries({
	@NamedQuery(name="AcademicSemester.findById", query="select distinct a from AcademicSemester a where a.id=:id"),
	@NamedQuery(name="AcademicSemester.findByName", query="select distinct a from AcademicSemester a where a.name=:name"),
	@NamedQuery(name="AcademicSemester.findAll", query="select a from AcademicSemester a")
})
public class AcademicSemester implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String name;
	
	private String session;
	
	private DateTime startDate;
	
	private DateTime endDate;
	
	private DateTime updatedAt;
	
	public AcademicSemester() {
		
	}
	
	public AcademicSemester(Long id) {
		this.id = id;
	}

	@Id
	@Column(name="SEMESTER_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name="SEMESTER_NAME", nullable=false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name="ACADEMIC_SESSION", nullable=false)
	public String getSession() {
		return session;
	}

	public void setSession(String session) {
		this.session = session;
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

	@DateTimeFormat(iso=ISO.DATE_TIME)
	@Column(name="UPDATED_AT", nullable=false)
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	public DateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(DateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	@Transient
	public String getUpdatedAtString() {
		return org.joda.time.format.DateTimeFormat.forPattern("dd-MM-yyyy HH:mm:ss").print(updatedAt);
	}
}
