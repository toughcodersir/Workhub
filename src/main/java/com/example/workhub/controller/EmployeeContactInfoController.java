package com.example.workhub.controller;

import com.example.workhub.entity.EmployeeContactInfo;
import com.example.workhub.service.EmployeeContactInfoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contact")
public class EmployeeContactInfoController {

  private final EmployeeContactInfoService service;

  public EmployeeContactInfoController(EmployeeContactInfoService service) {
    this.service = service;
  }

  @PostMapping("/{employeeId}")
  public EmployeeContactInfo create(
      @PathVariable Long employeeId,
      @RequestBody EmployeeContactInfo contact) {
    return service.createContact(employeeId, contact);
  }

  @GetMapping("/{employeeId}")
  public List<EmployeeContactInfo> getAll(@PathVariable Long employeeId) {
    return service.getContactsByEmployeeId(employeeId);
  }

  @PutMapping("/{contactId}")
  public EmployeeContactInfo update(
      @PathVariable Long contactId,
      @RequestBody EmployeeContactInfo contact) {
    return service.updateContact(contactId, contact);
  }

  @DeleteMapping("/{contactId}")
  public void delete(@PathVariable Long contactId) {
    service.deleteContact(contactId);
  }
}
