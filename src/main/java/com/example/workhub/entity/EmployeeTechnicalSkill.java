package com.example.workhub.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "employee_technical_skills")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeTechnicalSkill {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long skillId;

  private String skillName;
  private String proficiencyLevel; // Beginner / Intermediate / Expert

  @ManyToOne
  @JoinColumn(name = "employee_id")
  private EmployeePrimaryInfo employeePrimaryInfo;
}
