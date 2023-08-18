package com.interswitch.ng.employeepayroll.service;

import com.interswitch.ng.employeepayroll.data.model.SalaryRate;
import com.interswitch.ng.employeepayroll.data.repository.SalaryRateRepository;
import com.interswitch.ng.employeepayroll.dto.CreateOrUpdateSalaryRateDto;
import com.interswitch.ng.employeepayroll.dto.SalaryRateDto;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

@Service
public class SalaryRateServiceImpl implements SalaryRateService{
    private final SalaryRateRepository salaryRateRepository;

    public SalaryRateServiceImpl(SalaryRateRepository salaryRateRepository) {
        this.salaryRateRepository = salaryRateRepository;
    }

    @Override
    public SalaryRateDto createSalaryRate(CreateOrUpdateSalaryRateDto createOrUpdateSalaryRateDto) throws ParseException {
        SalaryRate salaryRate = new SalaryRate();
        salaryRate.setLevel(createOrUpdateSalaryRateDto.getLevel());
        salaryRate.setAmount(createOrUpdateSalaryRateDto.getAmount());
        salaryRate.setEmployeeCategoryId(createOrUpdateSalaryRateDto.getEmployeeCategoryId());
        salaryRateRepository.save(salaryRate);
        return new SalaryRateDto(
                salaryRate.getEmployeeCategoryId(),
                salaryRate.getLevel(),
                salaryRate.getAmount()
        );
    }

    @Override
    public SalaryRateDto updateSalaryRate(Integer id, CreateOrUpdateSalaryRateDto createOrUpdateSalaryRateDto) throws ParseException {
        var foundSalaryRate = salaryRateRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("Salary rate not found")
        );
        foundSalaryRate.setEmployeeCategoryId(createOrUpdateSalaryRateDto.getEmployeeCategoryId());
        foundSalaryRate.setLevel(createOrUpdateSalaryRateDto.getLevel());
        foundSalaryRate.setAmount(createOrUpdateSalaryRateDto.getAmount());
        salaryRateRepository.save(foundSalaryRate);
        return new SalaryRateDto(
                foundSalaryRate.getEmployeeCategoryId(),
                foundSalaryRate.getLevel(),
                foundSalaryRate.getAmount()
        );
    }

    @Override
    public List<SalaryRateDto> getAllSalaryRates() {
        List<SalaryRate> salaryRateList = salaryRateRepository.findAll();
        return salaryRateList.stream()
                .map(salaryRate -> new SalaryRateDto(
                        salaryRate.getEmployeeCategoryId(),
                        salaryRate.getLevel(),
                        salaryRate.getAmount()
                ))
                .toList();
    }

    @Override
    public SalaryRateDto getSalaryRate(Integer id) {
        SalaryRate salaryRate = salaryRateRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("Salary rate not found")
        );
        return new SalaryRateDto(
                salaryRate.getEmployeeCategoryId(),
                salaryRate.getLevel(),
                salaryRate.getAmount()
        );
    }
}
