package com.apram.employeemanagementapi.dto;


import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {


    private Long id;


    @NotBlank(message = "First name is required")
    private String firstName;


    @NotBlank(message = "Last name is required")
    private String lastName;


    @Email(message = "Invalid email")
    @NotBlank(message = "Email is required")
    private String email;


    @NotBlank(message = "Phone is required")
    private String phone;


    @NotBlank(message = "Department is required")
    private String department;


    @NotBlank(message = "Designation is required")
    private String designation;


    @NotNull(message = "Salary is required")
    @Positive(message = "Salary must be positive")
    private Double salary;


    @NotNull(message = "Hire date is required")
    private LocalDate hireDate;


    @NotBlank(message = "Status is required")
    private String status;

}