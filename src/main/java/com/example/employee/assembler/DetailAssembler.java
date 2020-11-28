package com.example.employee.assembler;

import com.example.employee.model.dto.Request;
import com.example.employee.model.entity.Detail;
import com.example.employee.repository.EmployeeRepository;
import com.example.employee.repository.OrganisationRepository;
import com.example.employee.repository.PositionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DetailAssembler implements InterfaceAssembler<Detail, Request> {
  @Autowired
  private PositionRepository positionRepository;

  @Autowired
  private OrganisationRepository organisationRepository;

  @Autowired
  private EmployeeRepository employeeRepository;

  @Override
  public Detail fromDto(Request dto) {
    // TODO Auto-generated method stub
    if (dto == null) {
      return null;
    }

    Detail detail = new Detail();

    if (dto.getValidFromPosition() != null)
      detail.setValidFrom(dto.getValidFromPosition());
    if (dto.getValidToPosition() != null)
      detail.setValidTo(dto.getValidToPosition());
    if (dto.getPositionName() != null)
      detail.setPosition(positionRepository.findByPositionName(dto.getPositionName()));
    if (dto.getOrganisationCode() != null)
      detail.setOrganisation(organisationRepository.findByOrganisationCode(dto.getOrganisationCode()));
    if (dto.getEmployeeName() != null)
      detail.setEmployee(employeeRepository.findByEmployeeName(dto.getEmployeeName()));

    return detail;
  }

  @Override
  public Request fromEntity(Detail entity) {
    // TODO Auto-generated method stub
    if (entity == null) {
      return null;
    }

    return Request.builder().employeeId(entity.getEmployee().getEmployeeId())
        .employeeCode(entity.getEmployee().getEmployeeCode()).employeeName(entity.getEmployee().getEmployeeName())
        .status(entity.getEmployee().getStatus()).organisationId(entity.getOrganisation().getOrganisationId())
        .organisationCode(entity.getOrganisation().getOrganisationCode())
        .validFromOrganisation(entity.getOrganisation().getValidFrom())
        .validToOrganisation(entity.getOrganisation().getValidTo()).positionId(entity.getPosition().getPositionId())
        .positionName(entity.getPosition().getPositionName()).positionCode(entity.getPositionCode())
        .validFromPosition(entity.getValidFrom()).validToPosition(entity.getValidTo()).build();
  }

}
