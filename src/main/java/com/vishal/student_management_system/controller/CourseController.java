package com.vishal.student_management_system.controller;

import com.vishal.student_management_system.entity.Course;
import com.vishal.student_management_system.service.CourseService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService){
        this.courseService = courseService;
    }
    @PostMapping
    public void addCourse(@Valid @RequestBody Course c){

    }

    @GetMapping
    public void getAllCouse(){

    }

    @GetMapping("/{id}")
    public void getById(@PathVariable int id){

    }

    @DeleteMapping
    public void deleteById(@PathVariable int id){

    }

    @PutMapping
    public void updateById(@Valid @RequestBody Course c, @PathVariable int id){

    }

}
