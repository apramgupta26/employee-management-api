package com.apram.employeemanagementapi.config;


import com.apram.employeemanagementapi.dto.EmployeeDTO;
import com.apram.employeemanagementapi.entity.Employee;


public class EmployeeMapper {


    // Entity -> DTO
    public static EmployeeDTO toDTO(Employee employee) {

        EmployeeDTO dto = new EmployeeDTO();

        dto.setId(employee.getId());
        dto.setFirstName(employee.getFirstName());
        dto.setLastName(employee.getLastName());
        dto.setEmail(employee.getEmail());
        dto.setPhone(employee.getPhone());
        dto.setDepartment(employee.getDepartment());
        dto.setDesignation(employee.getDesignation());
        dto.setSalary(employee.getSalary());
        dto.setHireDate(employee.getHireDate());
        dto.setStatus(employee.getStatus());

        return dto;
    }



    // DTO -> Entity
    public static Employee toEntity(EmployeeDTO dto) {

        Employee employee = new Employee();

        employee.setFirstName(dto.getFirstName());
        employee.setLastName(dto.getLastName());
        employee.setEmail(dto.getEmail());
        employee.setPhone(dto.getPhone());
        employee.setDepartment(dto.getDepartment());
        employee.setDesignation(dto.getDesignation());
        employee.setSalary(dto.getSalary());
        employee.setHireDate(dto.getHireDate());
        employee.setStatus(dto.getStatus());

        return employee;
    }

}