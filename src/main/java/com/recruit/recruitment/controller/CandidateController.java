package com.recruit.recruitment.controller;

import com.recruit.recruitment.models.Candidate;
import com.recruit.recruitment.service.CandidateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}


