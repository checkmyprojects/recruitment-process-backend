package com.recruit.recruitment.repository;


import com.recruit.recruitment.models.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateRepo extends JpaRepository<Candidate, Long> {
    void deleteCandidateById(Long id);
}
