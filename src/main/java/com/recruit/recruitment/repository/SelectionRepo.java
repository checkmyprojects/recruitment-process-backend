package com.recruit.recruitment.repository;

import com.recruit.recruitment.models.Selection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SelectionRepo extends JpaRepository<Selection, Long> {
}
