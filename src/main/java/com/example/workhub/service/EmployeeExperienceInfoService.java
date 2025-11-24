package com.example.workhub.service;

import com.example.workhub.entity.EmployeeExperienceInfo;

import java.util.List;

public interface EmployeeExperienceInfoService {

  EmployeeExperienceInfo createExperience(Long employeeId, EmployeeExperienceInfo experience);

  EmployeeExperienceInfo getExperienceById(Long id);

  List<EmployeeExperienceInfo> getAllExperiences();

  List<EmployeeExperienceInfo> getExperiencesByEmployeeId(Long employeeId);

  EmployeeExperienceInfo updateExperience(Long id, EmployeeExperienceInfo updatedExperience);

  void deleteExperience(Long id);
}
