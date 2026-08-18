package com.vishal.student_management_system.repository;

import com.vishal.student_management_system.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Integer> {
}
