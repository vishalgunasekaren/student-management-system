package com.vishal.student_management_system.repository;


import com.vishal.student_management_system.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

    boolean courseexist(String code);

}

