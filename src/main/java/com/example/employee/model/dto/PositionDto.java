package com.example.employee.model.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PositionDto {
  private String positionCode;
  private String positionName;
  private Date validFrom;
  private Date validTo;
}
