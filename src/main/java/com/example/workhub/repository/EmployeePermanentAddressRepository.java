package com.example.workhub.repository;

import com.example.workhub.entity.EmployeePermanentAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeePermanentAddressRepository extends JpaRepository<EmployeePermanentAddress, Long> {

  EmployeePermanentAddress findByEmployeePrimaryInfoEmployeeId(Long employeeId);
}
