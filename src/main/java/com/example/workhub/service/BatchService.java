package com.example.workhub.service;

import com.example.workhub.entity.Batch;
import java.util.List;

public interface BatchService {

  Batch createBatch(Batch batch);

  Batch updateBatch(Long batchId, Batch batch);

  void deleteBatch(Long batchId);

  Batch getBatchById(Long batchId);

  List<Batch> searchBatch(String keyword);

  List<Batch> getAllBatches();
}
