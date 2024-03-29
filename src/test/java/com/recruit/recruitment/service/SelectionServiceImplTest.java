package com.recruit.recruitment.service;

import com.recruit.recruitment.models.Selection;
import com.recruit.recruitment.repository.SelectionRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.BDDMockito.given;
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
        underTest.listAll();
        verify(selectionRepo).findAll();
    }

    @Test
    void save() {
        Selection selection = new Selection();
        underTest.save(selection);
        verify(selectionRepo).save(selection);

    }

    @Test
    void deleteSelectionById() {

        underTest.deleteSelectionById(1L);
        verify(selectionRepo).deleteById(1L);

    }

    @Test
    void findById() {
        Selection selection = new Selection();
        selection.setId(1L);
        given(selectionRepo.findById(selection.getId())).willReturn(Optional.of(selection));
        underTest.findById(selection.getId());
        verify(selectionRepo).findById(selection.getId());
    }
}