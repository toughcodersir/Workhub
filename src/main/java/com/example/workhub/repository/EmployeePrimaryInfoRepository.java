package com.example.workhub.repository;

import com.example.workhub.entity.EmployeePrimaryInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeePrimaryInfoRepository extends JpaRepository<EmployeePrimaryInfo, Long> {

  List<EmployeePrimaryInfo> findByFirstNameContainingIgnoreCase(String keyword);

  List<EmployeePrimaryInfo> findByLastNameContainingIgnoreCase(String keyword);

  List<EmployeePrimaryInfo> findByEmailContainingIgnoreCase(String keyword);
}
