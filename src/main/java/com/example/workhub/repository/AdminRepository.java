package com.example.workhub.repository;

import com.example.workhub.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
  Admin findByEmail(String email);
}
