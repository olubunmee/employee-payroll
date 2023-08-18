package com.interswitch.ng.employeepayroll.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrUpdateEmployeeDto implements Serializable {
    private String name;
    private String phone;
    private String address;
    private String dateOfBirth;
    private String joinedDate;
    private Integer departmentId;
    private Integer employeeCategoryId;
}
