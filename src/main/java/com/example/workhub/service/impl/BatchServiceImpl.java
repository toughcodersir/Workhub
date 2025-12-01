package com.example.workhub.service.impl;

import com.example.workhub.entity.Batch;
import com.example.workhub.exception.ResourceNotFoundException;
import com.example.workhub.repository.BatchRepository;
import com.example.workhub.service.BatchService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BatchServiceImpl implements BatchService {

  private final BatchRepository repo;

  public BatchServiceImpl(BatchRepository repo) {
    this.repo = repo;
  }

  @Override
  public Batch createBatch(Batch batch) {
    return repo.save(batch);
  }

  @Override
  public Batch updateBatch(Long batchId, Batch updated) {

    Batch existing = repo.findById(batchId)
        .orElseThrow(() -> new ResourceNotFoundException("Batch not found with ID: " + batchId));

    existing.setBatchName(updated.getBatchName());
    existing.setMentorName(updated.getMentorName());
    existing.setTechnologies(updated.getTechnologies());
    existing.setStartDate(updated.getStartDate());
    existing.setEndDate(updated.getEndDate());
    existing.setStatus(updated.getStatus());

    return repo.save(existing);
  }

  @Override
  public void deleteBatch(Long batchId) {

    Batch existing = repo.findById(batchId)
        .orElseThrow(() -> new ResourceNotFoundException("Batch not found with ID: " + batchId));

    repo.delete(existing);
  }

  @Override
  public Batch getBatchById(Long batchId) {
    return repo.findById(batchId)
        .orElseThrow(() -> new ResourceNotFoundException("Batch not found with ID: " + batchId));
  }

  @Override
  public List<Batch> searchBatch(String keyword) {
    return repo.findByBatchNameContainingIgnoreCase(keyword);
  }

  @Override
  public List<Batch> getAllBatches() {
    return repo.findAll();
  }
}
