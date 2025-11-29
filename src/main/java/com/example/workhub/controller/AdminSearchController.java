package com.example.workhub.controller;

import com.example.workhub.entity.SearchResponse;
import com.example.workhub.service.AdminSearchService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/search")
@CrossOrigin
public class AdminSearchController {

  private final AdminSearchService service;

  public AdminSearchController(AdminSearchService service) {
    this.service = service;
  }

  @GetMapping
  public SearchResponse search(@RequestParam String keyword) {
    return service.globalSearch(keyword);
  }
}
