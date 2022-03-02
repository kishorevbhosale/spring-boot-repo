package com.kb.springbootmysql.repository;

import com.kb.springbootmysql.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findByDepartment(String department); // CaseSensitive

    Long countBySalary(double salary);

    List<Employee> deleteByFirstName(String firstName);

    //MultiCondition
    List<Employee> findByDepartmentAndSalary(String department, double salary);

    // Case-Insesitive
    List<Employee> findByDepartmentIgnoreCase(String department);

    //Custom Query
    @Modifying
    @Query("select u from Employee u")
    List<Employee> getUserCustomQuery();

}
