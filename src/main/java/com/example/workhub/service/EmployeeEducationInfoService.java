package com.example.workhub.service;

import com.example.workhub.entity.EmployeeEducationInfo;

import java.util.List;

public interface EmployeeEducationInfoService {

  EmployeeEducationInfo createEducation(EmployeeEducationInfo education);

  EmployeeEducationInfo getEducationById(Long id);

  List<EmployeeEducationInfo> getAllEducation();

  List<EmployeeEducationInfo> getEducationByEmployeeId(Long employeeId);

  EmployeeEducationInfo updateEducation(Long id, EmployeeEducationInfo updatedEducation);

  void deleteEducation(Long id);
}
