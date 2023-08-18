package com.interswitch.ng.employeepayroll.service;

import com.interswitch.ng.employeepayroll.data.model.Employee;
import com.interswitch.ng.employeepayroll.data.repository.EmployeeRepository;
import com.interswitch.ng.employeepayroll.dto.CreateOrUpdateEmployeeDto;
import com.interswitch.ng.employeepayroll.dto.EmployeeDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public EmployeeDto createEmployee(CreateOrUpdateEmployeeDto categoryDto) throws ParseException {
        Employee employee = new Employee();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dateOfBirth = sdf.parse(categoryDto.getDateOfBirth());
        Date dateJoined = sdf.parse(categoryDto.getJoinedDate());
        employee.setName(categoryDto.getName());
        employee.setPhone(categoryDto.getPhone());
        employee.setDateOfBirth(dateOfBirth);
        employee.setJoinedDate(dateJoined);
        employee.setAddress(categoryDto.getAddress());
        employee.setEmployeeCategoryId(categoryDto.getEmployeeCategoryId());
        employee.setDepartmentId(categoryDto.getDepartmentId());
        employeeRepository.save(employee);
        return EmployeeDto.builder()
                .name(employee.getName())
                .phone(employee.getPhone())
                .joinedDate(employee.getJoinedDate())
                .departmentId(employee.getDepartmentId())
                .employeeCategoryId(employee.getEmployeeCategoryId())
                .build();
    }

    @Override
    public EmployeeDto updateEmployee(Integer id, CreateOrUpdateEmployeeDto categoryDto) throws ParseException {
        var foundEmployee = employeeRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Employee not found")
        );
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dateOfBirth = sdf.parse(categoryDto.getDateOfBirth());
        Date dateJoined = sdf.parse(categoryDto.getJoinedDate());
        foundEmployee.setName(categoryDto.getName());
        foundEmployee.setPhone(categoryDto.getPhone());
        foundEmployee.setDateOfBirth(dateOfBirth);
        foundEmployee.setJoinedDate(dateJoined);
        foundEmployee.setAddress(categoryDto.getAddress());
        foundEmployee.setEmployeeCategoryId(categoryDto.getEmployeeCategoryId());
        foundEmployee.setDepartmentId(categoryDto.getDepartmentId());
        employeeRepository.save(foundEmployee);
        return EmployeeDto.builder()
                .name(foundEmployee.getName())
                .phone(foundEmployee.getPhone())
                .joinedDate(foundEmployee.getJoinedDate())
                .departmentId(foundEmployee.getDepartmentId())
                .employeeCategoryId(foundEmployee.getEmployeeCategoryId())
                .build();
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> listOfEmployees = employeeRepository.findAll();
        return listOfEmployees.stream()
                .map(employee -> EmployeeDto.builder()
                        .name(employee.getName()).phone(employee.getPhone())
                        .joinedDate(employee.getJoinedDate()).departmentId(employee.getDepartmentId())
                        .employeeCategoryId(employee.getEmployeeCategoryId())
                        .build()).toList();
    }

    @Override
    public EmployeeDto getEmployee(Integer id) {
        var employee = employeeRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Employee not found")
        );
        return EmployeeDto.builder()
                .name(employee.getName())
                .phone(employee.getPhone())
                .joinedDate(employee.getJoinedDate()).departmentId(employee.getDepartmentId())
                .employeeCategoryId(employee.getEmployeeCategoryId()).dateOfBirth(employee.getDateOfBirth())
                .address(employee.getAddress())
                .build();
    }
}
