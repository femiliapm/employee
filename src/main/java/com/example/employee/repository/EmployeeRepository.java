package com.example.employee.repository;

import java.util.List;

import com.example.employee.model.entity.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
  @Query(value = "select employee_id from employees where employee_name = ?", nativeQuery = true)
  Integer findIdByEmployeeName(String employeeName);

  Employee findByEmployeeName(String employeeName);

  @Query(value = "select * from employees where employee_id = ?", nativeQuery = true)
  List<Employee> findAllById(Integer employeeId);
}
