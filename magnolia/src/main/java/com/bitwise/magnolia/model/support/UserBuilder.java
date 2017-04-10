package com.bitwise.magnolia.model.support;
import org.joda.time.DateTime;
/**
 *  
 * @author Sika Kay
 * @date 16/06/16
 *
 */
import org.springframework.stereotype.Component;

import com.bitwise.magnolia.model.common.LGA;
import com.bitwise.magnolia.model.common.State;
//import com.bitwise.magnolia.model.security.Permission;
import com.bitwise.magnolia.model.security.Role;
import com.bitwise.magnolia.model.user.User;

@Component
public class UserBuilder extends EntityBuilder<User> {

	@Override
	void initProduct() {
		this.product = new User();
	}
	
	public UserBuilder state(State state) {
		this.product.setState(state);
		return this;
	}
	
	public UserBuilder lga(LGA lga) {
		this.product.setLga(lga);
		return this;
	}
	
	public UserBuilder name(String firstName, String lastName, String middleName) {
		this.product.setFirstName(firstName);
		this.product.setLastName(lastName);
		this.product.setMiddleName(middleName);
		return this;
	}
	
	public UserBuilder credentials(String username, String password, String tempPassword, String secretQuestion, String secretAnswer, 
			String lastLogin, String lastLogout, DateTime createdAt, String ott, String recoveryToken, DateTime recoveryTime) {
		this.product.setUsername(username);
		this.product.setPassword(password);
		this.product.setTempPassword(tempPassword);
		this.product.setSecretQuestion(secretQuestion);
		this.product.setSecretAnswer(secretAnswer);
		this.product.setLastLogin(lastLogin);
		this.product.setLastLogout(lastLogout);
		this.product.setCreatedAt(createdAt);
		this.product.setOneTimeToken(ott);
		this.product.setRecoveryToken(recoveryToken);
		this.product.setRecoveryTime(recoveryTime);
		return this;
	}
	
	public UserBuilder userDetails(String systemId, String sex, String status, String streetAddress, String primaryNumber, 
			String secondaryNumber, String primaryEmail, String secondaryEmail, String birthday, String photoBase64) {
		this.product.setSystemId(systemId);
		this.product.setSex(sex);
		this.product.setStatus(status);
		this.product.setStreetAddress(streetAddress);
		this.product.setPrimaryNumber(primaryNumber);
		this.product.setSecondaryNumber(secondaryNumber);
		this.product.setBirthday(birthday);
		this.product.setPrimaryEmail(primaryEmail);
		this.product.setSecondaryEmail(secondaryEmail);
		this.product.setSecondaryNumber(secondaryNumber);
		this.product.setPhotoBase64(photoBase64);
		return this;
	}
	
	public UserBuilder roleWithUsers(Role role, User... userRoles) {
		this.product.getRoles().add(role);
		for (User user : userRoles) {
			user.getRoles().add(role);
		}
		return this;
	}

	@Override
	User assembleProduct() {
		return this.product;
	}

}
