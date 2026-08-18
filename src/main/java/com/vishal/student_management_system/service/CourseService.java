package com.vishal.student_management_system.service;

import com.vishal.student_management_system.entity.Course;
import com.vishal.student_management_system.exception.CourseNotFoundException;
import com.vishal.student_management_system.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }

    public Course addCourse(Course c){
        boolean courseexist = courseRepository.courseexist(c.getCode());

        if(courseexist){
            throw new IllegalArgumentException("Course is already exists with this code");
        }
        courseRepository.save(c);
        return c;

    }

    public List<Course> getAllCourse(){

        return courseRepository.findAll();
    }


    public Course getById(int id){
        if(id<=0){
            throw new IllegalArgumentException("ID Should be Atleast greaterthan 0");
        }
        return courseRepository.findById(id).orElseThrow(() -> new CourseNotFoundException("Course Not Found"));
    }

    public void deleteById(int id){

        if(id<=0){
            throw new IllegalArgumentException("ID should be atleast greaterthan 0");
        }

        if(!courseRepository.existsById(id)){
            throw new CourseNotFoundException("Course Not Found in ID : " + id);
        }
        courseRepository.deleteById(id);
    }

    public Course updateById(Course c, int id){

        if(id<=0){
            throw new IllegalArgumentException("ID should be atleast greaterthan 0");
        }

        Course existingCourse = courseRepository.findById(id).orElseThrow(() -> new CourseNotFoundException("Course Not Found in ID : " + id));
        existingCourse.setName(c.getName());
        existingCourse.setCode(c.getCode());
        existingCourse.setDuration(c.getDuration());

        return courseRepository.save(existingCourse);


    }

}
