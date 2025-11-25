package com.example.workhub.service;

import com.example.workhub.entity.EmployeeBankDetails;

public interface EmployeeBankDetailsService {

  EmployeeBankDetails createBankDetails(Long employeeId, EmployeeBankDetails bankDetails);

  EmployeeBankDetails getBankDetails(Long employeeId);

  EmployeeBankDetails updateBankDetails(Long employeeId, EmployeeBankDetails updatedDetails);

  void deleteBankDetails(Long employeeId);
}
