package com.example.workhub.controller;

import com.example.workhub.entity.EmployeeTemporaryAddress;
import com.example.workhub.service.EmployeeTemporaryAddressService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
public class EmployeeTemporaryAddressController {

  private final EmployeeTemporaryAddressService service;

  public EmployeeTemporaryAddressController(EmployeeTemporaryAddressService service) {
    this.service = service;
  }

  @PostMapping("/{id}/temporary-address")
  public EmployeeTemporaryAddress create(@PathVariable Long id,
      @RequestBody EmployeeTemporaryAddress address) {
    return service.createTemporaryAddress(id, address);
  }

  @GetMapping("/{id}/temporary-address")
  public EmployeeTemporaryAddress get(@PathVariable Long id) {
    return service.getTemporaryAddressByEmployeeId(id);
  }

  @PutMapping("/{id}/temporary-address")
  public EmployeeTemporaryAddress update(@PathVariable Long id,
      @RequestBody EmployeeTemporaryAddress address) {
    return service.updateTemporaryAddress(id, address);
  }

  @DeleteMapping("/{id}/temporary-address")
  public void delete(@PathVariable Long id) {
    service.deleteTemporaryAddress(id);
  }
}
