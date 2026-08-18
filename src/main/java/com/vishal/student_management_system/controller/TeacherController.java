package com.vishal.student_management_system.controller;

import com.vishal.student_management_system.entity.Teacher;
import com.vishal.student_management_system.service.TeacherService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService){
        this.teacherService = teacherService;
    }

    @PostMapping
    public void addTeacher(@RequestBody Teacher t){

    }

    @GetMapping
    public void getTeacher(){

    }

    @GetMapping("/{id}")
    public void getTeacherById(@PathVariable int id){

    }

    @DeleteMapping
    public void deleteById(@PathVariable int id){

    }

    @PutMapping
    public void updateById(@RequestBody Teacher t, @PathVariable int id){

    }
}
