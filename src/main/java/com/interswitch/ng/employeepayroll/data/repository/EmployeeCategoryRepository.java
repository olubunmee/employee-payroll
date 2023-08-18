package com.interswitch.ng.employeepayroll.data.repository;

import com.interswitch.ng.employeepayroll.data.model.EmployeeCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeCategoryRepository extends JpaRepository<EmployeeCategory, Integer> {
    boolean existsByName(String name);
}
