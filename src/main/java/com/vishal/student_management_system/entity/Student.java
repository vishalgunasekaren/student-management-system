package com.vishal.student_management_system.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.Length;

import java.time.LocalDate;

@Getter
@Setter
@Table(name = "students")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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


