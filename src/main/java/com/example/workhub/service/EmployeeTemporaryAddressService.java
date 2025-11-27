package com.example.workhub.service;

import com.example.workhub.entity.EmployeeTemporaryAddress;

public interface EmployeeTemporaryAddressService {

  EmployeeTemporaryAddress createTemporaryAddress(Long employeeId, EmployeeTemporaryAddress address);

  EmployeeTemporaryAddress getTemporaryAddressByEmployeeId(Long employeeId);

  EmployeeTemporaryAddress updateTemporaryAddress(Long employeeId, EmployeeTemporaryAddress updatedAddress);

  void deleteTemporaryAddress(Long employeeId);
}
