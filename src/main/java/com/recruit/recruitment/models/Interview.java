package com.recruit.recruitment.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
    @JsonBackReference
    private Candidate candidate;

    @ManyToOne
    @JsonBackReference
    private AppUser interviewer;

    @OneToOne
    //@JsonIgnoreProperties({"interviews"})
    @JsonBackReference
    private Selection selection;


    private String feedback;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date interview_date, creation_date;

    public Interview(){}

    public Interview(Date interview_date, Date creation_date)
    {
        this.interview_date = interview_date;
        this.creation_date = creation_date;
        this.feedback = "";
    }

    public Interview(Candidate candidate, AppUser interviewer, Selection selection, String feedback, Date interview_date, Date creation_date) {
        this.candidate = candidate;
        this.interviewer = interviewer;
        this.selection = selection;
        this.feedback = feedback;
        this.interview_date = interview_date;
        this.creation_date = creation_date;
    }

    /*
    public Interview(Candidate candidate, AppUser interviewer, Selection selection, String feedback, Date interview_date) {
        this.candidate = candidate;
        this.interviewer = interviewer;
        this.selection = selection;
        this.feedback = feedback;
        this.interview_date = interview_date;
        this.creation_date = new Date();
    }

     */

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