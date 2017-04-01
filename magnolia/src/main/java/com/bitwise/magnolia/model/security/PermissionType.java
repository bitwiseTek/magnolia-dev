package com.bitwise.magnolia.model.security;
/**
 *  
 * @author Sika Kay
 * @date 31/03/17
 *
 */
public enum PermissionType {

	EDITPROFILE("PERMISSION_EDIT_PROFILE"),
	EDITCOURSES("PERMISSION_EDIT_COURSES"),
	ADDCOURSES("PERMISSION_ADD_COURSES"),
	ATTACHCOURSES("PERMISSION_ATTACH_COURSES"),
	EDITUSERS("PERMISSION_EDIT_USERS"),
	GENERATERESULT("PERMISSION_GENERATE_RESULT"),
	EDITRESULT("PERMISSION_EDIT_RESULT"),
	EDITACCOMODATION("PERMISSION_EDIT_ACCOMMODATION"),
	EDITSTUDENT("PERMISSION_EDIT_STUDENT"),
	EDITSTAFF("PERMISSION_EDIT_STAFF");
	
	String permissionType;
	
	private PermissionType(String permissionType){
		this.permissionType = permissionType;
	}
	
	public String getPermissionType(){
		return permissionType;
	}
}
