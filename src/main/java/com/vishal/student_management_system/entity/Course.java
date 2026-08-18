package com.vishal.student_management_system.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @NotBlank(message = "Course Code is Required")
    @Column(nullable = false, unique = true)
    private String code;

    @NotBlank(message = "Name is Reqired ")
    @Size(min = 2, max = 100)
    @Column(nullable = false)
    private String name;


    private int duration;
}
