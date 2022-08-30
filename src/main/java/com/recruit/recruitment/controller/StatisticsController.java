package com.recruit.recruitment.controller;

import com.recruit.recruitment.models.Interview;
import com.recruit.recruitment.payload.request.StatisticInterview;
import com.recruit.recruitment.payload.response.CandidatesPerMonth;
import com.recruit.recruitment.payload.response.GeneralStatistics;
import com.recruit.recruitment.service.CandidateServiceImpl;
import com.recruit.recruitment.service.InterviewServiceImpl;
import com.recruit.recruitment.service.SelectionServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/statistics")
public class StatisticsController
{
    final private InterviewServiceImpl interview;

    final private CandidateServiceImpl candidate;

    final private SelectionServiceImpl selection;

    public StatisticsController(InterviewServiceImpl interview, CandidateServiceImpl candidate, SelectionServiceImpl selection)
    {
        this.interview = interview;
        this.candidate = candidate;
        this.selection = selection;
    }

    @GetMapping("general")
    ResponseEntity<GeneralStatistics> general()
    {
        GeneralStatistics gs = new GeneralStatistics();
        gs.totalCandidates = candidate.listAllCandidates().size();
        gs.totalActiveSelections = selection.countActive();
        gs.totalAverageHiringTime = selection.averageHiringTimeInDays();
        return ResponseEntity.ok().body(gs);
    }

    @PostMapping("/interviews/range")
    ResponseEntity<List<Integer>> range(@RequestBody StatisticInterview stats)
    {
        return ResponseEntity.ok().body(interview.getRange(stats));
    }

    @PostMapping("/selection/applicants")
    ResponseEntity<CandidatesPerMonth> applicants(@RequestBody Long selection_id)
    {
        return ResponseEntity.ok().body(selection.getCandidatesPerMonth(selection_id));
    }
}