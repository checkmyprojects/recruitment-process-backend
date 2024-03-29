package com.recruit.recruitment.service;

import com.recruit.recruitment.models.Candidate;
import com.recruit.recruitment.repository.CandidateRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@Slf4j
public class CandidateServiceImpl implements CandidateService {

    private final CandidateRepo candidateRepo;

    public CandidateServiceImpl(CandidateRepo candidateRepo) {
        this.candidateRepo = candidateRepo;
    }

    @Override
    public List<Candidate> listAllCandidates() {
        return candidateRepo.findAll();
    }

    @Override
    public Candidate saveCandidate(Candidate candidate) {
        return candidateRepo.save(candidate);
    }

    @Override
    public void deleteCandidateById(Long id) { candidateRepo.deleteById(id); }

    @Override
    public Candidate findById(Long id) {
        return candidateRepo.findById(id).orElseThrow(() -> new RuntimeException("Candidate not found"));
    }
}
