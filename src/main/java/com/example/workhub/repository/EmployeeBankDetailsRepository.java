package com.example.workhub.repository;

import com.example.workhub.entity.EmployeeBankDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeBankDetailsRepository extends JpaRepository<EmployeeBankDetails, Long> {
  EmployeeBankDetails findByEmployeePrimaryInfoEmployeeId(Long employeeId);
}
