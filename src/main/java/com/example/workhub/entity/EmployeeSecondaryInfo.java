package com.example.workhub.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "employee_secondary_info")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeSecondaryInfo {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long secondaryId;

  private String fatherName;
  private String motherName;
  private String bloodGroup;
  private String maritalStatus;
  private String aadhaarNumber;
  private String panNumber;
  private String emergencyContactName;
  private String emergencyContactNumber;

  @OneToOne
  @JoinColumn(name = "employee_id", unique = true)
  private EmployeePrimaryInfo employeePrimaryInfo;
}
