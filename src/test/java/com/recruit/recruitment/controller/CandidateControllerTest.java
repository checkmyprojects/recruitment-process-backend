package com.recruit.recruitment.controller;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;


@AutoConfigureMockMvc
@WebAppConfiguration
@SpringBootTest
class CandidateControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext applicationContext;

    @Before("")
    public void init() throws Exception {
        MockitoAnnotations.initMocks(this);

        // @formatter:off
        this.mockMvc = webAppContextSetup(this.applicationContext)
                .alwaysDo(print())
                .build();
        // @formatter:on

        CandidateController candidateController = this.applicationContext.getBean(CandidateController.class);

        // REPLACE YOUR SERVICES WITH the MOCKED ONES HERE
        //ReflectionTestUtils.setField(emailController, "byEmail", this.byEmail);
    }
    @Test
    void allList() {
        try {
            mockMvc.perform(MockMvcRequestBuilders.get("/api/candidate/list").accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("$[*].name").exists()).andExpect(MockMvcResultMatchers.jsonPath("$.[*].id").isNotEmpty());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void saveCandidate() {
    }

    @Test
    void deleteCandidateById() {
    }

    @Test
    void editCandidate() {
    }
}