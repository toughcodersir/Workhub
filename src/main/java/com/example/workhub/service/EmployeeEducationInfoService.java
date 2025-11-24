package com.example.workhub.service;

import com.example.workhub.entity.EmployeeEducationInfo;

import java.util.List;

public interface EmployeeEducationInfoService {

  // Create education for a specific employee
  EmployeeEducationInfo createEducation(Long employeeId, EmployeeEducationInfo education);

  // Get a single education record by its ID
  EmployeeEducationInfo getEducationById(Long id);

  // Get all education records
  List<EmployeeEducationInfo> getAllEducation();

  // Get all education records for a specific employee
  List<EmployeeEducationInfo> getEducationByEmployeeId(Long employeeId);

  // Update education entry by its ID
  EmployeeEducationInfo updateEducation(Long id, EmployeeEducationInfo updatedEducation);

  // Delete education entry by its ID
  void deleteEducation(Long id);
}
