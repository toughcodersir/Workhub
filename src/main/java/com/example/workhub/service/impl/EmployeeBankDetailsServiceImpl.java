package com.example.workhub.service.impl;

import com.example.workhub.entity.EmployeeBankDetails;
import com.example.workhub.entity.EmployeePrimaryInfo;
import com.example.workhub.repository.EmployeeBankDetailsRepository;
import com.example.workhub.repository.EmployeePrimaryInfoRepository;
import com.example.workhub.service.EmployeeBankDetailsService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeBankDetailsServiceImpl implements EmployeeBankDetailsService {

  private final EmployeeBankDetailsRepository bankRepo;
  private final EmployeePrimaryInfoRepository primaryRepo;

  public EmployeeBankDetailsServiceImpl(EmployeeBankDetailsRepository bankRepo,
      EmployeePrimaryInfoRepository primaryRepo) {
    this.bankRepo = bankRepo;
    this.primaryRepo = primaryRepo;
  }

  @Override
  public EmployeeBankDetails createBankDetails(Long employeeId, EmployeeBankDetails bankDetails) {
    EmployeePrimaryInfo primary = primaryRepo.findById(employeeId).orElse(null);
    if (primary == null)
      return null;

    bankDetails.setEmployeePrimaryInfo(primary);
    return bankRepo.save(bankDetails);
  }

  @Override
  public EmployeeBankDetails getBankDetails(Long employeeId) {
    return bankRepo.findByEmployeePrimaryInfoEmployeeId(employeeId);
  }

  @Override
  public EmployeeBankDetails updateBankDetails(Long employeeId, EmployeeBankDetails updatedDetails) {
    EmployeeBankDetails existing = bankRepo.findByEmployeePrimaryInfoEmployeeId(employeeId);
    if (existing == null)
      return null;

    updatedDetails.setBankId(existing.getBankId());
    updatedDetails.setEmployeePrimaryInfo(existing.getEmployeePrimaryInfo());

    return bankRepo.save(updatedDetails);
  }

  @Override
  public void deleteBankDetails(Long employeeId) {
    EmployeeBankDetails existing = bankRepo.findByEmployeePrimaryInfoEmployeeId(employeeId);
    if (existing != null) {
      bankRepo.delete(existing);
    }
  }
}
