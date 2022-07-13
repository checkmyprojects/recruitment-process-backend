package com.recruit.recruitment.repository;

import com.recruit.recruitment.models.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepo extends JpaRepository<Candidate, Long> {

}
