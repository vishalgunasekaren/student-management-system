package com.vishal.student_management_system.service;
import com.vishal.student_management_system.dto.StudentRequest;
import com.vishal.student_management_system.dto.StudentResponse;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.stereotype.Service;
import com.vishal.student_management_system.entity.Student;
import com.vishal.student_management_system.exception.DuplicateResourceException;
import com.vishal.student_management_system.repository.StudentRepository;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService{

    private final StudentRepository studentRepository;

    @Override
    public StudentResponse createStudent(@NonNull StudentRequest request) {
        if (studentRepository.existsByEmail(request.getEmail())) {
            throw new DuplicateResourceException("A student with email " + request.getEmail() + " already exists");
        }

        Student student = Student.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .phoneNumber(request.getPhoneNumber())
                .dateOfBirth(request.getDateOfBirth())
                .course(request.getCourse())
                .enrollmentDate(request.getEnrollmentDate() != null ? request.getEnrollmentDate() : LocalDate.now())
                .build();

        return toResponse(studentRepository.save(student));
    }


    private StudentResponse toResponse(Student s) {
        return StudentResponse.builder()
                .id(s.getId())
                .firstName(s.getFirstName())
                .lastName(s.getLastName())
                .email(s.getEmail())
                .phoneNumber(s.getPhoneNumber())
                .dateOfBirth(s.getDateOfBirth())
                .course(s.getCourse())
                .enrollmentDate(s.getEnrollmentDate())
                .build();
    }

}



