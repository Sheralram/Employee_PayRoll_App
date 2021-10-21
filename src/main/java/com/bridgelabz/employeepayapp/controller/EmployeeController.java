package com.bridgelabz.employeepayapp.controller;

import com.bridgelabz.employeepayapp.dto.EmployeePayrollDto;
import com.bridgelabz.employeepayapp.dto.ResponseDto;
import com.bridgelabz.employeepayapp.model.EmployeePayRollData;
import com.bridgelabz.employeepayapp.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.validation.Valid;
import java.util.List;

/**
 * Performed Various HTTP Request(GET,PUT,POST,DELETE)
 *
 * @author ramkrishna sheral
 * @version 0.0.1
 * @since 10-10-2021
 */

@RestController
@Slf4j
@RequestMapping("/employeepayrollservice")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    /**
     * Function to perform Http Get request
     *
     * @return List of EmployeepayRoll data
     */

    @GetMapping("/get")
    public ResponseEntity<ResponseDto> getEmployeePayrollData(){
        List<EmployeePayRollData> employeePayRollData = null;
        employeePayRollData = employeeService.getEmployeePayrollData();
        ResponseDto responseDto = new ResponseDto("Get Call Success", employeePayRollData);
        log.info("got all the data of the employee");
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }
    /**
     * Function to perform Http Get request
     *
     * @param empId unique identifier to find employee
     * @return employee payroll data of unique identifier
     */

    @GetMapping("/get/{empId}")
    public ResponseEntity<ResponseDto> getEmployeePayrollData(@PathVariable(value="empId") int empId) {
        EmployeePayRollData employeePayRollData = null;
        employeePayRollData = employeeService.getEmployeePayRollById(empId);
        ResponseDto responseDto = new ResponseDto("Get Call Success For Id", employeePayRollData);
        log.info("Get Call Success For Id");
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }
    /**
     * Function to perform Http Post request
     *
     * @param employeePayrollDto employee payroll data in the form of json
     * @return add the employee payroll data
     */

    @PostMapping("/create")
        public ResponseEntity<ResponseDto> addEmployeePayrollData(@RequestBody EmployeePayrollDto employeePayrollDto){
        EmployeePayRollData employeePayRollData = null;
        employeePayRollData = employeeService.addEmployee(employeePayrollDto);
        ResponseDto responseDto = new ResponseDto("Created Employee Payroll Data For ", employeePayRollData);
        log.info("Created Employee Payroll Data");
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);

    }

    /**
     * Function to perform Http Put request
     *
     * @param empId              unique identifier of employee
     * @param employeePayrollDto payroll data of the employee
     * @return update employee payroll data by using unique id
     */

    @PutMapping("/update/{empId}")
    public ResponseEntity<ResponseDto> updateEmployeePayroll(@PathVariable(value = "empId") int empId, @Valid @RequestBody EmployeePayrollDto employeePayrollDto) {
        EmployeePayRollData employeePayRollData = null;
        employeePayRollData = employeeService.UpdateEmployeePayroll(empId, employeePayrollDto);
        ResponseDto responseDto = new ResponseDto("Update Employee Payroll Data For ", employeePayRollData);
        log.info("Update Employee Payroll Data");
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }
    /**
     * Function to perform Http Delete request
     *
     * @param empId unique identifier of employee
     * @return {@ResponseEntity} with message
     */

    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<ResponseDto> deleteEmployeePayroll(@PathVariable(value = "empId") int empId) {
        employeeService.deleteEmployeePayroll(empId);
        ResponseDto responseDto = new ResponseDto("Deleted Successfully", "deleted id: " + empId);
        log.info("Deleted Successfully");
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }


}



