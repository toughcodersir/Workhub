package com.example.workhub.service;

import com.example.workhub.entity.EmployeeContactInfo;
import java.util.List;

public interface EmployeeContactInfoService {

  EmployeeContactInfo createContact(Long employeeId, EmployeeContactInfo contact);

  List<EmployeeContactInfo> getContactsByEmployeeId(Long employeeId);

  EmployeeContactInfo updateContact(Long contactId, EmployeeContactInfo updatedContact);

  void deleteContact(Long contactId);
}
