package com.example.workhub.service.impl;

import com.example.workhub.entity.EmployeePrimaryInfo;
import com.example.workhub.entity.EmployeeTechnicalSkill;
import com.example.workhub.repository.EmployeePrimaryInfoRepository;
import com.example.workhub.repository.EmployeeTechnicalSkillRepository;
import com.example.workhub.service.EmployeeTechnicalSkillService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeTechnicalSkillServiceImpl implements EmployeeTechnicalSkillService {

  private final EmployeeTechnicalSkillRepository skillRepo;
  private final EmployeePrimaryInfoRepository employeeRepo;

  public EmployeeTechnicalSkillServiceImpl(EmployeeTechnicalSkillRepository skillRepo,
      EmployeePrimaryInfoRepository employeeRepo) {
    this.skillRepo = skillRepo;
    this.employeeRepo = employeeRepo;
  }

  @Override
  public EmployeeTechnicalSkill addSkill(Long employeeId, EmployeeTechnicalSkill skill) {
    EmployeePrimaryInfo emp = employeeRepo.findById(employeeId).orElse(null);
    if (emp == null)
      return null;

    skill.setEmployeePrimaryInfo(emp);
    return skillRepo.save(skill);
  }

  @Override
  public List<EmployeeTechnicalSkill> getSkills(Long employeeId) {
    EmployeePrimaryInfo emp = employeeRepo.findById(employeeId).orElse(null);
    if (emp == null)
      return null;

    return skillRepo.findByEmployeePrimaryInfo(emp);
  }

  @Override
  public EmployeeTechnicalSkill updateSkill(Long skillId, EmployeeTechnicalSkill updatedSkill) {
    return skillRepo.findById(skillId).map(existing -> {
      updatedSkill.setSkillId(skillId);
      updatedSkill.setEmployeePrimaryInfo(existing.getEmployeePrimaryInfo());
      return skillRepo.save(updatedSkill);
    }).orElse(null);
  }

  @Override
  public void deleteSkill(Long skillId) {
    skillRepo.deleteById(skillId);
  }
}
