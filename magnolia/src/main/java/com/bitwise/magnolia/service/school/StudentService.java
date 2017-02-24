package com.bitwise.magnolia.service.school;
/**
 *  
 * @author Sika Kay
 * @date 24/02/17
 */
import com.bitwise.magnolia.common.Response;
import com.bitwise.magnolia.vo.school.StudentVo;

public interface StudentService {

	Response validateStudent(StudentVo studentVo);

}
