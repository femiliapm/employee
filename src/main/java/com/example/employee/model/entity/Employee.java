package com.example.employee.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
// import javax.persistence.JoinColumn;
// import javax.persistence.OneToMany;
import javax.persistence.Table;
// import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
@Entity
@Table(name = "employees")
public class Employee {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer employeeId;

  // @NotBlank
  @Column(unique = true, length = 25)
  private String employeeCode;

  // @NotBlank
  @Column(nullable = false, length = 50)
  private String employeeName;

  // @NotBlank
  @Column(length = 50, nullable = false)
  private String status;

  // @OneToMany
  // @JoinColumn(name = "idPosition", nullable = false)
  // private Position position;
}
