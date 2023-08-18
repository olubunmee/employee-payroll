package com.interswitch.ng.employeepayroll.controller;

import com.interswitch.ng.employeepayroll.dto.CreateOrUpdateDepartmentDto;
import com.interswitch.ng.employeepayroll.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping()
    public ResponseEntity<?> createDepartment(@RequestBody CreateOrUpdateDepartmentDto createOrUpdateDepartmentDto){
        var result = departmentService.createDepartment(createOrUpdateDepartmentDto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateDepartment(@PathVariable Integer id, @RequestBody CreateOrUpdateDepartmentDto createOrUpdateDepartmentDto){
        var result = departmentService.updateDepartment(id, createOrUpdateDepartmentDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<?> getAllDepartments(){
        var result = departmentService.getAllDepartments();
        return new ResponseEntity<>(result, HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDepartment(@PathVariable Integer id){
        var result = departmentService.getDepartment(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{id}/employees")
    public ResponseEntity<?> getAllDepartmentEmployees(@PathVariable Integer id){
        var result = departmentService.getDepartment(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
