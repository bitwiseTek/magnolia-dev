package com.bitwise.magnolia.web.restful.resource.user;
/**
 *  
 * @author Sika Kay
 * @date 22/02/17
 *
 */
import java.text.SimpleDateFormat;
import java.util.Date;

import org.joda.time.DateTime;
import org.springframework.hateoas.ResourceSupport;

import com.bitwise.magnolia.common.ApplicationConstant;
import com.bitwise.magnolia.common.Utils;
import com.bitwise.magnolia.model.common.LGA;
import com.bitwise.magnolia.model.common.State;
import com.bitwise.magnolia.model.user.User;

public class UserResource extends ResourceSupport {

	public UserResource() {
		
	}
	
	private Long rid;
	
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
	
	private String username;
	
	private String password;
	
	private String tempPassword = Utils.generateRandomPassword();
	
	private String secretQuestion;
	
	private String secretAnswer = "Elizabeth";
	
	private String status;
	
	private String oneTimeToken;
	
	private String state;
	
	private String lga;
	
	private String photoBase64;
	
	private String createdAt;
	
	private String lastLogin;
	
	private String lastLogout;
	
	private String recoveryTime;
	
	private String recoveryToken;
	
	private int daysActive;
	
	public Long getRid() {
		return rid;
	}

	public void setRid(Long rid) {
		this.rid = rid;
	}

	public String getSystemId() {
		return systemId;
	}

	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getPrimaryEmail() {
		return primaryEmail;
	}

	public void setPrimaryEmail(String primaryEmail) {
		this.primaryEmail = primaryEmail;
	}

	public String getSecondaryEmail() {
		return secondaryEmail;
	}

	public void setSecondaryEmail(String secondaryEmail) {
		this.secondaryEmail = secondaryEmail;
	}

	public String getPrimaryNumber() {
		return primaryNumber;
	}

	public void setPrimaryNumber(String primaryNumber) {
		this.primaryNumber = primaryNumber;
	}

	public String getSecondaryNumber() {
		return secondaryNumber;
	}

	public void setSecondaryNumber(String secondaryNumber) {
		this.secondaryNumber = secondaryNumber;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getUsername() {
		username = firstName.toLowerCase().concat(".").concat(lastName.toLowerCase()).concat("@magnoliacad.com");
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTempPassword() {
		return tempPassword;
	}

	public void setTempPassword(String tempPassword) {
		this.tempPassword = tempPassword;
	}

	public String getSecretQuestion() {
		return secretQuestion;
	}

	public void setSecretQuestion(String secretQuestion) {
		this.secretQuestion = secretQuestion;
	}

	public String getSecretAnswer() {
		return secretAnswer;
	}

	public void setSecretAnswer(String secretAnswer) {
		this.secretAnswer = secretAnswer;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getOneTimeToken() {
		return oneTimeToken;
	}

	public void setOneTimeToken(String oneTimeToken) {
		this.oneTimeToken = oneTimeToken;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getLga() {
		return lga;
	}

	public void setLga(String lga) {
		this.lga = lga;
	}

	public String getPhotoBase64() {
		return photoBase64;
	}

	public void setPhotoBase64(String photoBase64) {
		this.photoBase64 = photoBase64;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(String lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getLastLogout() {
		return lastLogout;
	}

	public void setLastLogout(String lastLogout) {
		this.lastLogout = lastLogout;
	}

	public String getRecoveryTime() {
		return recoveryTime;
	}

	public void setRecoveryTime(String recoveryTime) {
		this.recoveryTime = recoveryTime;
	}

	public String getRecoveryToken() {
		return recoveryToken;
	}

	public void setRecoveryToken(String recoveryToken) {
		this.recoveryToken = recoveryToken;
	}
	
	public int getDaysActive() {
		return daysActive;
	}

	public void setDaysActive(int daysActive) {
		this.daysActive = daysActive;
	}

	public User toUser() {
		User user = new User();
		user.setId(rid);
		user.setBirthday(birthday);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setMiddleName(middleName);
		user.setTempPassword(tempPassword);
		user.setPassword(tempPassword);
		user.setUsername(firstName.toLowerCase().concat(".").concat(lastName.toLowerCase()).concat("@magnoliacad.com"));
		user.setPrimaryEmail(primaryEmail);
		user.setPrimaryNumber(primaryNumber);
		user.setSecondaryEmail(secondaryEmail);
		user.setSecondaryNumber(secondaryNumber);
		user.setStreetAddress(streetAddress);
		user.setSystemId(Utils.getCustomString(10, ""));
		user.setSex(sex);
		user.setSecretQuestion(secretQuestion);
		user.setSecretAnswer(secretAnswer);
		user.setOneTimeToken(Utils.generateUUID());
		user.setState(new State(Long.parseLong(state)));
		user.setLga(new LGA(Long.parseLong(lga)));
		user.setPhotoBase64(Utils.saveBase64ToPath(photoBase64, ApplicationConstant.SCHOOL_ALIAS, firstName.toLowerCase().concat(".").concat(lastName.toLowerCase()).concat("@magnoliacad.com") + ".png"));
		user.setStatus(status);
		user.setCreatedAt(new DateTime(DateTime.now()));
		user.setLastLogin(new SimpleDateFormat("E, dd MMM Y h:mm a").format(new Date()));
		user.setLastLogout(new SimpleDateFormat("E, dd MMM Y h:mm a").format(new Date()));
		user.setRecoveryTime(null);
		user.setRecoveryToken(recoveryToken);
		return user;
		
	}
	
}
