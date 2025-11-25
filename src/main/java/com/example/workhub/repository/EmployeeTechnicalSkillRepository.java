package com.example.workhub.repository;

import com.example.workhub.entity.EmployeeTechnicalSkill;
import com.example.workhub.entity.EmployeePrimaryInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EmployeeTechnicalSkillRepository extends JpaRepository<EmployeeTechnicalSkill, Long> {

  List<EmployeeTechnicalSkill> findByEmployeePrimaryInfo(EmployeePrimaryInfo employee);
}
