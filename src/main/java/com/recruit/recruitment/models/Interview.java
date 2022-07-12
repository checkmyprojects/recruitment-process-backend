package com.recruit.recruitment.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "interviews")
public class Interview
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Candidate candidate;

    @OneToOne
    private AppUser interviewer;

    @OneToOne
    private Selection selection;

    @NotBlank
    private String feedback;

    @NotBlank
    private Date interview_date, creation_date;

    public Interview(){}

    public Interview(Date interview_date, Date creation_date)
    {
        this.interview_date = interview_date;
        this.creation_date = creation_date;
        this.feedback = "";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public AppUser getInterviewer() {
        return interviewer;
    }

    public void setInterviewer(AppUser interviewer) {
        this.interviewer = interviewer;
    }

    public Selection getSelection() {
        return selection;
    }

    public void setSelection(Selection selection) {
        this.selection = selection;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public Date getInterview_date() {
        return interview_date;
    }

    public void setInterview_date(Date interview_date) {
        this.interview_date = interview_date;
    }

    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }
}