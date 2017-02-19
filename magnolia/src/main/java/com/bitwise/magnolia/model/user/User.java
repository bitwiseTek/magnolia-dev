package com.bitwise.magnolia.model.user;
/**
 *  
 * @author Sika Kay
 * @date 17/02/17
 *
 */
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import com.bitwise.magnolia.common.Utils;
import com.bitwise.magnolia.model.common.LGA;
import com.bitwise.magnolia.model.common.State;
import com.bitwise.magnolia.model.security.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="USERS", uniqueConstraints = @UniqueConstraint(columnNames = {
"username" }))
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public User() {
		
	}
	
	public User(long id) {
		this.id = id;
	}
	
	public User(long id, String username, String emailAddress, String oneTimeToken) {
		this.id = id;
		this.username = username;
		this.oneTimeToken = oneTimeToken;
	}
	
	private long id;
	
	private String systemId;
	
	private String firstName;
	
	private String lastName;
	
	private String middleName;
	
	private String birthday;
	
	private String primaryEmail;
	
	private String secondaryEmail;
	
	private String primaryNumber;
	
	private String secondaryNumber;
	
	private String streetAddress;
	
	private String sex;
	
	private List<Role> roles = new ArrayList<Role>();
	
	private String username;
	
	private String password;
	
	private String tempPassword;
	
	private String secretQuestion = Utils.getQuestions().get("Q1");
	
	private String secretAnswer = "Elizabeth";
	
	private String status;
	
	private String oneTimeToken;
	
	private State state;
	
	private LGA lga;
	
	private String photoBase64;
	
	private String createdAt = new SimpleDateFormat("dd/MM/yyyy HH.mm.ss").format(new Date());
	
	private String lastLogin = new SimpleDateFormat("dd/MM/yyyy HH.mm.ss").format(new Date());
	
	private String lastLogout;

	@Id
	@Column(name="USER_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@NotNull
	@Column(name="SYSTEM_ID")
	public String getSystemId() {
		return systemId;
	}

	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}

	@Column(name="MIDDLE_NAME")
	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	@NotNull
	@Column(name="BIRTHDAY")
	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	@NotNull
	@Column(name="PRIMARY_EMAIL")
	public String getPrimaryEmail() {
		return primaryEmail;
	}

	public void setPrimaryEmail(String primaryEmail) {
		this.primaryEmail = primaryEmail;
	}

	@Column(name="SECONDARY_EMAIL")
	public String getSecondaryEmail() {
		return secondaryEmail;
	}

	public void setSecondaryEmail(String secondaryEmail) {
		this.secondaryEmail = secondaryEmail;
	}

	@NotNull
	@Column(name="PRIMARY_PHONE")
	public String getPrimaryNumber() {
		return primaryNumber;
	}

	public void setPrimaryNumber(String primaryNumber) {
		this.primaryNumber = primaryNumber;
	}

	@Column(name="SECONDARY_PHONE")
	public String getSecondaryNumber() {
		return secondaryNumber;
	}

	public void setSecondaryNumber(String secondaryNumber) {
		this.secondaryNumber = secondaryNumber;
	}

	@NotNull
	@Column(name="STREET_ADDRESS")
	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	@NotNull
	@Column(name="SEX")
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@NotNull
	@Column(name="SECRET_QUESTION")
	public String getSecretQuestion() {
		return secretQuestion;
	}

	public void setSecretQuestion(String secretQuestion) {
		this.secretQuestion = secretQuestion;
	}

	@NotNull
	@Column(name="SECRET_ANSWER")
	public String getSecretAnswer() {
		return secretAnswer;
	}

	public void setSecretAnswer(String secretAnswer) {
		this.secretAnswer = secretAnswer;
	}

	@JsonIgnore
	@Column(name="OTT")
	public String getOneTimeToken() {
		return oneTimeToken;
	}

	public void setOneTimeToken(String oneTimeToken) {
		this.oneTimeToken = oneTimeToken;
	}

	@NotNull
	@Column(name="STATUS")
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}

	@NotNull
	@Column(name="FIRST_NAME")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	
	@Transient
	public String getFullName() {
		return getFirstName() + ' ' + getLastName();
	}

	@NotNull
	@Column(name="LAST_NAME")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name="LINK_USERS_ROLES", joinColumns={@JoinColumn(name="USER_ID")}, inverseJoinColumns={@JoinColumn(name="ROLE_ID")})
	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	@NotNull
	@Column(name="USERNAME")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@NotNull
	@JsonIgnore
	@Column(name="USER_PASSWORD")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@NotNull
	@JsonIgnore
	@Column(name="TEMP_PASSWORD")
	public String getTempPassword() {
		return tempPassword;
	}

	public void setTempPassword(String tempPassword) {
		this.tempPassword = tempPassword;
	}

	@ManyToOne
	@JoinColumn(name="STATE_ID")
	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	@ManyToOne
	@JoinColumn(name="LGA_ID")
	public LGA getLga() {
		return lga;
	}

	public void setLga(LGA lga) {
		this.lga = lga;
	}

	@NotNull
	@Column(name="PHOTO_BASE64")
	public String getPhotoBase64() {
		return photoBase64;
	}

	public void setPhotoBase64(String photoBase64) {
		this.photoBase64 = photoBase64;
	}

	@Column(name="LAST_USER_LOGIN", nullable=false)
	public String getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(String lastLogin) {
		this.lastLogin = lastLogin;
	}

	@Column(name="LAST_USER_LOGOUT", nullable=false)
	public String getLastLogout() {
		return lastLogout;
	}

	public void setLastLogout(String lastLogout) {
		this.lastLogout = lastLogout;
	}
	
	@Column(name="CREATED_AT", nullable=false)
	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", password=" + password
				+ ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + primaryEmail + "]";
	}
}
