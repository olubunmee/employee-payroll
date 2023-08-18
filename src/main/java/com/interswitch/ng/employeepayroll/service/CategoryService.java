package com.interswitch.ng.employeepayroll.service;

import com.interswitch.ng.employeepayroll.dto.CreateOrUpdateCategoryDto;
import com.interswitch.ng.employeepayroll.dto.EmployeeCategoryDto;

import java.util.List;

public interface CategoryService {
    EmployeeCategoryDto createEmployeeCategory(CreateOrUpdateCategoryDto categoryDto);
    EmployeeCategoryDto updateEmployeeCategory(Integer id, CreateOrUpdateCategoryDto categoryDto);
    List<EmployeeCategoryDto> getAllEmployeeCategories();
    EmployeeCategoryDto getEmployeeCategory(Integer id);

}
