package com.bitwise.magnolia.service;

import com.bitwise.magnolia.common.Response;
import com.bitwise.magnolia.vo.StudentVo;

public interface StudentService {

	Response validateStudent(StudentVo studentVo);

}
