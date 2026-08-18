package com.vishal.student_management_system.service;


import com.vishal.student_management_system.exception.StudentNotFoundException;
import com.vishal.student_management_system.repository.StudentRepository;
import com.vishal.student_management_system.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    // Constructor Injection
    public StudentService(StudentRepository sr){
        this.studentRepository = sr;
    }


    public Student addStudent(Student s){

        boolean studentexist = studentRepository.existsByEmail(s.getEmail());

        if(studentexist){
            throw new RuntimeException("Student already exists");
        }
        studentRepository.save(s);
        return s;


    }

    public List<Student> getStudents(){
        return studentRepository.findAll();

    }

    public Student getStudentById(int id){
        if(id<=0){
            throw new IllegalArgumentException("Student ID should be greater than 0 ");
        }
        return studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException("Student Not Found"));

    }
    public Student updateStudentById(int id, Student s){
        Student existingstudent =  studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException("Student Not Foumd At ID : " + id));

        existingstudent.setName(s.getName());
        existingstudent.setAge(s.getAge());
        existingstudent.setCgpa(s.getCgpa());
        existingstudent.setEmail(s.getEmail());
        existingstudent.setDepartment(s.getDepartment());
        existingstudent.setPhone(s.getPhone());

        return studentRepository.save(existingstudent);

    }
    public void deleteStudentById(int id){

        if(id<=0){
            throw new IllegalArgumentException("Invalid Student ID ");
        }

        if(!studentRepository.existsById(id)){
            throw new StudentNotFoundException("Student Not Found At ID : " + id);
        }

         studentRepository.deleteById(id);

    }



}
