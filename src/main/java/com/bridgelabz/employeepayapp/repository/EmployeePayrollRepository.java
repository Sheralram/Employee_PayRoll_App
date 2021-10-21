package com.bridgelabz.employeepayapp.repository;

import com.bridgelabz.employeepayapp.model.EmployeePayRollData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeePayrollRepository extends JpaRepository<EmployeePayRollData,Integer> {
}
