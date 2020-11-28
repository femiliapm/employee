package com.example.employee.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
// import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
@Entity
@Table(name = "details")
public class Detail {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer detailId;

  // @NotBlank
  @Column(length = 25)
  private String positionCode;

  // @NotBlank
  // @Column(nullable = false)
  // private String positionName;

  // @NotBlank
  @Column(nullable = false)
  private Date validFrom;

  // @NotBlank
  @Column(nullable = false)
  private Date validTo;

  @ManyToOne
  @JoinColumn(name = "idOrganisation", nullable = false)
  private Organisation organisation;

  @ManyToOne
  @JoinColumn(name = "idPosition", nullable = false)
  private Position position;
  
  @ManyToOne
  @JoinColumn(name = "idEmployee", nullable = false)
  private Employee employee;
}
