package com.example.employee.assembler;

import com.example.employee.model.dto.Request;
import com.example.employee.model.entity.Employee;

import org.springframework.stereotype.Component;

@Component
public class EmployeeAssembler implements InterfaceAssembler<Employee, Request> {

  @Override
  public Employee fromDto(Request dto) {
    // TODO Auto-generated method stub
    if (dto == null)
      return null;

    Employee employee = new Employee();
    // if (dto.getEmployeeCode() != null)
    // employee.setEmployeeCode(dto.getEmployeeCode());
    if (dto.getEmployeeName() != null)
      employee.setEmployeeName(dto.getEmployeeName());
    if (dto.getStatus() != null)
      employee.setStatus(dto.getStatus());
    return employee;
  }

  @Override
  public Request fromEntity(Employee entity) {
    // TODO Auto-generated method stub
    if (entity == null)
      return null;

    return Request.builder().employeeId(entity.getEmployeeId()).employeeCode(entity.getEmployeeCode())
        .employeeName(entity.getEmployeeName()).status(entity.getStatus()).build();
  }

}
