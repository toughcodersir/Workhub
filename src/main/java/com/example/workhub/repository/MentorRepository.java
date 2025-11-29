package com.example.workhub.repository;

import com.example.workhub.entity.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MentorRepository extends JpaRepository<Mentor, Long> {

  List<Mentor> findByNameContainingIgnoreCase(String keyword);

  Mentor findByEmail(String email);
}
