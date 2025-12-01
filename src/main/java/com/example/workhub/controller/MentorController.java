package com.example.workhub.controller;

import com.example.workhub.entity.Mentor;
import com.example.workhub.exception.ResourceNotFoundException;
import com.example.workhub.service.MentorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/mentors")
public class MentorController {

  private final MentorService service;

  public MentorController(MentorService service) {
    this.service = service;
  }

  @PostMapping
  public Mentor create(@RequestBody Mentor mentor) {
    return service.createMentor(mentor);
  }

  @PutMapping("/{id}")
  public Mentor update(@PathVariable Long id, @RequestBody Mentor mentor) {
    Mentor existing = service.getMentor(id);
    if (existing == null) {
      throw new ResourceNotFoundException("Mentor ID " + id + " not found.");
    }
    return service.updateMentor(id, mentor);
  }

  @DeleteMapping("/{id}")
  public String delete(@PathVariable Long id) {
    Mentor mentor = service.getMentor(id);
    if (mentor == null) {
      throw new ResourceNotFoundException("Mentor ID " + id + " not found.");
    }
    service.deleteMentor(id);
    return "Mentor deleted successfully";
  }

  // ⭐ GET ONE
  @GetMapping("/{id}")
  public Mentor getOne(@PathVariable Long id) {
    Mentor mentor = service.getMentor(id);
    if (mentor == null) {
      throw new ResourceNotFoundException("Mentor ID " + id + " not found.");
    }
    return mentor;
  }

  // ⭐ GET ALL
  @GetMapping
  public List<Mentor> getAll() {
    return service.getAllMentors();
  }

  @GetMapping("/search")
  public List<Mentor> search(@RequestParam String keyword) {
    return service.searchMentors(keyword);
  }
}
