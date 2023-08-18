package com.interswitch.ng.employeepayroll.service;

import com.interswitch.ng.employeepayroll.dto.CreateOrUpdateEmployeeDto;
import com.interswitch.ng.employeepayroll.dto.EmployeeDto;

import java.text.ParseException;
import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(CreateOrUpdateEmployeeDto categoryDto) throws ParseException;
    EmployeeDto updateEmployee(Integer id, CreateOrUpdateEmployeeDto categoryDto) throws ParseException;
    List<EmployeeDto> getAllEmployees();
    EmployeeDto getEmployee(Integer id);
}
