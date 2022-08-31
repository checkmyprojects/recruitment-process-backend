package com.recruit.recruitment.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.recruit.recruitment.models.Candidate;
import com.recruit.recruitment.service.CandidateService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;


//@AutoConfigureMockMvc
//@WebAppConfiguration
//@SpringBootTest
@ExtendWith(MockitoExtension.class)
class CandidateControllerTest {

//    @Autowired
//    private MockMvc mockMvc;

//    @Autowired
//    private WebApplicationContext applicationContext;

//    @Before("")
//    public void init() throws Exception {
//        MockitoAnnotations.initMocks(this);
//
//        // @formatter:off
//        this.mockMvc = webAppContextSetup(this.applicationContext)
//                .alwaysDo(print())
//                .build();
//        // @formatter:on
//
//        CandidateController candidateController = this.applicationContext.getBean(CandidateController.class);
//
//        // REPLACE YOUR SERVICES WITH the MOCKED ONES HERE
//        //ReflectionTestUtils.setField(emailController, "byEmail", this.byEmail);
//    }

    @Mock
    private CandidateService candidateService;

    @InjectMocks
    private CandidateController candidateController;

    @Autowired
    private MockMvc mockMvc;

    public static String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            final String jsonContent = mapper.writeValueAsString(obj);
            return jsonContent;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    Candidate candidate1;
    Candidate candidate2;
    Candidate candidate3;
    Candidate candidateWithoutId;
    List<Candidate> candidateList = new ArrayList<>();


    @BeforeEach
    public void setup(){
        candidate1 = new Candidate(1L, "Candidato 1", "Apellido 1", "email1@mail.com", "skill", "studies", "location", 5, false, "state", "notes", null);
        candidate2 = new Candidate(1L, "Candidato 2", "Apellido 2", "email2@mail.com", "skill", "studies", "location", 5, false, "state", "notes", null);
        candidate3 = new Candidate(1L, "Candidato 3", "Apellido 3", "email3@mail.com", "skill", "studies", "location", 5, false, "state", "notes", null);
        candidateWithoutId = new Candidate("Candidato 3", "Apellido 3", "email3@mail.com", "skill", "studies", "location", 5, false, "state", "notes");

        candidateList.add(candidate1);
        candidateList.add(candidate2);
        candidateList.add(candidate3);

        mockMvc = MockMvcBuilders.standaloneSetup(candidateController).build();
    }

    @Test
    void allList() throws Exception {
//        try {
//            mockMvc.perform(MockMvcRequestBuilders.get("/api/candidate/list").accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("$[*].name").exists()).andExpect(MockMvcResultMatchers.jsonPath("$.[*].id").isNotEmpty());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        when(candidateService.listAllCandidates()).thenReturn(candidateList);
        mockMvc.perform((MockMvcRequestBuilders.get("/api/candidate/list")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(candidateList))))
                .andDo(MockMvcResultHandlers.print());
        verify(candidateService).listAllCandidates();
        verify(candidateService, times(1)).listAllCandidates();
    }

    @Test
    void saveCandidate() throws Exception {
        mockMvc.perform((MockMvcRequestBuilders.post("/api/candidate/new")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(candidateWithoutId))))
                .andExpect(status().isCreated());
        //verify(selectionService).save(selection);
        verify(candidateService, times(1)).saveCandidate(any());
    }

    @Test
    void deleteCandidateById() throws Exception {
        mockMvc.perform((MockMvcRequestBuilders.delete("/api/candidate/delete/"+candidate1.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(candidate1))))
                .andExpect(status().isNoContent());
        //verify(selectionService).save(selection);
        verify(candidateService, times(1)).deleteCandidateById(any());
    }

    @Test
    void editCandidate() throws Exception {
        when(candidateService.saveCandidate(candidate1)).thenReturn(candidate1);
        when(candidateService.findById(candidate1.getId())).thenReturn(candidate1);
        mockMvc.perform((MockMvcRequestBuilders.put("/api/candidate/edit")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(candidate1))))
                .andExpect(status().isCreated());
        verify(candidateService, times(1)).findById(candidate1.getId());
        verify(candidateService, times(1)).saveCandidate(candidate1);
    }
}