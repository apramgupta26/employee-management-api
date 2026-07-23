package com.apram.employeemanagementapi.service;


import com.apram.employeemanagementapi.dto.EmployeeDTO;

import java.util.List;



public interface EmployeeService {


    // GET ALL EMPLOYEES
    List<EmployeeDTO> getAllEmployees();



    // GET EMPLOYEE BY ID
    EmployeeDTO getEmployeeById(Long id);



    // CREATE EMPLOYEE
    EmployeeDTO createEmployee(EmployeeDTO employeeDTO);



    // UPDATE EMPLOYEE
    EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDTO);



    // DELETE EMPLOYEE
    void deleteEmployee(Long id);

}