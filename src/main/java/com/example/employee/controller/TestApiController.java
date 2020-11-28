package com.example.employee.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.example.employee.assembler.DetailAssembler;
import com.example.employee.assembler.EmployeeAssembler;
import com.example.employee.model.dto.Request;
import com.example.employee.model.entity.Detail;
import com.example.employee.model.entity.Employee;
import com.example.employee.repository.DetailRepository;
import com.example.employee.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestApiController {
  @Autowired
  private DetailAssembler detailAssembler;

  @Autowired
  private DetailRepository detailRepository;

  @Autowired
  private EmployeeAssembler employeeAssembler;

  @Autowired
  private EmployeeRepository employeeRepository;

  // Detail Employee
  @GetMapping("/detail")
  public ResponseEntity<?> getDetail() {
    List<Detail> details = detailRepository.findAll();
    List<Request> requests = details.stream().map(entity -> detailAssembler.fromEntity(entity))
        .collect(Collectors.toList());
    return ResponseEntity.ok(requests);
  }

  @GetMapping("/detail/{idEmployee}")
  public ResponseEntity<?> getDetailById(@PathVariable Integer idEmployee) {
    if (detailRepository.findById(idEmployee) == null) {
      return (ResponseEntity<?>) ResponseEntity.badRequest();
    } else {
      List<Detail> details = detailRepository.findAllByIdEmployee(idEmployee);
      List<Request> requests = details.stream().map(entity -> detailAssembler.fromEntity(entity))
          .collect(Collectors.toList());
      return ResponseEntity.ok(requests);
    }
  }

  // Employee
  @GetMapping("/employee")
  public ResponseEntity<?> getEmployee() {
    List<Employee> employees = employeeRepository.findAll();
    List<Request> requests = employees.stream().map(entity -> employeeAssembler.fromEntity(entity))
        .collect(Collectors.toList());
    return ResponseEntity.ok(requests);
  }

  @GetMapping("/employee/{idEmployee}")
  public ResponseEntity<?> getEmployeeById(@PathVariable Integer idEmployee) {
    if (employeeRepository.findById(idEmployee) == null) {
      return (ResponseEntity<?>) ResponseEntity.badRequest();
    } else {
      List<Employee> employees = employeeRepository.findAllById(idEmployee);
      List<Request> requests = employees.stream().map(entity -> employeeAssembler.fromEntity(entity))
          .collect(Collectors.toList());
      return ResponseEntity.ok(requests);
    }
  }
}
