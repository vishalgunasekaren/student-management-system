package com.vishal.student_management_system.controller;

import com.vishal.student_management_system.service.StudentService;
import com.vishal.student_management_system.entity.Student;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

   private final StudentService studentService;

// Constructor Injection
   public StudentController(StudentService service){
       this.studentService = service;
   }


// Methods
   @PostMapping()
    public Student addStudent( @Valid @RequestBody Student s){
       return studentService.addStudent(s);

   }

   @GetMapping()
    public List<Student> getALlStudents(){
       return studentService.getStudents();

   }

   @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id){
       return studentService.getStudentById(id);

   }

   @PutMapping("/{id}")
    public Student updateStudentById(@PathVariable int id, @Valid @RequestBody Student s){

       return studentService.updateStudentById(id, s);

   }

   @DeleteMapping("/{id}")
    public String deleteById(@PathVariable int id){
       studentService.deleteStudentById(id);

       return "Student Deleted Successfully";

   }







}
