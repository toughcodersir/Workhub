package com.example.workhub.repository;

import com.example.workhub.entity.EmployeeEducationInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeEducationInfoRepository extends JpaRepository<EmployeeEducationInfo, Long> {

  // Get all education records for a given employee
  List<EmployeeEducationInfo> findByEmployeeId(Long employeeId);
}
