package com.bridgelabz.employeepayapp.controller;

import com.bridgelabz.employeepayapp.dto.EmployeeDto;
import com.bridgelabz.employeepayapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
public class EmployeeController {

    @GetMapping(value="/")
    public String test1(@RequestBody String message){
    return "message:" + message;
    }

    @GetMapping("/get")
    public ResponseEntity<String> getEmployeePayrollData(){
        return new ResponseEntity<String>("Get Call Success", HttpStatus.OK);
    }

    @GetMapping("/get/{empId}")
    public ResponseEntity<String> getEmployeePayrollData(@PathVariable(value="empId") int empId){
        return  new ResponseEntity<>("Get Call Success For Id " +empId, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<String> addEmployeePayrollData(@RequestBody EmployeeDto employeePayrollDto){
        return new ResponseEntity<String>("Created Employee Payroll Data For "+employeePayrollDto, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateEmployeePayroll(@RequestBody EmployeeDto employeePayrollDto){
        return new ResponseEntity<String>("Update Employee Payroll Data For "+employeePayrollDto, HttpStatus.OK );
    }

    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<String> deleteEmployeePayroll(@PathVariable(value="empId") int empId){
        return new ResponseEntity<String>("Delete Call Success For Id "+empId, HttpStatus.OK);
    }


}



