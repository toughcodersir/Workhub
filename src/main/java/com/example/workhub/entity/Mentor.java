package com.example.workhub.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "mentors")
public class Mentor {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long mentorId;

  private String name;
  private String email;
  private String phone;
  private String expertise; // Java / React / Python etc.
  private String experience; // 3 Years, 5 Years etc.
}
