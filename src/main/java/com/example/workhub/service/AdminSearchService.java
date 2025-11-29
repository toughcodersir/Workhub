package com.example.workhub.service;

import com.example.workhub.entity.SearchResponse;

public interface AdminSearchService {
  SearchResponse globalSearch(String keyword);
}
