package com.interswitch.ng.employeepayroll.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class CreateOrUpdateCategoryDto {
    private String name;
    private String description;
}
