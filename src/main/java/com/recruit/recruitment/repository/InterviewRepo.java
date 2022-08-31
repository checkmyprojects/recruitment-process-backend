package com.recruit.recruitment.repository;


import com.recruit.recruitment.models.Interview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterviewRepo extends JpaRepository<Interview, Long> {

}
