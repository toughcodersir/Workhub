package com.example.workhub.service.impl;

import com.example.workhub.entity.EmployeeExperienceInfo;
import com.example.workhub.repository.EmployeeExperienceInfoRepository;
import com.example.workhub.service.EmployeeExperienceInfoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeExperienceInfoServiceImpl implements EmployeeExperienceInfoService {

  private final EmployeeExperienceInfoRepository repository;

  public EmployeeExperienceInfoServiceImpl(EmployeeExperienceInfoRepository repository) {
    this.repository = repository;
  }

  @Override
  public EmployeeExperienceInfo createExperience(EmployeeExperienceInfo experience) {
    return repository.save(experience);
  }

  @Override
  public EmployeeExperienceInfo getExperienceById(Long id) {
    return repository.findById(id).orElse(null);
  }

  @Override
  public List<EmployeeExperienceInfo> getAllExperience() {
    return repository.findAll();
  }

  @Override
  public List<EmployeeExperienceInfo> getExperienceByEmployeeId(Long employeeId) {
    return repository.findByEmployeeId(employeeId);
  }

  @Override
  public EmployeeExperienceInfo updateExperience(Long id, EmployeeExperienceInfo updatedExperience) {
    EmployeeExperienceInfo existing = repository.findById(id).orElse(null);
    if (existing == null)
      return null;

    updatedExperience.setExperienceId(id);
    return repository.save(updatedExperience);
  }

  @Override
  public void deleteExperience(Long id) {
    repository.deleteById(id);
  }
}
