package com.example.workhub.controller;

import com.example.workhub.entity.Mentor;
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
    return service.updateMentor(id, mentor);
  }

  @DeleteMapping("/{id}")
  public String delete(@PathVariable Long id) {
    service.deleteMentor(id);
    return "Mentor deleted successfully";
  }

  @GetMapping("/{id}")
  public Mentor getOne(@PathVariable Long id) {
    return service.getMentor(id);
  }

  // ⭐ REQUIRED FOR MentorList
  @GetMapping
  public List<Mentor> getAll() {
    return service.getAllMentors();
  }

  @GetMapping("/search")
  public List<Mentor> search(@RequestParam String keyword) {
    return service.searchMentors(keyword);
  }
}
