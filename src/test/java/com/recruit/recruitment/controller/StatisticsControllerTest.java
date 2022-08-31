package com.recruit.recruitment.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.recruit.recruitment.models.AppUser;
import com.recruit.recruitment.models.Candidate;
import com.recruit.recruitment.models.Interview;
import com.recruit.recruitment.models.Selection;
import com.recruit.recruitment.payload.response.GeneralStatistics;
import com.recruit.recruitment.repository.InterviewRepo;
import com.recruit.recruitment.repository.SelectionRepo;
import com.recruit.recruitment.service.InterviewServiceImpl;
import com.recruit.recruitment.service.SelectionServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StatisticsControllerTest
{
    @Mock
    private SelectionRepo srepo;

    @Mock
    private InterviewRepo irepo;

    @Mock
    private InterviewServiceImpl interview;

    @Mock
    private SelectionServiceImpl selection;

    @InjectMocks
    private StatisticsController controller;

    @Autowired
    private MockMvc mock;

    private static String asJsonString(final Object obj)
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

    List<Interview> interviews = new ArrayList<>();

    AppUser people;

    Interview interview1;

    Candidate candidate1;

    Selection selection1;

    GeneralStatistics gs;

    @BeforeEach
    public void setup()
    {
        selection = new SelectionServiceImpl(srepo);

        gs = new GeneralStatistics();
        gs.totalAverageHiringTime = 100;
        gs.totalActiveSelections = 100;
        gs.totalCandidates = 100;
        people = new AppUser("NTT", "People", "nttpeople@gmail.com", "nttdata");
        candidate1 = new Candidate(1L, "Pedro", "Alfonso", "pedroalfonso@gmail.com", "Java Angular", "CS", "Madrid", 2, false, "Activo", "Soy pedrito", null);
        selection1 = new Selection(1L, null, new Date(), new Date(), "Name", "Description", "Req", "Location", "Sector", "Status", "Priority", 1231231L, true, null);
        interview1 = new Interview(1L, candidate1, people, selection1, "Activo", "Pedrito crack", LocalDateTime.MAX, LocalDateTime.now());
        interviews.add(interview1);
        candidate1.setInterviews(interviews.stream().collect(Collectors.toSet()));
        selection1.setInterviews(interviews.stream().collect(Collectors.toSet()));
        mock = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @AfterEach
    void tearDown()
    {
        people = null;
        candidate1 = null;
        selection1 = null;
        interview1 = null;
        interviews = null;
        gs = null;
    }

    @Test
    void getDefault() throws Exception
    {
        when(selection.getStats()).thenReturn(gs);
        mock.perform((MockMvcRequestBuilders.get("/api/statistics/general").contentType(MediaType.APPLICATION_JSON).content(asJsonString(gs)))).andDo(MockMvcResultHandlers.print());
        verify(controller).general();
        verify(controller, times(1)).general();
    }


}