package com.example.workhub.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "employee_primary_info")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeePrimaryInfo {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long employeeId;
  private String firstName;
  private String lastName;
  private String email;
  private String phone;
  private LocalDate dateOfBirth;
  private String gender;
  private LocalDate joiningDate;
  private String designation;
  private String status;
}