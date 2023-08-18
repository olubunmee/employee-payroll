package com.interswitch.ng.employeepayroll.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@AllArgsConstructor
public class CreateOrUpdateSalaryRateDto {
    private Integer employeeCategoryId;
    private Integer level;
    private BigDecimal amount;
}
