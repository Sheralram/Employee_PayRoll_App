package com.bridgelabz.employeepayapp.dto;

import lombok.Data;

import javax.persistence.Id;

@Data
public class EmployeeDto {
    @Id
    private String name;
    private int salary;

}

