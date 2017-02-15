package com.bitwise.magnolia.service.school;

import com.bitwise.magnolia.dao.common.Response;
import com.bitwise.magnolia.vo.school.StudentVo;

public interface StudentService {

	Response validateStudent(StudentVo studentVo);

}
