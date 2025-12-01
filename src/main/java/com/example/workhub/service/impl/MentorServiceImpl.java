package com.example.workhub.service.impl;

import com.example.workhub.entity.Mentor;
import com.example.workhub.exception.ResourceNotFoundException;
import com.example.workhub.repository.MentorRepository;
import com.example.workhub.service.MentorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MentorServiceImpl implements MentorService {

  private final MentorRepository repo;

  public MentorServiceImpl(MentorRepository repo) {
    this.repo = repo;
  }

  @Override
  public Mentor createMentor(Mentor mentor) {
    return repo.save(mentor);
  }

  @Override
  public Mentor updateMentor(Long id, Mentor updated) {

    Mentor existing = repo.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Mentor not found with ID: " + id));

    existing.setName(updated.getName());
    existing.setEmail(updated.getEmail());
    existing.setPhone(updated.getPhone());
    existing.setExpertise(updated.getExpertise());
    existing.setExperience(updated.getExperience());

    return repo.save(existing);
  }

  @Override
  public void deleteMentor(Long id) {

    Mentor existing = repo.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Mentor not found with ID: " + id));

    repo.delete(existing);
  }

  @Override
  public Mentor getMentor(Long id) {
    return repo.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Mentor not found with ID: " + id));
  }

  @Override
  public List<Mentor> getAllMentors() {
    return repo.findAll();
  }

  @Override
  public List<Mentor> searchMentors(String keyword) {
    return repo.findByNameContainingIgnoreCase(keyword);
  }
}
