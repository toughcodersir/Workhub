package com.example.workhub.service.impl;

import com.example.workhub.entity.EmployeeEducationInfo;
import com.example.workhub.repository.EmployeeEducationInfoRepository;
import com.example.workhub.service.EmployeeEducationInfoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeEducationInfoServiceImpl implements EmployeeEducationInfoService {

  private final EmployeeEducationInfoRepository repository;

  public EmployeeEducationInfoServiceImpl(EmployeeEducationInfoRepository repository) {
    this.repository = repository;
  }

  @Override
  public EmployeeEducationInfo createEducation(EmployeeEducationInfo education) {
    return repository.save(education);
  }

  @Override
  public EmployeeEducationInfo getEducationById(Long id) {
    return repository.findById(id).orElse(null);
  }

  @Override
  public List<EmployeeEducationInfo> getAllEducation() {
    return repository.findAll();
  }

  @Override
  public List<EmployeeEducationInfo> getEducationByEmployeeId(Long employeeId) {
    return repository.findByEmployeeId(employeeId);
  }

  @Override
  public EmployeeEducationInfo updateEducation(Long id, EmployeeEducationInfo updatedEducation) {
    return repository.findById(id)
        .map(existing -> {
          updatedEducation.setEducationId(id);
          return repository.save(updatedEducation);
        })
        .orElse(null);
  }

  @Override
  public void deleteEducation(Long id) {
    repository.deleteById(id);
  }
}
