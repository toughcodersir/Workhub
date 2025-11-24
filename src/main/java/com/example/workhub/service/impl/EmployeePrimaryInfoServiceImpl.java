package com.example.workhub.service.impl;

import com.example.workhub.entity.EmployeePrimaryInfo;
import com.example.workhub.repository.EmployeePrimaryInfoRepository;
import com.example.workhub.service.EmployeePrimaryInfoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeePrimaryInfoServiceImpl implements EmployeePrimaryInfoService {

  private final EmployeePrimaryInfoRepository repository;

  public EmployeePrimaryInfoServiceImpl(EmployeePrimaryInfoRepository repository) {
    this.repository = repository;
  }

  @Override
  public EmployeePrimaryInfo createEmployee(EmployeePrimaryInfo employee) {
    return repository.save(employee);
  }

  @Override
  public EmployeePrimaryInfo getEmployeeById(Long id) {
    return repository.findById(id).orElse(null);
  }

  @Override
  public List<EmployeePrimaryInfo> getAllEmployees() {
    return repository.findAll();
  }

  @Override
  public EmployeePrimaryInfo updateEmployee(Long id, EmployeePrimaryInfo updatedEmployee) {
    return repository.findById(id)
        .map(existing -> {
          updatedEmployee.setEmployeeId(id);
          return repository.save(updatedEmployee);
        })
        .orElse(null);
  }

  @Override
  public void deleteEmployee(Long id) {
    repository.deleteById(id);
  }
}
