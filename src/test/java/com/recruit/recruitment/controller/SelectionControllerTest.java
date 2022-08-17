package com.recruit.recruitment.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.recruit.recruitment.models.Selection;
import com.recruit.recruitment.service.AppUserService;
import com.recruit.recruitment.service.SelectionService;
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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class SelectionControllerTest {

    @Mock
    private SelectionService selectionService;
    @Mock
    private AppUserService appUserService;

    @InjectMocks
    private SelectionController selectionController;

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

    Selection selection;
    Selection selection2;
    Selection selection3;
    List<Selection> selectionList = new ArrayList<>();

    @BeforeEach
    public void setup(){
        selection = new Selection(1L, null, new Date(), new Date(), "Name", "Description", "Req", "Location", "Sector", "Status", "Priority", 1231231L, true, null);
        selection2 = new Selection(2L, null, new Date(), new Date(), "Name", "Description", "Req", "Location", "Sector", "Status", "Priority", 1231231L, true, null);
        selection3 = new Selection(3L, null, new Date(), new Date(), "Name", "Description", "Req", "Location", "Sector", "Status", "Priority", 1231231L, true, null);
        selectionList.add(selection);
        selectionList.add(selection2);
        selectionList.add(selection3);
        mockMvc = MockMvcBuilders.standaloneSetup(selectionController).build();
    }

    @AfterEach
    void tearDown() {
        selection = null;
        selection2 = null;
        selection3 = null;
        selectionList = null;
    }

    @Test
    void listAll() throws Exception {

        when(selectionService.listAll()).thenReturn(selectionList);
        mockMvc.perform((MockMvcRequestBuilders.get("/api/selection/list")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(selectionList))))
                .andDo(MockMvcResultHandlers.print());
        verify(selectionService).listAll();
        verify(selectionService, times(1)).listAll();
    }

    @Test
    void saveSelection() throws Exception {
        //when(selectionService.save(any())).thenReturn(selection);
        mockMvc.perform((MockMvcRequestBuilders.post("/api/selection/new")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(selection))))
                        .andExpect(status().isBadRequest());
        //verify(selectionService).save(selection);
        verify(selectionService, times(0)).save(selection);
    }

    @Test
    void editSelection() {
    }

    @Test
    void deleteSelectionById() {
    }
}