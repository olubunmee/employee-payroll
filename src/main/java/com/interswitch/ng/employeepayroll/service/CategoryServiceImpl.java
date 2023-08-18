package com.interswitch.ng.employeepayroll.service;

import com.interswitch.ng.employeepayroll.data.model.EmployeeCategory;
import com.interswitch.ng.employeepayroll.data.repository.EmployeeCategoryRepository;
import com.interswitch.ng.employeepayroll.dto.CreateOrUpdateCategoryDto;
import com.interswitch.ng.employeepayroll.dto.EmployeeCategoryDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

    private final EmployeeCategoryRepository employeeCategoryRepository;

    public CategoryServiceImpl(EmployeeCategoryRepository employeeCategoryRepository) {
        this.employeeCategoryRepository = employeeCategoryRepository;
    }

    @Override
    public EmployeeCategoryDto createEmployeeCategory(CreateOrUpdateCategoryDto categoryDto) {
        if (employeeCategoryRepository.existsByName(categoryDto.getName()))
            throw new RuntimeException("Employee category name exists");
        EmployeeCategory employeeCategory = new EmployeeCategory();
        employeeCategory.setDescription(categoryDto.getDescription());
        employeeCategory.setName(categoryDto.getName());
        employeeCategoryRepository.save(employeeCategory);
        return EmployeeCategoryDto.builder()
                .name(employeeCategory.getName())
                .description(employeeCategory.getDescription())
                .build();
    }

    @Override
    public EmployeeCategoryDto updateEmployeeCategory(Integer id, CreateOrUpdateCategoryDto categoryDto) {
        var findEmployeeCategory = employeeCategoryRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("Employee category not found")
        );
        findEmployeeCategory.setName(categoryDto.getName());
        findEmployeeCategory.setDescription(categoryDto.getDescription());
        employeeCategoryRepository.save(findEmployeeCategory);
        return EmployeeCategoryDto.builder()
                .name(findEmployeeCategory.getName())
                .description(findEmployeeCategory.getDescription())
                .build();
    }

    @Override
    public List <EmployeeCategoryDto> getAllEmployeeCategories() {
        List <EmployeeCategory> listOfEmployees = employeeCategoryRepository.findAll();
        return listOfEmployees.stream()
                .map(employeeCategoryDto -> new EmployeeCategoryDto(
                        employeeCategoryDto.getName(),
                        employeeCategoryDto.getDescription()
                )).toList();
    }

    @Override
    public EmployeeCategoryDto getEmployeeCategory(Integer id) {
        var employeecategory = employeeCategoryRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("Employee category not found")
        );
        return new EmployeeCategoryDto(employeecategory.getName(),
                employeecategory.getDescription());
    }


}
