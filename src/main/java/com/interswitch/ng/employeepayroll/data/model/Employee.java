package com.interswitch.ng.employeepayroll.data.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Setter
@Getter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String name;
    private String phone;
    private String address;
    @Column(name = "DateOfBirth")
    private Date dateOfBirth;
    @Column(name = "JoinedDate")
    private Date joinedDate;
    private Integer departmentId;
    private Integer employeeCategoryId;
}
