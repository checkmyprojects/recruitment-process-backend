package com.recruit.recruitment.models;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
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
    /*@JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id")*/
    @JsonIgnoreProperties({"interviews"}) // Remove interviews on JSON
    private Candidate candidate;

    @ManyToOne
   /* @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id")*/
    @JsonIgnoreProperties({"interviews"}) // Remove interviews on JSON
    private AppUser interviewer;

    @ManyToOne
    //@JsonIgnoreProperties({"interviews"})
//    @JsonIdentityInfo(
//            generator = ObjectIdGenerators.PropertyGenerator.class,
//            property = "id")
    @JsonIgnoreProperties({"interviews"}) // Remove interviews on JSON
    private Selection selection;

    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private String feedback;

    // HH:mm:ss is used for 24h time. doing hh:mm:ss will make it return in 12h format but without sending am/pm information
    @JsonFormat(pattern="yyyy-MM-dd / HH:mm:ss")
    private LocalDateTime interview_date, creation_date;

    public Interview(){}

    public Interview(LocalDateTime interview_date, LocalDateTime creation_date)
    {
        this.interview_date = interview_date;
        this.creation_date = creation_date;
        this.feedback = "";
    }

    public Interview(Candidate candidate, AppUser interviewer, Selection selection, String feedback, LocalDateTime interview_date, LocalDateTime creation_date) {
        this.candidate = candidate;
        this.interviewer = interviewer;
        this.selection = selection;
        this.feedback = feedback;
        this.interview_date = interview_date;
        this.creation_date = creation_date;
    }

    public Interview(Long id, Candidate candidate, AppUser interviewer, Selection selection, String feedback, LocalDateTime interview_date, LocalDateTime creation_date) {
        this.id = id;
        this.candidate = candidate;
        this.interviewer = interviewer;
        this.selection = selection;
        this.feedback = feedback;
        this.interview_date = interview_date;
        this.creation_date = creation_date;
    }

    public Interview(Candidate candidate, AppUser interviewer, Selection selection, String status, String feedback, LocalDateTime interview_date, LocalDateTime creation_date) {
        this.candidate = candidate;
        this.interviewer = interviewer;
        this.selection = selection;
        this.status = status;
        this.feedback = feedback;
        this.interview_date = interview_date;
        this.creation_date = creation_date;
    }

    public Interview(Long id, Candidate candidate, AppUser interviewer, Selection selection, String status, String feedback, LocalDateTime interview_date, LocalDateTime creation_date) {
        this.id = id;
        this.candidate = candidate;
        this.interviewer = interviewer;
        this.selection = selection;
        this.status = status;
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

    public LocalDateTime getInterview_date() {
        return interview_date;
    }

    public void setInterview_date(LocalDateTime interview_date) {
        this.interview_date = interview_date;
    }

    public LocalDateTime getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(LocalDateTime creation_date) {
        this.creation_date = creation_date;
    }
}