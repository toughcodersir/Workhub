package com.example.workhub.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "employee_temporary_address")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeTemporaryAddress {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long temporaryAddressId;

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
