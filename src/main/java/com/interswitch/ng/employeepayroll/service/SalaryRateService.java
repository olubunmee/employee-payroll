package com.interswitch.ng.employeepayroll.service;

import com.interswitch.ng.employeepayroll.dto.CreateOrUpdateEmployeeDto;
import com.interswitch.ng.employeepayroll.dto.CreateOrUpdateSalaryRateDto;
import com.interswitch.ng.employeepayroll.dto.EmployeeDto;
import com.interswitch.ng.employeepayroll.dto.SalaryRateDto;

import java.text.ParseException;
import java.util.List;

public interface SalaryRateService {
    SalaryRateDto createSalaryRate(CreateOrUpdateSalaryRateDto createOrUpdateSalaryRateDto) throws ParseException;
    SalaryRateDto updateSalaryRate(Integer id, CreateOrUpdateSalaryRateDto createOrUpdateSalaryRateDto) throws ParseException;
    List<SalaryRateDto> getAllSalaryRates();
    SalaryRateDto getSalaryRate(Integer id);
}
