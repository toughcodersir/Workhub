package com.example.workhub.service.impl;

import com.example.workhub.entity.Batch;
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
    Batch existing = repo.findById(batchId).orElse(null);
    if (existing == null)
      return null;

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
    repo.deleteById(batchId);
  }

  @Override
  public Batch getBatchById(Long batchId) {
    return repo.findById(batchId).orElse(null);
  }

  @Override
  public List<Batch> searchBatch(String keyword) {
    return repo.findByBatchNameContainingIgnoreCase(keyword);
  }
}
