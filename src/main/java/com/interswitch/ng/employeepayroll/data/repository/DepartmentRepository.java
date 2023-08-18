package com.interswitch.ng.employeepayroll.data.repository;

import com.interswitch.ng.employeepayroll.data.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    boolean existsByName(String name);
}
