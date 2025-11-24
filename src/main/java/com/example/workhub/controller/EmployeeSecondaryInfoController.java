package com.example.workhub.controller;

import com.example.workhub.entity.EmployeeSecondaryInfo;
import com.example.workhub.service.EmployeeSecondaryInfoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
public class EmployeeSecondaryInfoController {

  private final EmployeeSecondaryInfoService service;

  public EmployeeSecondaryInfoController(EmployeeSecondaryInfoService service) {
    this.service = service;
  }

  @PostMapping("/{id}/secondary")
  public EmployeeSecondaryInfo create(@PathVariable Long id, @RequestBody EmployeeSecondaryInfo secondaryInfo) {
    return service.createSecondaryInfo(id, secondaryInfo);
  }

  @GetMapping("/{id}/secondary")
  public EmployeeSecondaryInfo get(@PathVariable Long id) {
    return service.getSecondaryInfoByEmployeeId(id);
  }

  @PutMapping("/{id}/secondary")
  public EmployeeSecondaryInfo update(@PathVariable Long id, @RequestBody EmployeeSecondaryInfo secondaryInfo) {
    return service.updateSecondaryInfo(id, secondaryInfo);
  }

  @DeleteMapping("/{id}/secondary")
  public void delete(@PathVariable Long id) {
    service.deleteSecondaryInfo(id);
  }
}
