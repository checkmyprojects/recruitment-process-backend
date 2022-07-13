package com.recruit.recruitment.controller;

import com.recruit.recruitment.models.Candidate;
import com.recruit.recruitment.service.CandidateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/candidate")
public class CandidateController {

    private final CandidateService candidateService;

    public CandidateController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @PostMapping("/new")
    public ResponseEntity<Candidate> saveCandidate(@RequestBody Candidate candidate){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/candidate/new").toUriString());
        System.out.println(candidate.getName());
        return ResponseEntity.created(uri).body(candidateService.saveCandidate(candidate));
    }

    /*
    @PostMapping("/food/save")
    public ResponseEntity<Food> saveFood(@RequestBody Food food){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/food/save").toUriString());
        return ResponseEntity.created(uri).body(foodService.addFood(food));
    }
     */

}
