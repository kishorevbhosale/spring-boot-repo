package com.kb.springbootmysql.controller;

import com.kb.springbootmysql.entity.Employee;
import com.kb.springbootmysql.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;

    @GetMapping("/details/all")
    public List<Employee> getAllEmployeeDetails() {
        return employeeService.getAllEmployeeDetails();
    }

    @PostMapping("/save/single")
    public String addEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return "Employee details is saved!!!";
    }

    @PostMapping("/save/multiple")
    public String addEmployees(@RequestBody List<Employee> employees) {
        employeeService.saveEmployees(employees);
        return "Employees details are saved!!!";
    }

    @GetMapping("/get-by/department/{department}")
    public List<Employee> getEmployeeByDepartment(@PathVariable String department) {
        return employeeService.getEmployeeByDepartment(department);
    }

    @GetMapping("/get-by/salary/{salary}")
    public String getEmployeeCountBySalary(@PathVariable double salary) {
        long count = employeeService.getCountBySalary(salary);
        return "Total number of records of age " + salary + " : " + count;
    }

    @DeleteMapping("/delete-by/first-name/{firstName}")
    public List<Employee> deleteEmployeeByFirstName(@PathVariable String firstName) {
        return employeeService.deleteEmployeeByFirstName(firstName);
    }

    @GetMapping("/get-by/department-salary/{department}/{salary}")
    public List<Employee> getEmployeeWithDepartmentAndSalary(@PathVariable String department, @PathVariable double salary) {
        return employeeService.getEmployeeWithDepartmentAndSalary(department, salary);
    }

    @GetMapping("/get-by/department-ignore-case/{department}")
    public List<Employee> getEmployeeWithDepartmentIgnoreCase(@PathVariable String department) {
        return employeeService.getEmployeeWithDepartmentIgnoreCase(department);
    }

    @GetMapping("/get-by/sorted/employee/{field}")
    public List<Employee> getSortedEmployee(@PathVariable String field) {
        return employeeService.getSortedEmployee(field);
    }

    @GetMapping("/get-by/multi-sorted-employees/{field1}/{field2}")
    public List<Employee> getSortedEmployeeBasedOnMultipleFields(@PathVariable String field1, @PathVariable String field2) {
        return employeeService.getSortedEmployeeBasedOnMultipleFields(field1, field2);
    }

    @GetMapping("/pagination/{page}/{size}")
    public Page<Employee> getPagination(@PathVariable int page, @PathVariable int size) {
        return employeeService.getPagination(page, size);
    }

    @GetMapping(value = "/custom-query")
    public List<Employee> getCustomEmployees() {
        return employeeService.getCustomQuery();
    }
}
