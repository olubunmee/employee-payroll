package com.interswitch.ng.employeepayroll.controller;

import com.interswitch.ng.employeepayroll.dto.CreateOrUpdateSalaryRateDto;
import com.interswitch.ng.employeepayroll.service.SalaryRateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("api/salary-rates")
public class SalaryRateController {
    private final SalaryRateService service;
    public SalaryRateController(SalaryRateService service){
        this.service = service;
    }

    @PostMapping("/create-salary-rate")
    public ResponseEntity<?> createSalaryRate(@RequestBody CreateOrUpdateSalaryRateDto salaryRateDto) throws ParseException {
        return ResponseEntity.ok(service.createSalaryRate(salaryRateDto));
    }

    @PutMapping("/update-salary-rate/{id}")
    public ResponseEntity<?> updateSalaryRate(@PathVariable Integer id, @RequestBody CreateOrUpdateSalaryRateDto salaryRateDto) throws ParseException {
        return ResponseEntity.ok(service.updateSalaryRate(id, salaryRateDto));
    }

    @GetMapping("/all-salary-rates")
    public ResponseEntity<?> getAllSalaryRates() {
        return ResponseEntity.ok(service.getAllSalaryRates());
    }

    @GetMapping("/salary-rate/{id}")
    public ResponseEntity<?> getAllSalaryRates(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getSalaryRate(id));
    }

}
