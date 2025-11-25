package com.example.workhub.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "employee_bank_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeBankDetails {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long bankId;

  private String accountNumber;
  private String bankName;
  private String ifscCode;
  private String branchName;

  @OneToOne
  @JoinColumn(name = "employee_id", unique = true)
  private EmployeePrimaryInfo employeePrimaryInfo;
}
