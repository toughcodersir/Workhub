package com.example.workhub.service.impl;

import com.example.workhub.entity.EmployeeContactInfo;
import com.example.workhub.entity.EmployeePrimaryInfo;
import com.example.workhub.repository.EmployeeContactInfoRepository;
import com.example.workhub.repository.EmployeePrimaryInfoRepository;
import com.example.workhub.service.EmployeeContactInfoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeContactInfoServiceImpl implements EmployeeContactInfoService {

  private final EmployeeContactInfoRepository contactRepo;
  private final EmployeePrimaryInfoRepository primaryRepo;

  public EmployeeContactInfoServiceImpl(EmployeeContactInfoRepository contactRepo,
      EmployeePrimaryInfoRepository primaryRepo) {
    this.contactRepo = contactRepo;
    this.primaryRepo = primaryRepo;
  }

  @Override
  public EmployeeContactInfo createContact(Long employeeId, EmployeeContactInfo contact) {
    EmployeePrimaryInfo primary = primaryRepo.findById(employeeId).orElse(null);
    if (primary == null)
      return null;

    contact.setEmployeePrimaryInfo(primary);
    return contactRepo.save(contact);
  }

  @Override
  public List<EmployeeContactInfo> getContactsByEmployeeId(Long employeeId) {
    return contactRepo.findByEmployeePrimaryInfoEmployeeId(employeeId);
  }

  @Override
  public EmployeeContactInfo updateContact(Long contactId, EmployeeContactInfo updatedContact) {
    return contactRepo.findById(contactId).map(existing -> {
      updatedContact.setContactId(contactId);
      updatedContact.setEmployeePrimaryInfo(existing.getEmployeePrimaryInfo());
      return contactRepo.save(updatedContact);
    }).orElse(null);
  }

  @Override
  public void deleteContact(Long contactId) {
    contactRepo.deleteById(contactId);
  }
}
