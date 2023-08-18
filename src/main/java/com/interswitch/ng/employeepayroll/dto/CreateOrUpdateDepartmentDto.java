package com.interswitch.ng.employeepayroll.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class CreateOrUpdateDepartmentDto {
    private String name;
    private String description;
}
