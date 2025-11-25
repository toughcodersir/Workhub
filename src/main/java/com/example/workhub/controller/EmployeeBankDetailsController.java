package com.example.workhub.controller;

import com.example.workhub.entity.EmployeeBankDetails;
import com.example.workhub.service.EmployeeBankDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bank")
public class EmployeeBankDetailsController {

  private final EmployeeBankDetailsService service;

  public EmployeeBankDetailsController(EmployeeBankDetailsService service) {
    this.service = service;
  }

  @PostMapping("/{employeeId}")
  public EmployeeBankDetails create(@PathVariable Long employeeId,
      @RequestBody EmployeeBankDetails bankDetails) {
    return service.createBankDetails(employeeId, bankDetails);
  }

  @GetMapping("/{employeeId}")
  public EmployeeBankDetails get(@PathVariable Long employeeId) {
    return service.getBankDetails(employeeId);
  }

  @PutMapping("/{employeeId}")
  public EmployeeBankDetails update(@PathVariable Long employeeId,
      @RequestBody EmployeeBankDetails bankDetails) {
    return service.updateBankDetails(employeeId, bankDetails);
  }

  @DeleteMapping("/{employeeId}")
  public void delete(@PathVariable Long employeeId) {
    service.deleteBankDetails(employeeId);
  }
}
