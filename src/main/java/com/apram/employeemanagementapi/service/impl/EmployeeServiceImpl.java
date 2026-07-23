package com.apram.employeemanagementapi.service.impl;


import com.apram.employeemanagementapi.config.EmployeeMapper;
import com.apram.employeemanagementapi.dto.EmployeeDTO;
import com.apram.employeemanagementapi.entity.Employee;
import com.apram.employeemanagementapi.exception.ResourceNotFoundException;
import com.apram.employeemanagementapi.repository.EmployeeRepository;
import com.apram.employeemanagementapi.service.EmployeeService;

import lombok.RequiredArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {


    private final EmployeeRepository employeeRepository;


    private static final Logger logger =
            LoggerFactory.getLogger(EmployeeServiceImpl.class);



    // GET ALL EMPLOYEES
    @Override
    public List<EmployeeDTO> getAllEmployees() {

        logger.info("Fetching all employees");


        List<EmployeeDTO> employees =
                employeeRepository.findAll()
                        .stream()
                        .map(EmployeeMapper::toDTO)
                        .toList();


        logger.info("Total employees found: {}", employees.size());


        return employees;
    }




    // GET EMPLOYEE BY ID
    @Override
    public EmployeeDTO getEmployeeById(Long id) {


        logger.info("Fetching employee with id: {}", id);


        Employee employee =
                employeeRepository.findById(id)
                        .orElseThrow(() -> {

                            logger.error(
                                    "Employee not found with id: {}",
                                    id
                            );

                            return new ResourceNotFoundException(
                                    "Employee not found with id: " + id
                            );
                        });


        return EmployeeMapper.toDTO(employee);
    }





    // CREATE EMPLOYEE
    @Override
    public EmployeeDTO createEmployee(EmployeeDTO dto) {


        logger.info(
                "Creating employee with email: {}",
                dto.getEmail()
        );


        Employee employee =
                EmployeeMapper.toEntity(dto);


        Employee savedEmployee =
                employeeRepository.save(employee);



        logger.info(
                "Employee created successfully with id: {}",
                savedEmployee.getId()
        );


        return EmployeeMapper.toDTO(savedEmployee);
    }






    // UPDATE EMPLOYEE
    @Override
    public EmployeeDTO updateEmployee(Long id, EmployeeDTO dto) {


        logger.info(
                "Updating employee with id: {}",
                id
        );


        Employee employee =
                employeeRepository.findById(id)
                        .orElseThrow(() -> {

                            logger.error(
                                    "Employee not found with id: {}",
                                    id
                            );

                            return new ResourceNotFoundException(
                                    "Employee not found with id: " + id
                            );
                        });



        employee.setFirstName(dto.getFirstName());

        employee.setLastName(dto.getLastName());

        employee.setEmail(dto.getEmail());

        employee.setPhone(dto.getPhone());

        employee.setDepartment(dto.getDepartment());

        employee.setDesignation(dto.getDesignation());

        employee.setSalary(dto.getSalary());

        employee.setHireDate(dto.getHireDate());

        employee.setStatus(dto.getStatus());



        Employee updatedEmployee =
                employeeRepository.save(employee);



        logger.info(
                "Employee updated successfully with id: {}",
                id
        );


        return EmployeeMapper.toDTO(updatedEmployee);
    }







    // DELETE EMPLOYEE
    @Override
    public void deleteEmployee(Long id) {


        logger.info(
                "Deleting employee with id: {}",
                id
        );


        Employee employee =
                employeeRepository.findById(id)
                        .orElseThrow(() -> {

                            logger.error(
                                    "Employee not found with id: {}",
                                    id
                            );

                            return new ResourceNotFoundException(
                                    "Employee not found with id: " + id
                            );
                        });



        employeeRepository.delete(employee);



        logger.info(
                "Employee deleted successfully with id: {}",
                id
        );

    }

}