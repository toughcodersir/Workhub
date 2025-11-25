package com.example.workhub.controller;

import com.example.workhub.entity.EmployeePermanentAddress;
import com.example.workhub.service.EmployeePermanentAddressService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
public class EmployeePermanentAddressController {

  private final EmployeePermanentAddressService service;

  public EmployeePermanentAddressController(EmployeePermanentAddressService service) {
    this.service = service;
  }

  @PostMapping("/{id}/permanent-address")
  public EmployeePermanentAddress create(@PathVariable Long id, @RequestBody EmployeePermanentAddress address) {
    return service.createPermanentAddress(id, address);
  }

  @GetMapping("/{id}/permanent-address")
  public EmployeePermanentAddress get(@PathVariable Long id) {
    return service.getPermanentAddressByEmployeeId(id);
  }

  @PutMapping("/{id}/permanent-address")
  public EmployeePermanentAddress update(@PathVariable Long id, @RequestBody EmployeePermanentAddress address) {
    return service.updatePermanentAddress(id, address);
  }

  @DeleteMapping("/{id}/permanent-address")
  public void delete(@PathVariable Long id) {
    service.deletePermanentAddress(id);
  }
}
