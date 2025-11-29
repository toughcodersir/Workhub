package com.example.workhub.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "batches")
public class Batch {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long batchId;

  private String batchName;
  private String mentorName;
  private String technologies;
  private LocalDate startDate;
  private LocalDate endDate;
  private String status; // To be started / In-progress / Completed
}
