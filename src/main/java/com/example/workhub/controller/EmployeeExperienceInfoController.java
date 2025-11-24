package com.example.workhub.controller;

import com.example.workhub.entity.EmployeeExperienceInfo;
import com.example.workhub.service.EmployeeExperienceInfoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/experience")
public class EmployeeExperienceInfoController {

  private final EmployeeExperienceInfoService service;

  public EmployeeExperienceInfoController(EmployeeExperienceInfoService service) {
    this.service = service;
  }

  @PostMapping
  public EmployeeExperienceInfo create(@RequestBody EmployeeExperienceInfo experience) {
    return service.createExperience(experience);
  }

  @GetMapping("/{id}")
  public EmployeeExperienceInfo getById(@PathVariable Long id) {
    return service.getExperienceById(id);
  }

  @GetMapping
  public List<EmployeeExperienceInfo> getAll() {
    return service.getAllExperience();
  }

  @GetMapping("/employee/{employeeId}")
  public List<EmployeeExperienceInfo> getByEmployee(@PathVariable Long employeeId) {
    return service.getExperienceByEmployeeId(employeeId);
  }

  @PutMapping("/{id}")
  public EmployeeExperienceInfo update(@PathVariable Long id, @RequestBody EmployeeExperienceInfo experience) {
    return service.updateExperience(id, experience);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    service.deleteExperience(id);
  }
}
