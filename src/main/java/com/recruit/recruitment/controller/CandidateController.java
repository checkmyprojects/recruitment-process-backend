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
}


