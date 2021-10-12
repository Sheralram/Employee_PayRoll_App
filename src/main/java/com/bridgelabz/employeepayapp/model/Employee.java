package com.bridgelabz.employeepayapp.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Employee {
@Id
    private int id;
    private String name;
    private int salary;
}
