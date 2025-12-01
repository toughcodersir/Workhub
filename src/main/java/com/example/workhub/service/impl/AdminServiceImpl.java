package com.example.workhub.service.impl;

import com.example.workhub.entity.Admin;
import com.example.workhub.exception.InvalidCredentialsException;
import com.example.workhub.repository.AdminRepository;
import com.example.workhub.service.AdminService;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    private final AdminRepository repo;

    public AdminServiceImpl(AdminRepository repo) {
        this.repo = repo;
    }

    @Override
    public Admin createAdmin(Admin admin) {
        return repo.save(admin);
    }

    @Override
    public Admin login(String email, String password) {

        Admin admin = repo.findByEmail(email);

        // email not found
        if (admin == null) {
            throw new InvalidCredentialsException("Invalid email or password.");
        }

        // password mismatch
        if (!admin.getPassword().equals(password)) {
            throw new InvalidCredentialsException("Invalid email or password.");
        }

        // success
        return admin;
    }
}
