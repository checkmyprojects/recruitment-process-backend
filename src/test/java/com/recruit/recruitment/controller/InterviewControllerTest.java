package com.recruit.recruitment.controller;

import com.recruit.recruitment.models.Interview;
import com.recruit.recruitment.service.AppUserServiceImpl;
import com.recruit.recruitment.service.CandidateServiceImpl;
import com.recruit.recruitment.service.InterviewServiceImpl;
import com.recruit.recruitment.service.SelectionServiceImpl;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.allOf;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

class InterviewControllerTest {

    private final InterviewServiceImpl interviewService = Mockito.mock(InterviewServiceImpl.class);
    private final AppUserServiceImpl appUserService = Mockito.mock(AppUserServiceImpl.class);
    private final SelectionServiceImpl selectionService = Mockito.mock(SelectionServiceImpl.class);
    private final CandidateServiceImpl candidateService = Mockito.mock(CandidateServiceImpl.class);

    private InterviewController interviewController = new InterviewController(interviewService, appUserService, selectionService, candidateService);

    @Test
    void allList() {
        List<Interview> interviewList= new ArrayList<>();
        InterviewController interviewController = new InterviewController(interviewService, appUserService, selectionService, candidateService);
        given(interviewService
                .listAll())
                .willReturn(interviewList);
        ResponseEntity<List<Interview>> response = interviewController
                .allList();

        then(interviewService)
                .should()
                .listAll();

        assertThat(response.getStatusCode())
                .isEqualTo(HttpStatus.OK);
    }

    @Test
    void findById() {
        Interview interview= new Interview(1L, null, null, null, "Good Good", LocalDateTime.now(), LocalDateTime.now());
        InterviewController interviewController = new InterviewController(interviewService, appUserService, selectionService, candidateService);
        given(interviewService
                .findById(interview.getId()))
                .willReturn(interview);

        ResponseEntity<Interview> response = interviewController
                .findById(interview.getId());

        then(interviewService)
                .should()
                .findById(interview.getId());

        assertThat(response.getStatusCode())
                .isEqualTo(HttpStatus.OK);
        //JSONAssert.assertEquals(interview);

        assertThat(response.getBody()).hasFieldOrProperty("feedback");
    }

    @Test
    void saveInterview() {
    }

    @Test
    void editInterview() {
    }

    @Test
    void leaveFeedback() {
    }

    @Test
    void changeDate() {
    }

    @Test
    void deleteInterviewById() {
    }
}