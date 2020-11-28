package com.example.employee.controller;

import com.example.employee.assembler.DetailAssembler;
import com.example.employee.assembler.EmployeeAssembler;
import com.example.employee.assembler.OrganisationAssembler;
import com.example.employee.assembler.PositionAssembler;
import com.example.employee.model.dto.Request;
import com.example.employee.model.dto.Response;
import com.example.employee.model.entity.Detail;
import com.example.employee.model.entity.Employee;
import com.example.employee.model.entity.Organisation;
import com.example.employee.model.entity.Position;
import com.example.employee.repository.DetailRepository;
import com.example.employee.repository.EmployeeRepository;
import com.example.employee.repository.OrganisationRepository;
import com.example.employee.repository.PositionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RestApiController {
  @Autowired
  private EmployeeRepository employeeRepository;

  @Autowired
  private EmployeeAssembler employeeAssembler;

  @Autowired
  private OrganisationAssembler organisationAssembler;

  @Autowired
  private OrganisationRepository organisationRepository;

  @Autowired
  private PositionAssembler positionAssembler;

  @Autowired
  private PositionRepository positionRepository;

  @Autowired
  private DetailAssembler detailAssembler;

  @Autowired
  private DetailRepository detailRepository;

  @PostMapping("/employee/insert")
  public ResponseEntity<?> insertEmployee(@RequestBody Request request) {
    Employee employee = employeeAssembler.fromDto(request);
    employeeRepository.save(employee);
    employee.setEmployeeCode("EMP" + String.format("%03d", employee.getEmployeeId()));
    employeeRepository.save(employee);
    return ResponseEntity.ok(new Response("Employee has been saved!"));
  }

  @PostMapping("/organisation/insert")
  public ResponseEntity<?> insertOrganisation(@RequestBody Request request) {
    Organisation organisation = organisationAssembler.fromDto(request);
    organisationRepository.save(organisation);
    return ResponseEntity.ok(new Response("Organisation has been saved!"));
  }

  @PostMapping("/position/insert")
  public ResponseEntity<?> insertPosition(@RequestBody Request request) {
    Position position = positionAssembler.fromDto(request);
    positionRepository.save(position);
    return ResponseEntity.ok(new Response("Position has been saved!"));
  }

  @PostMapping("/detail/insert")
  public ResponseEntity<?> insertDetail(@RequestBody Request request) {
    Detail detail = detailAssembler.fromDto(request);
    detailRepository.save(detail);
    detail.setPositionCode(
        detail.getOrganisation().getOrganisationCode() + String.format("%03d", detail.getPosition().getPositionId()));
    detailRepository.save(detail);
    return ResponseEntity.ok(new Response("Detail has been saved!"));
  }
}
