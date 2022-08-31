package com.recruit.recruitment.service;

import com.recruit.recruitment.models.Interview;
import com.recruit.recruitment.models.Selection;
import com.recruit.recruitment.payload.request.StatisticInterview;
import com.recruit.recruitment.payload.response.CandidatesPerMonth;
import com.recruit.recruitment.repository.SelectionRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
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

    public Integer countActive()
    {
        Integer counter = 0;
        List<Selection> selections = selectionRepo.findAll();
        for(Selection s : selections)
            if(s.getStatus().equals("Activo"))
                ++counter;
        return counter;
    }

    public Integer averageHiringTimeInDays()
    {
        Integer counter = 0;
        List<Selection> selections = selectionRepo.findAll();
        for(Selection s : selections)
            counter += (int)(((s.getEnd_date() != null ? s.getEnd_date().getTime() : s.getStart_date().getTime()) - s.getStart_date().getTime()) / 86400000);
        return counter;
    }

    public CandidatesPerMonth getCandidatesPerMonth(long id)
    {
        CandidatesPerMonth cpm = new CandidatesPerMonth();
        cpm.months.add("");
        cpm.candidates.add(0);
        Selection s = findById(id);
        List<Interview> interviewList = s.getInterviews().stream().toList();
        final LocalDateTime start = s.getStart_date().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        LocalDateTime aux = start;
        aux.minusMonths(1);
        final LocalDateTime end = s.getEnd_date() != null?s.getEnd_date().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime():aux;
        final int fromYear = start.getYear(), toYear = end.getYear();
        for (int x = fromYear; x <= toYear; ++x)
            for (int y = (x == fromYear ? start.getMonthValue() : 1); y <= (x == toYear ? end.getMonthValue() : 12); ++y)
            {
                switch(y)
                {
                    case 1:
                        cpm.months.add("Ene " + x);
                        break;
                    case 2:
                        cpm.months.add("Feb");
                        break;
                    case 3:
                        cpm.months.add("Mar");
                        break;
                    case 4:
                        cpm.months.add("Abr");
                        break;
                    case 5:
                        cpm.months.add("May");
                        break;
                    case 6:
                        cpm.months.add("Jun");
                        break;
                    case 7:
                        cpm.months.add("Jul");
                        break;
                    case 8:
                        cpm.months.add("Ago");
                        break;
                    case 9:
                        cpm.months.add("Sep");
                        break;
                    case 10:
                        cpm.months.add("Oct");
                        break;
                    case 11:
                        cpm.months.add("Nov");
                        break;
                    case 12:
                        cpm.months.add("Dic");
                        break;
                }
                int rr = 0;
                for (Interview i : interviewList)
                    if(i.getInterview_date().getYear() == x && i.getInterview_date().getMonthValue() == y)
                    //if (i.getSelection().getStart_date().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime().getYear() == x)
                        //if (i.getSelection().getStart_date().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime().getMonthValue() == y)
                                ++rr;
                cpm.candidates.add(rr);
            }
        return cpm;
    }
}
