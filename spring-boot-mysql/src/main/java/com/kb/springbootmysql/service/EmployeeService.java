package com.kb.springbootmysql.service;

import com.kb.springbootmysql.entity.Employee;
import com.kb.springbootmysql.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class EmployeeService {
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployeeDetails() {
        return employeeRepository.findAll();
    }

    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public void saveEmployees(List<Employee> employees) {
        employeeRepository.saveAll(employees);
    }

    public List<Employee> getEmployeeByDepartment(String department) {
        return employeeRepository.findByDepartment(department);
    }

    public long getCountBySalary(double salary) {
        return employeeRepository.countBySalary(salary);
    }

    public List<Employee> deleteEmployeeByFirstName(String firstName) {
        return employeeRepository.deleteByFirstName(firstName);
    }

    public List<Employee> getEmployeeWithDepartmentAndSalary(String department, double salary) {
        return employeeRepository.findByDepartmentAndSalary(department, salary);
    }

    // Case insensitive sorting
    public List<Employee> getEmployeeWithDepartmentIgnoreCase(String department) {
        return employeeRepository.findByDepartmentIgnoreCase(department);
    }

    // Sort by field
    public List<Employee> getSortedEmployee(String field) {
        return employeeRepository.findAll(Sort.by(field));
    }

    // Sort by multiplefields and with sorting criteria
    public List<Employee> getSortedEmployeeBasedOnMultipleFields(String field1, String field2) {
        return employeeRepository.findAll(Sort.by(field1).descending().and(Sort.by(field2)));
    }

    //Pagination
    public Page<Employee> getPagination(int page, int size) {
        return employeeRepository.findAll(PageRequest.of(page, size));
    }

    public List<Employee> getCustomQuery() {
        return employeeRepository.getUserCustomQuery();
    }
}
