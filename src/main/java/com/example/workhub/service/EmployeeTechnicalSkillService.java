package com.example.workhub.service;

import com.example.workhub.entity.EmployeeTechnicalSkill;
import java.util.List;

public interface EmployeeTechnicalSkillService {

  EmployeeTechnicalSkill addSkill(Long employeeId, EmployeeTechnicalSkill skill);

  List<EmployeeTechnicalSkill> getSkills(Long employeeId);

  EmployeeTechnicalSkill updateSkill(Long skillId, EmployeeTechnicalSkill updatedSkill);

  void deleteSkill(Long skillId);
}
