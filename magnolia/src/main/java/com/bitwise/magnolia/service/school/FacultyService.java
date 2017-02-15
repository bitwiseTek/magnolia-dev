package com.bitwise.magnolia.service.school;

import com.bitwise.magnolia.dao.common.Response;

public interface FacultyService {

	/**
	 * Gets all active faculties
	 * @see #Response
	 * @param schoolAlias
	 * @return
	 */
	public Response getActiveFaculties(String schoolAlias);
	
}
