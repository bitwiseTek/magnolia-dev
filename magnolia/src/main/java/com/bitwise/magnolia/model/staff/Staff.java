package com.bitwise.magnolia.model.staff;
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
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import com.bitwise.magnolia.model.school.Department;
import com.bitwise.magnolia.model.user.User;

@Entity
@Table(name="STAFF", uniqueConstraints = @UniqueConstraint(columnNames = {
"staff_id" }))
@NamedQueries({
	@NamedQuery(name="Staff.findById", query="select distinct s from Staff s where s.id=:id"),
	@NamedQuery(name="Staff.findByStaffId", query="select distinct s from Staff s where s.staffId=:staffId"),
	@NamedQuery(name="Staff.findByApiKey", query="select distinct s from Staff s where s.apiKey=:apiKey"),
	@NamedQuery(name="Staff.findByDepartmentId", query="select s from Staff s where s.staffDepartment.departmentId=:deptId"),
	@NamedQuery(name="Staff.findAll", query="select s from Staff s")
})
public class Staff implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String staffId;
	
	private String title;
	
	private Boolean isAcademic;
	
	private Boolean isTemporary;
	
	private String apiKey;
	
	private String status;
	
	private User user;
	
	private Department staffDepartment;
	
	public Staff() {
		
	}
	
	public Staff(Long id) {
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

	@ManyToOne
	@JoinColumn(name="DEPARTMENT_ID")
	public Department getStaffDepartment() {
		return staffDepartment;
	}

	public void setStaffDepartment(Department staffDepartment) {
		this.staffDepartment = staffDepartment;
	}

	@NotNull
	@Column(name = "STAFF_ID")
	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	@NotNull
	@Column(name = "TITLE")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "IS_ACADEMIC")
	public Boolean getIsAcademic() {
		return isAcademic;
	}

	public void setIsAcademic(Boolean isAcademic) {
		this.isAcademic = isAcademic;
	}

	@Column(name = "IS_TEMP")
	public Boolean getIsTemporary() {
		return isTemporary;
	}

	public void setIsTemporary(Boolean isTemporary) {
		this.isTemporary = isTemporary;
	}

	@NotNull
	@Column(name = "API_KEY")
	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	@NotNull
	@Column(name = "STATUS")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
		return "Staff [staffId=" + staffId + ", title=" + title + ", apiKey=" + apiKey + ", "
				+ "status=" + status +  ", department=" + staffDepartment + "]";
	}
}
