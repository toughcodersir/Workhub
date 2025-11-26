package com.example.workhub.repository;

import com.example.workhub.entity.EmployeeContactInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeContactInfoRepository extends JpaRepository<EmployeeContactInfo, Long> {

  List<EmployeeContactInfo> findByEmployeePrimaryInfoEmployeeId(Long employeeId);
}
