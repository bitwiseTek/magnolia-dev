package com.bitwise.magnolia.model.common;
/**
 *  
 * @author Sika Kay
 * @date 26/02/17
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
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.bitwise.magnolia.model.course.Course;
import com.bitwise.magnolia.model.course.CourseLength;
import com.bitwise.magnolia.model.school.Department;
import com.bitwise.magnolia.model.student.Student;
import com.bitwise.magnolia.model.user.User;

@Entity
@Table(name="STUDY_PROGRAMMES")
@NamedQueries({
	@NamedQuery(name="StudyProgramme.findById", query="select distinct s from StudyProgramme s where s.id=:id"),
	@NamedQuery(name="StudyProgramme.findByName", query="select distinct s from StudyProgramme s where s.name=:name"),
	@NamedQuery(name="StudyProgramme.findByCode", query="select distinct s from StudyProgramme s where s.code=:code"),
	@NamedQuery(name="StudyProgramme.findByDepartmentId", query="select s from StudyProgramme s where s.department.departmentId=:deptId"),
	@NamedQuery(name="StudyProgramme.findByCategoryId", query="select s from StudyProgramme s where s.category.id=:categoryId"),
	@NamedQuery(name="StudyProgramme.findAll", query="select s from StudyProgramme s")
})
public class StudyProgramme implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String name;
	
	private String code;
	
	private String status;
	
	private String description;
	
	private Integer participants;
	
	private Integer maxParticipationCount;
	
	private DateTime createdAt;
	
	private DateTime updatedAt;
	
	public Integer programDays;
	
	private DateTime endDate;
	
	private User createdBy;
	
	private User updatedBy;
	
	private Department department;
	
	private CourseLength courseLength;
	
	private List<Student> students = new ArrayList<Student>();
	
	private List<Course> courses = new ArrayList<Course>();
	
	private StudyProgrammeCategory category;
	
	public StudyProgramme() {
		
	}

	public StudyProgramme(Long id) {
		this.id = id;
	}
	
	@Id
	@Column(name="STUDY_PROGRAMME_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name="NAME", nullable=false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name="CODE", nullable=false)
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@ManyToOne
	@JoinColumn(name="STUDY_PROGRAMME_CATEGORY_ID")
	public StudyProgrammeCategory getCategory() {
		return category;
	}

	public void setCategory(StudyProgrammeCategory category) {
		this.category = category;
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

	@Column(name="PROGRAMME_DAYS", nullable=false)
	public Integer getProgramDays() {
		return programDays;
	}

	public void setProgramDays(Integer programDays) {
		this.programDays = programDays;
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
	
	public void setParticipants(Integer participants) {
		this.participants = participants;
	}

	public void setMaxParticipationCount(Integer maxParticipationCount) {
		this.maxParticipationCount = maxParticipationCount;
	}

	@Column(name="DESCRIPTION")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name="MAX_PARTICIPANTS")
	public Integer getMaxParticipationCount() {
		return maxParticipationCount;
	}

	@Column(name="PARTICIPANTS")
	public Integer getParticipants() {
		return participants;
	}

	@DateTimeFormat(iso=ISO.DATE_TIME)
	@Column(name="CREATED_AT", nullable=false)
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	public DateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(DateTime createdAt) {
		this.createdAt = createdAt;
	}
	
	@Transient
	public String getCreatedAtString() {
		return org.joda.time.format.DateTimeFormat.forPattern("dd-MM-yyyy HH:mm:ss").print(createdAt);
	}

	@ManyToOne
	@JoinColumn(name="USER_ID")
	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	@ManyToOne
	@JoinColumn(name="UPDATER_ID")
	public User getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(User updatedBy) {
		this.updatedBy = updatedBy;
	}

	@ManyToOne
	@JoinColumn(name="DEPARTMENT_ID")
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@OneToMany(cascade=CascadeType.ALL, mappedBy="studyProgramme", orphanRemoval=true)
	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Column(name = "STATUS", nullable=false)
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@ManyToOne
	@JoinColumn(name="COURSE_LENGTH_ID")
	public CourseLength getCourseLength() {
		return courseLength;
	}

	public void setCourseLength(CourseLength courseLength) {
		this.courseLength = courseLength;
	}

	@OneToMany(cascade=CascadeType.ALL, mappedBy="studyProgramme", orphanRemoval=true)
	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
}
