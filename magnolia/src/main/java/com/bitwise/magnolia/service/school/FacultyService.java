package com.bitwise.magnolia.service;

import com.bitwise.magnolia.common.Response;

public interface FacultyService {

	/**
	 * Gets all active faculties
	 * @see #Response
	 * @param schoolAlias
	 * @return
	 */
	public Response getActiveFaculties(String schoolAlias);
	
}
