package com.recruit.recruitment.service;

import com.recruit.recruitment.models.Interview;
import com.recruit.recruitment.payload.request.StatisticInterview;
import com.recruit.recruitment.repository.InterviewRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@Slf4j
public class InterviewServiceImpl implements InterviewService{

    private final InterviewRepo interviewRepo;

    public InterviewServiceImpl(InterviewRepo interviewRepo) {
        this.interviewRepo = interviewRepo;
    }

    @Override
    public List<Interview> listAll() {
        return interviewRepo.findAll();
    }

    @Override
    public Interview save(Interview interview) {
        return interviewRepo.save(interview);
    }

    @Override
    public void deleteInterviewById(Long id) {
        interviewRepo.deleteById(id);
    }

    @Override
    public Interview findById(Long id) {
        return interviewRepo.findById(id).orElseThrow(() -> new RuntimeException("Interview not found"));
    }

    public List<Integer> getRange(StatisticInterview stats)
    {
        List<Integer> r = new ArrayList<>();
        r.add(0);
        List<Interview> interviewList = listAll();
        for (int x = stats.fromYear; x <= stats.toYear; ++x)
            for (int y = (x == stats.fromYear ? stats.fromMonth : 1); y <= (x == stats.toYear ? stats.toMonth : 12); ++y) {
                int rr = 0;
                for (Interview i : interviewList) {
                    int mi = i.getCreation_date().getYear();
                    if (mi >= x && mi <= x) {
                        mi = i.getCreation_date().getMonthValue();
                        if (mi >= y && mi <= y)
                            ++rr;
                    }
                }
                r.add(rr);
            }
        return r;
    }
}
