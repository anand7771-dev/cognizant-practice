package com.cognizant.ormlearn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.ormlearn.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // Hands-on 2 - Get all permanent employees using HQL
    @Query("""
           SELECT DISTINCT e
           FROM Employee e
           LEFT JOIN FETCH e.department
           LEFT JOIN FETCH e.skillList
           WHERE e.permanent = true
           """)
    List<Employee> getAllPermanentEmployees();


    // Hands-on 4 - Get average salary using HQL
    @Query("""
           SELECT AVG(e.salary)
           FROM Employee e
           WHERE e.department.id = :id
           """)
    Double getAverageSalary(@Param("id") int departmentId);


    // Hands-on 5 - Get all employees using Native Query
    @Query(value = "SELECT * FROM employee", nativeQuery = true)
    List<Employee> getAllEmployeesNative();
}