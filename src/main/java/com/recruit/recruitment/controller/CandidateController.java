package com.recruit.recruitment.controller;

import com.recruit.recruitment.models.Candidate;
import com.recruit.recruitment.service.CandidateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/candidate")
@RestController
public class CandidateController {

    private final CandidateService candidateService;

    public CandidateController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @GetMapping("/list")
    ResponseEntity<List<Candidate>> allList(){
        return ResponseEntity.ok().body(candidateService.listAllCandidates());
    }

    @PostMapping("/new")
    ResponseEntity<Candidate> saveCandidate(@RequestBody Candidate candidate) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/candidate/new").toUriString());
        System.out.println(candidate.getName());
        return ResponseEntity.created(uri).body(candidateService.saveCandidate(candidate));
    }
    /*
    @DeleteMapping("/delete/{id}")
    ResponseEntity<Void> deleteCandidateById(@PathVariable Long id){
        candidateService,deleteCandidateById(id);
        return  ResponseEntity.noContent().build();
    }*/


    /* @DeleteMapping("/delete/{id}")
     ResponseEntity<Void> deleteSelectionById(@PathVariable Long id){
         System.out.println("Deleting Selection Process with ID: " + id);
         selectionService.deleteSelectionById(id);
         return ResponseEntity.noContent().build();
     }    */
    @PutMapping("/edit")
    public ResponseEntity<Candidate> editCandidate(@RequestBody Candidate candidate){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/candidate/save").toUriString());
        // find DB candidate and create a temp one to edit it
        Candidate candidateToEdit=candidateService.findById((candidate.getId()));
        // Change candidateToEdit data with the data we get from the PUT request
        candidateToEdit.setName(candidate.getName());
        candidateToEdit.setSurname(candidate.getSurname());
        candidateToEdit.setEmail(candidate.getEmail());
        candidateToEdit.setExperience(candidate.getExperience());
        candidateToEdit.setSkills(candidate.getSkills());
        candidateToEdit.setLocation(candidate.getLocation());
        candidateToEdit.setState(candidate.getState());
        candidateToEdit.setStudies(candidate.getStudies());

        return ResponseEntity.created(uri).body(candidateService.saveCandidate(candidateToEdit));
    }
}


