package com.bitwise.magnolia.model.security;
/**
 *  
 * @author Sika Kay
 * @date 31/03/17
 *
 */
public enum RoleType {

	USER("ROLE_USER"),
	STUDENT("ROLE_STUDENT"),
	STAFF("ROLE_STAFF"),
	LECTURER("ROLE_LECTURER"),
	MANAGER("ROLE_MANAGER"), 
	HOD("ROLE_HOD"), 
	DEAN("ROLE_DEAN"), 
	ACCOUNTANT("ROLE_ACCOUNTANT"),
	ADMIN("ROLE_ADMIN"), 
	SUPERADMIN("ROLE_SUPER_ADMIN");
	
	String roleType;
	
	private RoleType(String roleType){
		this.roleType = roleType;
	}
	
	public String getRoleType(){
		return roleType;
	}
}
