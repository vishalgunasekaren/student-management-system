package com.vishal.student_management_system.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Normalized;

import javax.management.remote.JMXServerErrorException;

@Entity
@Getter
@Setter
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Teacher name required")
    @Column(nullable = false)
    private String name;

    @Email
    @NotBlank
    @Column(nullable = false, unique = true)
    @Max(100)
    private String email;

    @NotBlank
    @Pattern(regexp = "^[0-9]{10}$", message = "phone number must contain exactly 10 digits")
    @Max(10)
    private String phone;

    @NotBlank
    @Column(nullable = false)
    private String department;

}
