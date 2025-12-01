package com.example.workhub.controller;

import com.example.workhub.entity.Batch;
import com.example.workhub.exception.ResourceNotFoundException;
import com.example.workhub.service.BatchService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/batches")
public class BatchController {

  private final BatchService service;

  public BatchController(BatchService service) {
    this.service = service;
  }

  // ⭐ GET ALL BATCHES
  @GetMapping
  public List<Batch> getAll() {
    return service.getAllBatches();
  }

  @PostMapping
  public Batch create(@RequestBody Batch batch) {
    return service.createBatch(batch);
  }

  @PutMapping("/{id}")
  public Batch update(@PathVariable Long id, @RequestBody Batch batch) {
    Batch existing = service.getBatchById(id);
    if (existing == null) {
      throw new ResourceNotFoundException("Batch ID " + id + " not found.");
    }
    return service.updateBatch(id, batch);
  }

  @DeleteMapping("/{id}")
  public String delete(@PathVariable Long id) {
    Batch batch = service.getBatchById(id);
    if (batch == null) {
      throw new ResourceNotFoundException("Batch ID " + id + " not found.");
    }
    service.deleteBatch(id);
    return "Batch deleted successfully";
  }

  @GetMapping("/{id}")
  public Batch getOne(@PathVariable Long id) {
    Batch batch = service.getBatchById(id);
    if (batch == null) {
      throw new ResourceNotFoundException("Batch ID " + id + " not found.");
    }
    return batch;
  }

  @GetMapping("/search")
  public List<Batch> search(@RequestParam String keyword) {
    return service.searchBatch(keyword);
  }
}
