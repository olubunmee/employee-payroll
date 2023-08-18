package com.interswitch.ng.employeepayroll.service;

import com.interswitch.ng.employeepayroll.data.model.Department;
import com.interswitch.ng.employeepayroll.data.repository.DepartmentRepository;
import com.interswitch.ng.employeepayroll.dto.CreateOrUpdateDepartmentDto;
import com.interswitch.ng.employeepayroll.dto.DepartmentDto;
import com.interswitch.ng.employeepayroll.dto.EmployeeDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService{
    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public DepartmentDto createDepartment(CreateOrUpdateDepartmentDto createOrUpdateDepartment) {
        if (departmentRepository.existsByName(createOrUpdateDepartment.getName()))
            throw new RuntimeException("Department already exists");
        Department department = new Department();
        department.setName(createOrUpdateDepartment.getName());
        department.setDescription(createOrUpdateDepartment.getDescription());
        departmentRepository.save(department);
        return DepartmentDto.builder()
                .name(department.getName())
                .description(department.getDescription())
                .build();
    }

    @Override
    public DepartmentDto updateDepartment(Integer id, CreateOrUpdateDepartmentDto createOrUpdateDepartmentDto) {
        Department foundDepartment = departmentRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("Department not found")
        );
        foundDepartment.setName(createOrUpdateDepartmentDto.getName());
        foundDepartment.setDescription(createOrUpdateDepartmentDto.getDescription());
        departmentRepository.save(foundDepartment);
        return DepartmentDto.builder()
                .name(foundDepartment.getName())
                .description(foundDepartment.getDescription())
                .build();
    }

    @Override
    public List<DepartmentDto> getAllDepartments() {
        List<Department> listOfDepartments = departmentRepository.findAll();
        return listOfDepartments.stream()
                .map(departmentDto -> new DepartmentDto(
                        departmentDto.getName(),
                        departmentDto.getDescription()
                )).toList();
    }

    @Override
    public DepartmentDto getDepartment(Integer id) {
        Department department = departmentRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("Department not found")
        );
        return new DepartmentDto(department.getName(), department.getDescription());
    }

    @Override
    public EmployeeDto getEmployeesInDepartment(Integer id) {
        return null;
    }
}
