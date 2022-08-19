package com.recruit.recruitment.controller;

import com.recruit.recruitment.models.Interview;
import com.recruit.recruitment.payload.request.StatisticInterview;
import com.recruit.recruitment.service.InterviewServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/statistics")
public class StatisticsController
{
    final private InterviewServiceImpl interview;

    public StatisticsController(InterviewServiceImpl interview)
    {
        this.interview = interview;
    }

    @GetMapping("/interviews/range")
    ResponseEntity<List<Interview>> range(@RequestBody StatisticInterview stats)
    {
        List<Interview> interviewList = interview.listAll(), r = new ArrayList<>();
        for(Interview i : interviewList)
        {
            final int mi = i.getCreation_date().getMonthValue();
            if (mi >= stats.from && mi <= stats.to)
                r.add(i);
        }
        return ResponseEntity.ok().body(r);
    }

    @GetMapping("/interviews/applicants")
    ResponseEntity<?> applicants(@RequestBody Long interview_id)
    {
        Interview in = interview.findById(interview_id);
        if(in == null)
            return ResponseEntity.badRequest().body("No se pudo encontrar la entrevista con el ID: " + interview_id.toString());
        return ResponseEntity.ok().body(in.getSelection().getInterviews().size());
    }

    @GetMapping("/interviews/year")
    ResponseEntity<List<Interview>> sortedYear(@RequestBody int year)
    {
        List<Interview> interviewList = interview.listAll(), r = new ArrayList<>();
        for(Interview i : interviewList)
            if (i.getCreation_date().getYear() == year)
                r.add(i);
        r.sort(Comparator.comparing(Interview::getCreation_date));
        return ResponseEntity.ok().body(r);
    }
}