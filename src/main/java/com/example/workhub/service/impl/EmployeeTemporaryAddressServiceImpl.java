package com.example.workhub.service.impl;

import com.example.workhub.entity.EmployeeTemporaryAddress;
import com.example.workhub.entity.EmployeePrimaryInfo;
import com.example.workhub.repository.EmployeeTemporaryAddressRepository;
import com.example.workhub.repository.EmployeePrimaryInfoRepository;
import com.example.workhub.service.EmployeeTemporaryAddressService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeTemporaryAddressServiceImpl implements EmployeeTemporaryAddressService {

  private final EmployeeTemporaryAddressRepository addressRepo;
  private final EmployeePrimaryInfoRepository primaryRepo;

  public EmployeeTemporaryAddressServiceImpl(EmployeeTemporaryAddressRepository addressRepo,
      EmployeePrimaryInfoRepository primaryRepo) {
    this.addressRepo = addressRepo;
    this.primaryRepo = primaryRepo;
  }

  @Override
  public EmployeeTemporaryAddress createTemporaryAddress(Long employeeId, EmployeeTemporaryAddress address) {
    EmployeePrimaryInfo primary = primaryRepo.findById(employeeId).orElse(null);
    if (primary == null)
      return null;

    address.setEmployeePrimaryInfo(primary);
    return addressRepo.save(address);
  }

  @Override
  public EmployeeTemporaryAddress getTemporaryAddressByEmployeeId(Long employeeId) {
    return addressRepo.findByEmployeePrimaryInfoEmployeeId(employeeId);
  }

  @Override
  public EmployeeTemporaryAddress updateTemporaryAddress(Long employeeId, EmployeeTemporaryAddress updatedAddress) {
    EmployeeTemporaryAddress existing = addressRepo.findByEmployeePrimaryInfoEmployeeId(employeeId);
    if (existing == null)
      return null;

    updatedAddress.setTemporaryAddressId(existing.getTemporaryAddressId());
    updatedAddress.setEmployeePrimaryInfo(existing.getEmployeePrimaryInfo());
    return addressRepo.save(updatedAddress);
  }

  @Override
  public void deleteTemporaryAddress(Long employeeId) {
    EmployeeTemporaryAddress existing = addressRepo.findByEmployeePrimaryInfoEmployeeId(employeeId);
    if (existing != null) {
      addressRepo.delete(existing);
    }
  }
}
