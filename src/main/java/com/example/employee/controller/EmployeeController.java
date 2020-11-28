package com.example.employee.controller;

import com.example.employee.assembler.EmployeeAssembler;
import com.example.employee.model.dto.Request;
import com.example.employee.model.dto.Response;
import com.example.employee.model.entity.Employee;
import com.example.employee.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
  @Autowired
  private EmployeeRepository repository;

  @Autowired
  private EmployeeAssembler assembler;

  @PostMapping
  public ResponseEntity<?> insert(@RequestBody Request request) {
    Employee employee = assembler.fromDto(request);
    repository.save(employee);
    employee.setEmployeeCode("EMP" + String.format("%03d", employee.getEmployeeId()));
    repository.save(employee);
    return ResponseEntity.ok(new Response("Employee has been saved!"));
  }
}
