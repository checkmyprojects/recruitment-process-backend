package com.recruit.recruitment.controller;

import com.recruit.recruitment.models.Selection;
import com.recruit.recruitment.service.SelectionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/selection")
@RestController
public class SelectionController {

    private final SelectionService selectionService;

    public SelectionController(SelectionService selectionService) {
        this.selectionService = selectionService;
    }

    @GetMapping("/list")
    ResponseEntity<List<Selection>> listAll(){
        System.out.println("List All Selection Processes");
        return ResponseEntity.ok().body(selectionService.listAll());
    }

    @PostMapping("/new")
    ResponseEntity<Selection> saveSelection(@RequestBody Selection selection){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/selection/new").toUriString());
        System.out.println("Saving New Selection Process");
        return ResponseEntity.created(uri).body(selectionService.save(selection));
    }

    @PutMapping("/edit")
    ResponseEntity<Selection> editSelection(@RequestBody Selection selection){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/selection/edit").toUriString());
        System.out.println("Updating selection with ID: " + selection.getId());
        return ResponseEntity.created(uri).body(selectionService.save(selection));
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<Void> deleteSelectionById(@PathVariable Long id){
        System.out.println("Deleting Selection Process with ID: " + id);
        selectionService.deleteSelectionById(id);
        return ResponseEntity.noContent().build();
    }

}
