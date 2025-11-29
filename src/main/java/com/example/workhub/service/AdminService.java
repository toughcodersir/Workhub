package com.example.workhub.service;

import com.example.workhub.entity.Admin;

public interface AdminService {
  Admin createAdmin(Admin admin);

  Admin login(String email, String password);
}
