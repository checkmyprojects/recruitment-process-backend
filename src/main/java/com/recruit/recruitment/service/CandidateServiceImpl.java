package com.recruit.recruitment.service;

import com.recruit.recruitment.models.Candidate;
import com.recruit.recruitment.repository.CandidateRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class CandidateServiceImpl implements CandidateService{

    private final CandidateRepo candidateRepo;

    @Override
    public Candidate saveCandidate(Candidate candidate) {
        return candidateRepo.save(candidate);
    }
}
