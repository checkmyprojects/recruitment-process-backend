package com.recruit.recruitment.service;

import com.recruit.recruitment.models.Selection;
import com.recruit.recruitment.repository.SelectionRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;

import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
class SelectionServiceImplTest {

    @Mock
    private SelectionRepo selectionRepo;

    private SelectionServiceImpl underTest;



    @BeforeEach
    void setUp() {
        underTest = new SelectionServiceImpl(selectionRepo);
    }

    @Test
    void listAll() {

    }

    @Test
    void save() {
         }

    @Test
    void deleteSelectionById() {

        underTest.deleteSelectionById(1L);
        verify(selectionRepo).deleteById(1L);

    }
}