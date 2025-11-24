package com.example.workhub.service.impl;

import com.example.workhub.entity.EmployeeEducationInfo;
import com.example.workhub.entity.EmployeePrimaryInfo;
import com.example.workhub.repository.EmployeeEducationInfoRepository;
import com.example.workhub.repository.EmployeePrimaryInfoRepository;
import com.example.workhub.service.EmployeeEducationInfoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeEducationInfoServiceImpl implements EmployeeEducationInfoService {

  private final EmployeeEducationInfoRepository educationRepo;
  private final EmployeePrimaryInfoRepository primaryRepo;

  public EmployeeEducationInfoServiceImpl(EmployeeEducationInfoRepository educationRepo,
      EmployeePrimaryInfoRepository primaryRepo) {
    this.educationRepo = educationRepo;
    this.primaryRepo = primaryRepo;
  }

  @Override
  public EmployeeEducationInfo createEducation(Long employeeId, EmployeeEducationInfo education) {
    EmployeePrimaryInfo primary = primaryRepo.findById(employeeId).orElse(null);
    if (primary == null)
      return null;

    education.setEmployeePrimaryInfo(primary);
    return educationRepo.save(education);
  }

  @Override
  public EmployeeEducationInfo getEducationById(Long id) {
    return educationRepo.findById(id).orElse(null);
  }

  @Override
  public List<EmployeeEducationInfo> getAllEducation() {
    return educationRepo.findAll();
  }

  @Override
  public List<EmployeeEducationInfo> getEducationByEmployeeId(Long employeeId) {
    return educationRepo.findByEmployeePrimaryInfoEmployeeId(employeeId);
  }

  @Override
  public EmployeeEducationInfo updateEducation(Long id, EmployeeEducationInfo updatedEducation) {
    return educationRepo.findById(id)
        .map(existing -> {
          updatedEducation.setEducationId(existing.getEducationId());
          updatedEducation.setEmployeePrimaryInfo(existing.getEmployeePrimaryInfo());
          return educationRepo.save(updatedEducation);
        })
        .orElse(null);
  }

  @Override
  public void deleteEducation(Long id) {
    educationRepo.deleteById(id);
  }
}
