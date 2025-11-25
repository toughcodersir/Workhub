package com.example.workhub.service;

import com.example.workhub.entity.EmployeePermanentAddress;

public interface EmployeePermanentAddressService {

  EmployeePermanentAddress createPermanentAddress(Long employeeId, EmployeePermanentAddress address);

  EmployeePermanentAddress getPermanentAddressByEmployeeId(Long employeeId);

  EmployeePermanentAddress updatePermanentAddress(Long employeeId, EmployeePermanentAddress updatedAddress);

  void deletePermanentAddress(Long employeeId);
}
