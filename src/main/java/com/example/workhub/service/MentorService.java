package com.example.workhub.service;

import com.example.workhub.entity.Mentor;
import java.util.List;

public interface MentorService {

  Mentor createMentor(Mentor mentor);

  Mentor updateMentor(Long id, Mentor mentor);

  void deleteMentor(Long id);

  Mentor getMentor(Long id);

  List<Mentor> getAllMentors();

  List<Mentor> searchMentors(String keyword);
}
