package com.example.workhub.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class SearchResponse {

  private List<Mentor> mentors;
  private List<EmployeePrimaryInfo> employees;
  private List<Batch> batches;
}
