package com.example.employee.model.dto;

import java.sql.Date;

// import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Request {
  private Integer employeeId;

  // @NotBlank
  private String employeeCode;

  // @NotBlank
  private String employeeName;

  // @NotBlank
  private String status;

  private Integer organisationId;

  // @NotBlank
  private String organisationCode;

  // @NotBlank
  private Date validFromOrganisation;

  // @NotBlank
  private Date validToOrganisation;

  private Integer positionId;

  // @NotBlank
  private String positionCode;

  // @NotBlank
  private String positionName;

  // @NotBlank
  private Date validFromPosition;

  // @NotBlank
  private Date validToPosition;
}
