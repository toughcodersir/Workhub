package com.example.workhub.service.impl;

import com.example.workhub.entity.EmployeePrimaryInfo;
import com.example.workhub.entity.EmployeeExperienceInfo;
import com.example.workhub.repository.EmployeePrimaryInfoRepository;
import com.example.workhub.repository.EmployeeExperienceInfoRepository;
import com.example.workhub.service.EmployeeExperienceInfoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeExperienceInfoServiceImpl implements EmployeeExperienceInfoService {

  private final EmployeeExperienceInfoRepository repository;
  private final EmployeePrimaryInfoRepository primaryRepo;

  public EmployeeExperienceInfoServiceImpl(EmployeeExperienceInfoRepository repository,
      EmployeePrimaryInfoRepository primaryRepo) {
    this.repository = repository;
    this.primaryRepo = primaryRepo;
  }

  @Override
  public EmployeeExperienceInfo createExperience(Long employeeId, EmployeeExperienceInfo experience) {
    EmployeePrimaryInfo employee = primaryRepo.findById(employeeId).orElse(null);
    if (employee == null)
      return null;

    experience.setEmployeePrimaryInfo(employee);
    return repository.save(experience);
  }

  @Override
  public EmployeeExperienceInfo getExperienceById(Long id) {
    return repository.findById(id).orElse(null);
  }

  @Override
  public List<EmployeeExperienceInfo> getAllExperiences() {
    return repository.findAll();
  }

  @Override
  public List<EmployeeExperienceInfo> getExperiencesByEmployeeId(Long employeeId) {
    return repository.findByEmployeePrimaryInfoEmployeeId(employeeId);
  }

  @Override
  public EmployeeExperienceInfo updateExperience(Long id, EmployeeExperienceInfo updatedExperience) {
    return repository.findById(id)
        .map(existing -> {
          updatedExperience.setExperienceId(id);
          updatedExperience.setEmployeePrimaryInfo(existing.getEmployeePrimaryInfo());
          return repository.save(updatedExperience);
        })
        .orElse(null);
  }

  @Override
  public void deleteExperience(Long id) {
    repository.deleteById(id);
  }
}
