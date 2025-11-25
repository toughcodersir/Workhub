package com.example.workhub.controller;

import com.example.workhub.entity.EmployeeTechnicalSkill;
import com.example.workhub.service.EmployeeTechnicalSkillService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skills")
public class EmployeeTechnicalSkillController {

  private final EmployeeTechnicalSkillService service;

  public EmployeeTechnicalSkillController(EmployeeTechnicalSkillService service) {
    this.service = service;
  }

  @PostMapping("/{employeeId}")
  public EmployeeTechnicalSkill addSkill(
      @PathVariable Long employeeId,
      @RequestBody EmployeeTechnicalSkill skill) {
    return service.addSkill(employeeId, skill);
  }

  @GetMapping("/{employeeId}")
  public List<EmployeeTechnicalSkill> getSkills(@PathVariable Long employeeId) {
    return service.getSkills(employeeId);
  }

  @PutMapping("/{skillId}")
  public EmployeeTechnicalSkill updateSkill(
      @PathVariable Long skillId,
      @RequestBody EmployeeTechnicalSkill skill) {
    return service.updateSkill(skillId, skill);
  }

  @DeleteMapping("/{skillId}")
  public void deleteSkill(@PathVariable Long skillId) {
    service.deleteSkill(skillId);
  }
}
