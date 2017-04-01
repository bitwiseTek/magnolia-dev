package com.bitwise.magnolia.util.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.bitwise.magnolia.model.staff.StaffCourse;
import com.bitwise.magnolia.service.staff.StaffCourseService;

@Component
public class StaffToSubjectConverter implements Converter<Object, StaffCourse> {

	@Autowired
	private StaffCourseService staffService;
	
	@Override
	public StaffCourse convert(Object element) {
		Long id = Long.parseLong((String)element);
		StaffCourse staff = staffService.findById(id);
		System.out.println("Staff: " +staff);
		return staff;
	}

}
