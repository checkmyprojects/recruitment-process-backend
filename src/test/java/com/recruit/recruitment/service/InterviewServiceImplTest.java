package com.recruit.recruitment.service;

import com.recruit.recruitment.models.Interview;
import com.recruit.recruitment.repository.InterviewRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class InterviewServiceImplTest {

    @Mock
    private InterviewRepo interviewRepo;

    private InterviewServiceImpl underTest;

    @BeforeEach
    void setUp() { underTest = new InterviewServiceImpl(interviewRepo);
    }

    @Test
    void listAll() {
        underTest.listAll();
        verify(interviewRepo).findAll();
    }

    @Test
    void save() {
        Interview interview = new Interview();
        underTest.save(interview);
        verify(interviewRepo).save(interview);
    }

    @Test
    void deleteInterviewById() {
        underTest.deleteInterviewById(1L);
        verify(interviewRepo).deleteById(1L);
    }

    @Test
    void findById() {
        underTest.findById(1L);
        verify(interviewRepo).findById(1L);
    }
}
