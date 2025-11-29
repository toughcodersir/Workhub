package com.example.workhub.repository;

import com.example.workhub.entity.Batch;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BatchRepository extends JpaRepository<Batch, Long> {

  List<Batch> findByBatchNameContainingIgnoreCase(String keyword);
}
