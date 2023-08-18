package com.interswitch.ng.employeepayroll.controller;

import com.interswitch.ng.employeepayroll.dto.CreateOrUpdateCategoryDto;
import com.interswitch.ng.employeepayroll.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employeeCategories")
public class EmployeeCategoryController {
    private final CategoryService categoryService;

    public EmployeeCategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/create-category")
    public ResponseEntity<?> createCategory(@RequestBody CreateOrUpdateCategoryDto categoryDto){
        var result = categoryService.createEmployeeCategory(categoryDto);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/update-category/{id}")
    public ResponseEntity<?> updateCategory(@PathVariable Integer id, @RequestBody CreateOrUpdateCategoryDto categoryDto){
        var result = categoryService.updateEmployeeCategory(id, categoryDto);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/all-categories")
    public ResponseEntity<?> getAllCategories(){
        var result = categoryService.getAllEmployeeCategories();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<?> getCategory(@PathVariable Integer id){
        var result = categoryService.getEmployeeCategory(id);
        return ResponseEntity.ok(result);
    }
}
