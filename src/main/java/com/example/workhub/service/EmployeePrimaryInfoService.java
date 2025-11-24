package com.example.workhub.service;

import com.example.workhub.entity.EmployeePrimaryInfo;
import java.util.List;

public interface EmployeePrimaryInfoService {

  EmployeePrimaryInfo createEmployee(EmployeePrimaryInfo employee);

  EmployeePrimaryInfo getEmployeeById(Long id);

  List<EmployeePrimaryInfo> getAllEmployees();

  EmployeePrimaryInfo updateEmployee(Long id, EmployeePrimaryInfo employee);

  void deleteEmployee(Long id);
}
