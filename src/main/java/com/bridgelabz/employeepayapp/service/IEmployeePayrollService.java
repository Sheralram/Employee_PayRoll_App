package com.bridgelabz.employeepayapp.service;

import com.bridgelabz.employeepayapp.dto.EmployeePayrollDto;
import com.bridgelabz.employeepayapp.model.EmployeePayRollData;

import java.util.List;
/**
 * interface to add business logic
 *
 * @author ramkrishna sheral
 * @version 0.0.1
 * @since 10-10-2021
 */
public interface IEmployeePayrollService {
    /**
     * method for getting all the employees from list
     *
     * @return list of Employees
     */
    List<EmployeePayRollData> getEmployeePayrollData();
    /**
     * method to get employee by unique identifier
     *
     * @param empId unique identifier for employee
     * @return employee by unique identifier
     */

    EmployeePayRollData getEmployeePayRollById(int empId);

    /**
     * method to add employee payroll data
     *
     * @param employeePayrollDto employee payroll data as json as input
     * @return employee payroll data will get added
     */


    EmployeePayRollData addEmployee(EmployeePayrollDto employeePayrollDto);
    /**
     * method to update already existing data
     *
     * @param empId              unique identifier for employee
     * @param employeePayrollDto employee payroll data for updation
     * @return employee payroll data will get updated based upon unique identifier
     */

    EmployeePayRollData UpdateEmployeePayroll(int empId, EmployeePayrollDto employeePayrollDto);
    /**
     * method to delete employee payroll data by id
     *
     * @param empid unique identifier pf employee
     */
    void deleteEmployeePayroll(int empid);

}
