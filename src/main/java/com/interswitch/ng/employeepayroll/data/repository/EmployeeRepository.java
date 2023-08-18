package com.interswitch.ng.employeepayroll.data.repository;

import com.interswitch.ng.employeepayroll.data.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    boolean existsById(Employee employee);
}
