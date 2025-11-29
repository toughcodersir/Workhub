package com.example.workhub.service.impl;

import com.example.workhub.entity.SearchResponse;
import com.example.workhub.entity.EmployeePrimaryInfo;
import com.example.workhub.repository.BatchRepository;
import com.example.workhub.repository.EmployeePrimaryInfoRepository;
import com.example.workhub.repository.MentorRepository;
import com.example.workhub.service.AdminSearchService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminSearchServiceImpl implements AdminSearchService {

  private final MentorRepository mentorRepo;
  private final EmployeePrimaryInfoRepository employeeRepo;
  private final BatchRepository batchRepo;

  public AdminSearchServiceImpl(
      MentorRepository mentorRepo,
      EmployeePrimaryInfoRepository employeeRepo,
      BatchRepository batchRepo) {

    this.mentorRepo = mentorRepo;
    this.employeeRepo = employeeRepo;
    this.batchRepo = batchRepo;
  }

  @Override
  public SearchResponse globalSearch(String keyword) {

    // combine employee searches: firstName + lastName + email
    List<EmployeePrimaryInfo> employees = combine(
        employeeRepo.findByFirstNameContainingIgnoreCase(keyword),
        employeeRepo.findByLastNameContainingIgnoreCase(keyword),
        employeeRepo.findByEmailContainingIgnoreCase(keyword));

    return new SearchResponse(
        mentorRepo.findByNameContainingIgnoreCase(keyword), // mentors
        employees, // employees
        batchRepo.findByBatchNameContainingIgnoreCase(keyword) // batches
    );
  }

  private List<EmployeePrimaryInfo> combine(List<EmployeePrimaryInfo>... lists) {
    List<EmployeePrimaryInfo> finalList = new ArrayList<>();
    for (List<EmployeePrimaryInfo> list : lists) {
      finalList.addAll(list);
    }
    return finalList;
  }
}
