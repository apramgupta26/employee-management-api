package com.apram.employeemanagementapi.repository;

import com.apram.employeemanagementapi.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}