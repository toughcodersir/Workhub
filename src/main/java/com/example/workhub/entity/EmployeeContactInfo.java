package com.example.workhub.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "employee_contact_info")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeContactInfo {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long contactId;

  private String phoneType; // e.g., Home, Work, Mobile
  private String phoneNumber;

  private String emailType; // e.g., Personal, Work
  private String email;

  @ManyToOne
  @JoinColumn(name = "employee_id")
  private EmployeePrimaryInfo employeePrimaryInfo;
}
