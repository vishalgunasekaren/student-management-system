package com.vishal.student_management_system.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor //@AllArgsConstructor generates a constructor for every field(field mean like name, email,  id etc.:
@Builder

public class StudentRequest {
    @NotBlank(message = "FirstName is Required")
    @Column(nullable = false,length = 100)
    private String firstName;

    @NotBlank(message = "LastName is Required")
    @Column(nullable = false, length = 100)
    private String lastName;


    @NotBlank
    @Email
    @Column(nullable = false, unique = true)
    private String email;

    @NotBlank
    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number must contain exactly 10 digits")
    @Column(length = 10)
    private String phoneNumber;

    private LocalDate dateOfBirth;

    @Column(nullable = false, length = 100)
    private String course;

    @Column(nullable = false)
    private LocalDate enrollmentDate;


}
