package com.interswitch.ng.employeepayroll.dto;

import lombok.*;

import java.util.Date;

@Setter
@Getter
@Builder
@AllArgsConstructor
public class EmployeeDto {
    private String name;
    private String phone;
    private String address;
    private Date dateOfBirth;
    private Date joinedDate;
    private Integer departmentId;
    private Integer employeeCategoryId;

    public EmployeeDto(String name, String phone, Date joinedDate, Integer departmentId, Integer employeeCategoryId, Date dateOfBirth, String address) {

    }
}
