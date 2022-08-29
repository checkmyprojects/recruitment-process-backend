package com.recruit.recruitment.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.recruit.recruitment.models.Interview;
import com.recruit.recruitment.models.Selection;
import com.recruit.recruitment.service.AppUserServiceImpl;
import com.recruit.recruitment.service.CandidateServiceImpl;
import com.recruit.recruitment.service.InterviewServiceImpl;
import com.recruit.recruitment.service.SelectionServiceImpl;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

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
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
class InterviewControllerTest {

    @MockBean
    private InterviewServiceImpl interviewService;
    @MockBean
    private AppUserServiceImpl appUserService;
    @MockBean
    private SelectionServiceImpl selectionService;
    @MockBean
    private CandidateServiceImpl candidateService;

    @Autowired
    private MockMvc mockMvc;

    private InterviewController interviewController = new InterviewController(interviewService, appUserService, selectionService, candidateService);

    @Test
    void allList() throws Exception {
        List<Interview> interviewList= new ArrayList<>();
        Interview interview= new Interview(1L, null, null, null, "Good Good", null, null);
        interviewList.add(interview);

        when(interviewService.listAll()).thenReturn(interviewList);
        mockMvc.perform((MockMvcRequestBuilders.get("/api/interview/list")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(interviewList))))
                .andDo(MockMvcResultHandlers.print());
        verify(interviewService).listAll();
        verify(interviewService, times(1)).listAll();

    }

    @Test
    void findById() throws Exception {
        Interview interview= new Interview(1L, null, null, null, "Good Good", null, null);

        when(interviewService.findById(any())).thenReturn(interview);
        mockMvc.perform((MockMvcRequestBuilders.get("/api/interview/id/"+interview.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(interview))))
                .andDo(MockMvcResultHandlers.print());
        verify(interviewService).findById(interview.getId());
        verify(interviewService, times(1)).findById(interview.getId());
    }

    @Test
    void saveInterview() {
    }

    @Test
    void editInterview() {
    }

    @Test
    void leaveFeedback() throws Exception {
        Interview interview= new Interview(1L, null, null, null, "Good Good", null, null);
        when(interviewService.findById(any())).thenReturn(interview);
        mockMvc.perform((MockMvcRequestBuilders.put("/api/interview/feedback/"+interview.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString("Feedback"))))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isCreated());
        verify(interviewService).findById(1L);
        verify(interviewService, times(1)).findById(1L);
        verify(interviewService).save(interview);
        verify(interviewService, times(1)).save(interview);
    }

    @Test
    void changeDate() throws Exception {
        Interview interview= new Interview(1L, null, null, null, "Good Good", null, null);
        when(interviewService.findById(any())).thenReturn(interview);
        mockMvc.perform((MockMvcRequestBuilders.put("/api/interview/changedate/")
                        .param("interviewid", "1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString("2022-12-12T05:05:05"))))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());;
        verify(interviewService).findById(1L);
        verify(interviewService, times(1)).findById(1L);
    }

    @Test
    void deleteInterviewById() throws Exception {
        Interview interview= new Interview(1L, null, null, null, "Good Good", null, null);
        mockMvc.perform((MockMvcRequestBuilders.delete("/api/interview/delete/"+interview.getId())
                        .contentType(MediaType.APPLICATION_JSON)))
                .andDo(MockMvcResultHandlers.print());
        verify(interviewService).deleteInterviewById(interview.getId());
        verify(interviewService, times(1)).deleteInterviewById(interview.getId());
    }

    private String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            final String jsonContent = mapper.writeValueAsString(obj);
            return jsonContent;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}