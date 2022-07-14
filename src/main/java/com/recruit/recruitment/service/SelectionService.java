package com.recruit.recruitment.service;

import com.recruit.recruitment.models.Selection;

import java.util.List;

public interface SelectionService {

    List<Selection> listAll();
    Selection save(Selection selection);
    void deleteSelectionById(Long id);
    Selection findById(Long id);
}
