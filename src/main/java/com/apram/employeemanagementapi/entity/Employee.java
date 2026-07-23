package com.apram.employeemanagementapi.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDate;



@Entity
@Table(name = "employees")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @Column(nullable = false)
    private String firstName;



    @Column(nullable = false)
    private String lastName;



    @Column(nullable = false, unique = true)
    private String email;



    private String phone;



    private String department;



    private String designation;



    private Double salary;



    private LocalDate hireDate;



    private String status;

}