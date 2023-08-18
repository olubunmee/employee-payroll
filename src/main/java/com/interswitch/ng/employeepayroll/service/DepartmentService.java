package com.interswitch.ng.employeepayroll.service;

import com.interswitch.ng.employeepayroll.dto.CreateOrUpdateDepartmentDto;
import com.interswitch.ng.employeepayroll.dto.DepartmentDto;
import com.interswitch.ng.employeepayroll.dto.EmployeeDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DepartmentService {
    DepartmentDto createDepartment(CreateOrUpdateDepartmentDto createOrUpdateDepartment);
    DepartmentDto updateDepartment(Integer id, CreateOrUpdateDepartmentDto createOrUpdateDepartmentDto);
    List<DepartmentDto> getAllDepartments();
    DepartmentDto getDepartment(Integer id);
    EmployeeDto getEmployeesInDepartment(Integer id);
}
