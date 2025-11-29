package com.example.workhub.controller;

import com.example.workhub.entity.Admin;
import com.example.workhub.service.AdminService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

  private final AdminService service;

  public AdminController(AdminService service) {
    this.service = service;
  }

  @PostMapping("/register")
  public Admin register(@RequestBody Admin admin) {
    return service.createAdmin(admin);
  }

  @PostMapping("/login")
  public Admin login(@RequestBody Admin admin) {
    return service.login(admin.getEmail(), admin.getPassword());
  }
}
