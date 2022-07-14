package com.recruit.recruitment.service;

import com.recruit.recruitment.models.Candidate;

import java.util.List;

public interface CandidateService {

    List<Candidate> listAllCandidates ();
    Candidate saveCandidate (Candidate candidate);
    void deleteCandidateById (Long id);
    Candidate findById(Long id);
}
