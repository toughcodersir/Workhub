package com.example.workhub.service;

import com.example.workhub.entity.EmployeeExperienceInfo;
import java.util.List;

public interface EmployeeExperienceInfoService {

  EmployeeExperienceInfo createExperience(EmployeeExperienceInfo experience);

  EmployeeExperienceInfo getExperienceById(Long id);

  List<EmployeeExperienceInfo> getAllExperience();

  List<EmployeeExperienceInfo> getExperienceByEmployeeId(Long employeeId);

  EmployeeExperienceInfo updateExperience(Long id, EmployeeExperienceInfo updatedExperience);

  void deleteExperience(Long id);
}
