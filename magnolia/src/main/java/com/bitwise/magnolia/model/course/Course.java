package com.bitwise.magnolia.model.course;
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
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.NamedQueries;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.bitwise.magnolia.model.common.AcademicSemester;
import com.bitwise.magnolia.model.common.StudyProgramme;
import com.bitwise.magnolia.model.staff.Staff;
import com.bitwise.magnolia.model.staff.StaffCourse;
import com.bitwise.magnolia.model.student.StudentCourse;
import com.bitwise.magnolia.model.user.User;

@Entity
@Table(name="COURSES")
@NamedQueries({
	@NamedQuery(name="Course.findById", query="select distinct c from Course c where c.id=:id"),
	@NamedQuery(name="Course.findByName", query="select distinct c from Course c where c.name=:name"),
	@NamedQuery(name="Course.findByCode", query="select distinct c from Course c where c.code=:code"),
	@NamedQuery(name="Course.findByStaffId", query="select c from Course c where c.courseLecturer.id=:staffId"),
	@NamedQuery(name="Course.findByProgrammeId", query="select c from Course c where c.studyProgramme.id=:programmeId"),
	@NamedQuery(name="Course.findAll", query="select c from Course c")
})
public class Course implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String name;
	
	private String code;
	
	private String description;
	
	private String status;
	
	private String optionality;
	
	private Integer academicLevel;
	
	private Double creditUnit;
	
	private DateTime createdAt;
	
	private DateTime updatedAt;
	
	private User createdBy;
	
	private User updatedBy;
	
	private Staff courseLecturer;
	
	private StudyProgramme studyProgramme;
	
	private AcademicSemester semester;
	
	private List<StudentCourse> studentCourses = new ArrayList<StudentCourse>();
	
	private List<StaffCourse> staffCourses = new ArrayList<StaffCourse>();
	
	public Course() {
		
	}
	
	public Course(Long id) {
		this.id = id;
	}

	@Id
	@Column(name="COURSE_ID")
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

	@Column(name="DESCRIPTION")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name="STATUS", nullable=false)
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name="OPTIONALITY", nullable=false)
	public String getOptionality() {
		return optionality;
	}

	public void setOptionality(String optionality) {
		this.optionality = optionality;
	}

	@Column(name="ACAD_LEVEL", nullable=false)
	public Integer getAcademicLevel() {
		return academicLevel;
	}

	public void setAcademicLevel(Integer academicLevel) {
		this.academicLevel = academicLevel;
	}

	@Column(name="CREDIT_UNIT", nullable=false)
	public Double getCreditUnit() {
		return creditUnit;
	}

	public void setCreditUnit(Double creditUnit) {
		this.creditUnit = creditUnit;
	}

	@ManyToOne
	@JoinColumn(name="STAFF_ID")
	public Staff getCourseLecturer() {
		return courseLecturer;
	}

	public void setCourseLecturer(Staff courseLecturer) {
		this.courseLecturer = courseLecturer;
	}

	@ManyToOne
	@JoinColumn(name="STUDY_PROGRAMME_ID")
	public StudyProgramme getStudyProgramme() {
		return studyProgramme;
	}

	public void setStudyProgramme(StudyProgramme studyProgramme) {
		this.studyProgramme = studyProgramme;
	}

	@ManyToOne
	@JoinColumn(name="SEMESTER_ID")
	public AcademicSemester getSemester() {
		return semester;
	}

	public void setSemester(AcademicSemester semester) {
		this.semester = semester;
	}

	@OneToMany(cascade=CascadeType.ALL, mappedBy="course", orphanRemoval=true)
	public List<StudentCourse> getStudentCourses() {
		return studentCourses;
	}

	public void setStudentCourses(List<StudentCourse> studentCourses) {
		this.studentCourses = studentCourses;
	}
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="course", orphanRemoval=true)
	public List<StaffCourse> getStaffCourses() {
		return staffCourses;
	}

	public void setStaffCourses(List<StaffCourse> staffCourses) {
		this.staffCourses = staffCourses;
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Course))
			return false;
		Course other = (Course) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Subject [id=" + id + ", name=" + name + "]";
	}
}
