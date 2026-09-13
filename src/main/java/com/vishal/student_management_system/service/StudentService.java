package com.vishal.student_management_system.service;
import com.vishal.student_management_system.controller.StudentController;
import com.vishal.student_management_system.dto.StudentRequest;
import com.vishal.student_management_system.dto.StudentResponse;

import java.util.List;


public interface StudentService {
    StudentResponse createStudent(StudentRequest request);
    StudentResponse getStudent(long id);
    List<StudentResponse> getAllStudent();
    StudentResponse updateStudent(long id, StudentRequest request);
    StudentResponse deleteStudent(long id);

}
