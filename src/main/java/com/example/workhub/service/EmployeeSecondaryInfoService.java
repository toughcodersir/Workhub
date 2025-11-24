package com.example.workhub.service;

import com.example.workhub.entity.EmployeeSecondaryInfo;

public interface EmployeeSecondaryInfoService {

  EmployeeSecondaryInfo createSecondaryInfo(Long employeeId, EmployeeSecondaryInfo secondaryInfo);

  EmployeeSecondaryInfo getSecondaryInfoByEmployeeId(Long employeeId);

  EmployeeSecondaryInfo updateSecondaryInfo(Long employeeId, EmployeeSecondaryInfo updatedInfo);

  void deleteSecondaryInfo(Long employeeId);
}
