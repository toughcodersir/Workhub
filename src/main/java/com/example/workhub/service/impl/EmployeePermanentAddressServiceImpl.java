package com.example.workhub.service.impl;

import com.example.workhub.entity.EmployeePermanentAddress;
import com.example.workhub.entity.EmployeePrimaryInfo;
import com.example.workhub.repository.EmployeePermanentAddressRepository;
import com.example.workhub.repository.EmployeePrimaryInfoRepository;
import com.example.workhub.service.EmployeePermanentAddressService;
import org.springframework.stereotype.Service;

@Service
public class EmployeePermanentAddressServiceImpl implements EmployeePermanentAddressService {

  private final EmployeePermanentAddressRepository addressRepo;
  private final EmployeePrimaryInfoRepository primaryRepo;

  public EmployeePermanentAddressServiceImpl(EmployeePermanentAddressRepository addressRepo,
      EmployeePrimaryInfoRepository primaryRepo) {
    this.addressRepo = addressRepo;
    this.primaryRepo = primaryRepo;
  }

  @Override
  public EmployeePermanentAddress createPermanentAddress(Long employeeId, EmployeePermanentAddress address) {
    EmployeePrimaryInfo primary = primaryRepo.findById(employeeId).orElse(null);
    if (primary == null)
      return null;

    address.setEmployeePrimaryInfo(primary);
    return addressRepo.save(address);
  }

  @Override
  public EmployeePermanentAddress getPermanentAddressByEmployeeId(Long employeeId) {
    return addressRepo.findByEmployeePrimaryInfoEmployeeId(employeeId);
  }

  @Override
  public EmployeePermanentAddress updatePermanentAddress(Long employeeId, EmployeePermanentAddress updatedAddress) {
    EmployeePermanentAddress existing = addressRepo.findByEmployeePrimaryInfoEmployeeId(employeeId);
    if (existing == null)
      return null;

    updatedAddress.setPermanentAddressId(existing.getPermanentAddressId());
    updatedAddress.setEmployeePrimaryInfo(existing.getEmployeePrimaryInfo());
    return addressRepo.save(updatedAddress);
  }

  @Override
  public void deletePermanentAddress(Long employeeId) {
    EmployeePermanentAddress existing = addressRepo.findByEmployeePrimaryInfoEmployeeId(employeeId);
    if (existing != null) {
      addressRepo.delete(existing);
    }
  }
}
