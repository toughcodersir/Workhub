package com.example.workhub.service.impl;

import com.example.workhub.entity.EmployeePrimaryInfo;
import com.example.workhub.entity.EmployeeSecondaryInfo;
import com.example.workhub.repository.EmployeePrimaryInfoRepository;
import com.example.workhub.repository.EmployeeSecondaryInfoRepository;
import com.example.workhub.service.EmployeeSecondaryInfoService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeSecondaryInfoServiceImpl implements EmployeeSecondaryInfoService {

  private final EmployeeSecondaryInfoRepository secondaryRepo;
  private final EmployeePrimaryInfoRepository primaryRepo;

  public EmployeeSecondaryInfoServiceImpl(EmployeeSecondaryInfoRepository secondaryRepo,
      EmployeePrimaryInfoRepository primaryRepo) {
    this.secondaryRepo = secondaryRepo;
    this.primaryRepo = primaryRepo;
  }

  @Override
  public EmployeeSecondaryInfo createSecondaryInfo(Long employeeId, EmployeeSecondaryInfo secondaryInfo) {
    EmployeePrimaryInfo primary = primaryRepo.findById(employeeId).orElse(null);
    if (primary == null)
      return null;

    secondaryInfo.setEmployeePrimaryInfo(primary);
    return secondaryRepo.save(secondaryInfo);
  }

  @Override
  public EmployeeSecondaryInfo getSecondaryInfoByEmployeeId(Long employeeId) {
    return secondaryRepo.findByEmployeePrimaryInfoEmployeeId(employeeId);
  }

  @Override
  public EmployeeSecondaryInfo updateSecondaryInfo(Long employeeId, EmployeeSecondaryInfo updatedInfo) {
    EmployeeSecondaryInfo existing = secondaryRepo.findByEmployeePrimaryInfoEmployeeId(employeeId);
    if (existing == null)
      return null;

    updatedInfo.setSecondaryId(existing.getSecondaryId());
    updatedInfo.setEmployeePrimaryInfo(existing.getEmployeePrimaryInfo());
    return secondaryRepo.save(updatedInfo);
  }

  @Override
  public void deleteSecondaryInfo(Long employeeId) {
    EmployeeSecondaryInfo existing = secondaryRepo.findByEmployeePrimaryInfoEmployeeId(employeeId);
    if (existing != null) {
      secondaryRepo.delete(existing);
    }
  }
}
