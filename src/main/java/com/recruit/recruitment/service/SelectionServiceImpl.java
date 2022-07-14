package com.recruit.recruitment.service;

import com.recruit.recruitment.models.Selection;
import com.recruit.recruitment.repository.SelectionRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@Slf4j
public class SelectionServiceImpl implements SelectionService{

    private final SelectionRepo selectionRepo;

    public SelectionServiceImpl(SelectionRepo selectionRepo) {
        this.selectionRepo = selectionRepo;
    }

    @Override
    public List<Selection> listAll() {
        return selectionRepo.findAll();
    }

    @Override
    public Selection save(Selection selection) {
        return selectionRepo.save(selection);
    }

    @Override
    public void deleteSelectionById(Long id) {
        selectionRepo.deleteById(id);

    }

    @Override
    public Selection findById(Long id) {
        return selectionRepo.findById(id).orElseThrow(() -> new RuntimeException("Selection Process not found"));
    }
}
