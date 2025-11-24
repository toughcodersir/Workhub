package com.example.workhub.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "employee_experience_info")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeExperienceInfo {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long experienceId;

  private Long employeeId;
  private String companyName;
  private String jobTitle;
  private String startDate;
  private String endDate;
  private Double yearsOfExperience;
  private String technologiesUsed;
}
