package com.apram.employeemanagementapi.controller;


import com.apram.employeemanagementapi.dto.EmployeeDTO;
import com.apram.employeemanagementapi.service.EmployeeService;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;


import jakarta.validation.Valid;


import lombok.RequiredArgsConstructor;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import org.springframework.web.bind.annotation.*;


import java.util.List;



@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
@Tag(
        name = "Employee Management API",
        description = "Operations related to employee management"
)
public class EmployeeController {



    private final EmployeeService employeeService;



    // GET ALL EMPLOYEES

    @GetMapping
    @Operation(
            summary = "Get all employees",
            description = "Fetch all employees from database"
    )
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees(){


        return ResponseEntity.ok(
                employeeService.getAllEmployees()
        );
    }





    // GET EMPLOYEE BY ID

    @GetMapping("/{id}")
    @Operation(
            summary = "Get employee by ID",
            description = "Fetch employee details using employee id"
    )
    public ResponseEntity<EmployeeDTO> getEmployeeById(
            @PathVariable Long id
    ){


        return ResponseEntity.ok(
                employeeService.getEmployeeById(id)
        );
    }





    // CREATE EMPLOYEE

    @PostMapping
    @Operation(
            summary = "Create employee",
            description = "Create a new employee record"
    )
    public ResponseEntity<EmployeeDTO> createEmployee(
            @Valid @RequestBody EmployeeDTO employeeDTO
    ){


        EmployeeDTO savedEmployee =
                employeeService.createEmployee(employeeDTO);


        return new ResponseEntity<>(
                savedEmployee,
                HttpStatus.CREATED
        );
    }





    // UPDATE EMPLOYEE

    @PutMapping("/{id}")
    @Operation(
            summary = "Update employee",
            description = "Update existing employee details"
    )
    public ResponseEntity<EmployeeDTO> updateEmployee(
            @PathVariable Long id,
            @Valid @RequestBody EmployeeDTO employeeDTO
    ){


        return ResponseEntity.ok(
                employeeService.updateEmployee(
                        id,
                        employeeDTO
                )
        );
    }





    // DELETE EMPLOYEE

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Delete employee",
            description = "Delete employee using employee id"
    )
    public ResponseEntity<String> deleteEmployee(
            @PathVariable Long id
    ){


        employeeService.deleteEmployee(id);


        return ResponseEntity.ok(
                "Employee deleted successfully"
        );
    }

}