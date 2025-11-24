package com.example.workhub.repository;

import com.example.workhub.entity.EmployeeSecondaryInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeSecondaryInfoRepository extends JpaRepository<EmployeeSecondaryInfo, Long> {

  EmployeeSecondaryInfo findByEmployeePrimaryInfoEmployeeId(Long employeeId);
}
