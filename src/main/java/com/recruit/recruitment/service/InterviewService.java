package com.recruit.recruitment.service;

import com.recruit.recruitment.models.Interview;

import java.util.List;

public interface InterviewService {

    List<Interview> listAll();
    Interview save(Interview interview);
    void deleteInterviewById(Long id);
    Interview findById(Long id);
}
