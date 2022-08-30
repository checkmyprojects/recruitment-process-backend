package com.recruit.recruitment.service;

import com.recruit.recruitment.models.Candidate;
import com.recruit.recruitment.repository.CandidateRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CandidateServiceImplTest {

    @Mock
    private CandidateRepo candidateRepo;

    private CandidateServiceImpl underTest;

    @BeforeEach
    void setUp() {
        underTest = new CandidateServiceImpl(candidateRepo);
    }

    @Test
    void listAllCandidates() {
        underTest.listAllCandidates();
        verify(candidateRepo).findAll();
    }

    @Test
    void saveCandidate() {
        Candidate candidate = new Candidate();
        underTest.saveCandidate(candidate);
        verify(candidateRepo).save(candidate);
    }

    @Test
    void deleteCandidateById() {
        underTest.deleteCandidateById(1L);
        verify(candidateRepo).deleteById(1L);
    }

    @Test
    void findById() {
        Candidate candidate = new Candidate();
        given(candidateRepo.findById(candidate.getId())).willReturn(Optional.of(candidate));
        underTest.findById(candidate.getId());
        verify(candidateRepo).findById(candidate.getId());
    }
}