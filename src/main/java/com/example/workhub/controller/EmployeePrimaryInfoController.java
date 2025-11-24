package com.example.workhub.controller;

import com.example.workhub.entity.EmployeePrimaryInfo;
import com.example.workhub.service.EmployeePrimaryInfoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeePrimaryInfoController {

  private final EmployeePrimaryInfoService service;

  public EmployeePrimaryInfoController(EmployeePrimaryInfoService service) {
    this.service = service;
  }

  @PostMapping
  public EmployeePrimaryInfo create(@RequestBody EmployeePrimaryInfo employee) {
    return service.createEmployee(employee);
  }

  @GetMapping("/{id}")
  public EmployeePrimaryInfo getById(@PathVariable Long id) {
    return service.getEmployeeById(id);
  }

  @GetMapping
  public List<EmployeePrimaryInfo> getAll() {
    return service.getAllEmployees();
  }

  @PutMapping("/{id}")
  public EmployeePrimaryInfo update(@PathVariable Long id, @RequestBody EmployeePrimaryInfo employee) {
    return service.updateEmployee(id, employee);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    service.deleteEmployee(id);
  }
}
