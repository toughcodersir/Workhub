package com.example.workhub.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "employee_permanent_address")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeePermanentAddress {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long permanentAddressId;

  private String houseNumber;
  private String street;
  private String city;
  private String state;
  private String country;
  private String pincode;

  @OneToOne
  @JoinColumn(name = "employee_id")
  private EmployeePrimaryInfo employeePrimaryInfo;
}
