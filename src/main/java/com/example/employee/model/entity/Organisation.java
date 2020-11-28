package com.example.employee.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
// import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
@Entity
@Table(name = "organisations")
public class Organisation {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer organisationId;

  // @NotBlank
  @Column(length = 25, unique = true)
  private String organisationCode;

  // @NotBlank
  @Column(nullable = false)
  private Date validFrom;

  // @NotBlank
  @Column(nullable = false)
  private Date validTo;
}
