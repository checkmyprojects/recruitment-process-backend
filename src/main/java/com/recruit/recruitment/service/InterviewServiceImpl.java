package com.recruit.recruitment.service;

import com.recruit.recruitment.models.Interview;
import com.recruit.recruitment.repository.InterviewRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@Slf4j
public class InterviewServiceImpl implements InterviewService{

    private final InterviewRepo interviewRepo;

    public InterviewServiceImpl(InterviewRepo interviewRepo) {
        this.interviewRepo = interviewRepo;
    }

    @Override
    public List<Interview> listAll() {
        return interviewRepo.findAll();
    }

    @Override
    public Interview save(Interview interview) {
        return interviewRepo.save(interview);
    }

    @Override
    public void deleteInterviewById(Long id) {
        interviewRepo.deleteById(id);
    }

    @Override
    public Interview findById(Long id) {
        return interviewRepo.findById(id).orElseThrow(() -> new RuntimeException("Interview not found"));
    }
}
