package com.example.employee.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "positions")
public class Position {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer positionId;

  // @NotBlank
  @Column(nullable = false)
  private String positionName;

  // @ManyToOne
  // @JoinColumn(name = "idOrganisation", nullable = false)
  // private Organisation organisation;

  // @ManyToOne
  // @JoinColumn(name = "idEmployee", nullable = false)
  // private Employee employee;
}
