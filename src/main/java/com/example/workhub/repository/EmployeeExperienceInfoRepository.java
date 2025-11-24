package com.example.workhub.repository;

import com.example.workhub.entity.EmployeeExperienceInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeExperienceInfoRepository extends JpaRepository<EmployeeExperienceInfo, Long> {

  List<EmployeeExperienceInfo> findByEmployeePrimaryInfoEmployeeId(Long employeeId);
}
