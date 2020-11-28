package com.example.employee.assembler;

import com.example.employee.model.dto.Request;
import com.example.employee.model.entity.Organisation;

import org.springframework.stereotype.Component;

@Component
public class OrganisationAssembler implements InterfaceAssembler<Organisation, Request> {

  @Override
  public Organisation fromDto(Request dto) {
    // TODO Auto-generated method stub
    if (dto == null)
      return null;

    Organisation organisation = new Organisation();

    if (dto.getOrganisationCode() != null)
      organisation.setOrganisationCode(dto.getOrganisationCode());
    if (dto.getValidFromOrganisation() != null)
      organisation.setValidFrom(dto.getValidFromOrganisation());
    if (dto.getValidToOrganisation() != null)
      organisation.setValidTo(dto.getValidToOrganisation());

    return organisation;
  }

  @Override
  public Request fromEntity(Organisation entity) {
    // TODO Auto-generated method stub
    if (entity == null)
      return null;

    return Request.builder().organisationCode(entity.getOrganisationCode()).validFromOrganisation(entity.getValidFrom())
        .validToOrganisation(entity.getValidTo()).build();
  }

}
