package com.example.workhub.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "employee_education_info")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeEducationInfo {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long educationId;

  private Long employeeId;

  private String degree;
  private String institution;
  private Integer yearOfPassing;
  private Double percentageOrCgpa;
}
