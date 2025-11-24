package com.example.workhub.controller;

import com.example.workhub.entity.EmployeeEducationInfo;
import com.example.workhub.service.EmployeeEducationInfoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/education")
public class EmployeeEducationInfoController {

  private final EmployeeEducationInfoService service;

  public EmployeeEducationInfoController(EmployeeEducationInfoService service) {
    this.service = service;
  }

  // Create a new education record
  @PostMapping
  public EmployeeEducationInfo create(@RequestBody EmployeeEducationInfo education) {
    return service.createEducation(education);
  }

  // Get one education record by its id
  @GetMapping("/{id}")
  public EmployeeEducationInfo getById(@PathVariable Long id) {
    return service.getEducationById(id);
  }

  // Get all education records
  @GetMapping
  public List<EmployeeEducationInfo> getAll() {
    return service.getAllEducation();
  }

  // Get all education records for a specific employee
  @GetMapping("/employee/{employeeId}")
  public List<EmployeeEducationInfo> getByEmployee(@PathVariable Long employeeId) {
    return service.getEducationByEmployeeId(employeeId);
  }

  // Update an education record by id
  @PutMapping("/{id}")
  public EmployeeEducationInfo update(@PathVariable Long id, @RequestBody EmployeeEducationInfo education) {
    return service.updateEducation(id, education);
  }

  // Delete an education record by id
  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    service.deleteEducation(id);
  }
}
