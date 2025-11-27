package com.example.workhub.repository;

import com.example.workhub.entity.EmployeeTemporaryAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeTemporaryAddressRepository extends JpaRepository<EmployeeTemporaryAddress, Long> {

  EmployeeTemporaryAddress findByEmployeePrimaryInfoEmployeeId(Long employeeId);

}
