package com.vishal.student_management_system.service;

import com.vishal.student_management_system.dto.StudentRequest;
import com.vishal.student_management_system.dto.StudentResponse;

import java.util.List;


public interface StudentService {
    StudentResponse createStudent(StudentRequest request);
    StudentResponse getStudentById(Long id);
    List<StudentResponse> getAllStudents();
    StudentResponse updateStudent(Long id, StudentRequest request);
    void deleteStudent(Long id);

}
