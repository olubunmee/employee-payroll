package com.interswitch.ng.employeepayroll.controller;

import com.interswitch.ng.employeepayroll.dto.CreateOrUpdateEmployeeDto;
import com.interswitch.ng.employeepayroll.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("api/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/create-employee")
    public ResponseEntity<?> createEmployee(@RequestBody CreateOrUpdateEmployeeDto createOrUpdateEmployeeDto) throws ParseException {
        return ResponseEntity.ok(employeeService.createEmployee(createOrUpdateEmployeeDto));
    }

    @PutMapping("/update-employee-details/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable Integer id, @RequestBody CreateOrUpdateEmployeeDto createOrUpdateEmployeeDto) throws ParseException {
        return ResponseEntity.ok(employeeService.updateEmployee(id, createOrUpdateEmployeeDto));
    }

    @GetMapping("/all-employees")
    public ResponseEntity<?> getAllEmployees(){
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<?> getEmployee(@PathVariable Integer id){
        return ResponseEntity.ok(employeeService.getEmployee(id));
    }
}
