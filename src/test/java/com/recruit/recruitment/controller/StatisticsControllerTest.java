package com.recruit.recruitment.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.recruit.recruitment.service.CandidateService;
import com.recruit.recruitment.service.InterviewService;
import com.recruit.recruitment.service.SelectionService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(MockitoExtension.class)
public class StatisticsControllerTest
{
    @Mock
    private CandidateService candidateService;

    @Mock
    private InterviewService interviewService;

    @Mock
    private SelectionService selectionService;

    @InjectMocks
    private StatisticsController statsController;

    @Autowired
    private MockMvc mock;

    public static String asJsonString(final Object obj)
    {
        try
        {
            return new ObjectMapper().writeValueAsString(obj);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }


}