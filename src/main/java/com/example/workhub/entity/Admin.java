package com.example.workhub.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "admin")
public class Admin {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long adminId;

  private String name;

  @Column(nullable = false, unique = true)
  private String email;

  private String password;
}
