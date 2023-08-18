package com.interswitch.ng.employeepayroll.data.repository;

import com.interswitch.ng.employeepayroll.data.model.SalaryRate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaryRateRepository extends JpaRepository<SalaryRate, Integer> {
}
