package com.recruit.recruitment.models;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "candidates")
public class Candidate
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 20)
    private String name, surname;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @NotBlank
    private String skills, studies, location;


    private long experience;


    private boolean hired;

    @OneToMany(mappedBy = "candidate")
    private Set<Interview> interviews;

    public Candidate(){}

    public Candidate(String name, String surname, String email, String skills, String studies, String location, long experience)
    {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.skills = skills;
        this.studies = studies;
        this.location = location;
        this.experience = experience;
        this.hired = false;
    }

    public Long getId() {
        return id;
    }

    public Set<Interview> getInterviews() {
        return interviews;
    }

    public void setInterviews(Set<Interview> interviews) {
        this.interviews = interviews;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getStudies() {
        return studies;
    }

    public void setStudies(String studies) {
        this.studies = studies;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public long getExperience() {
        return experience;
    }

    public void setExperience(long experience) {
        this.experience = experience;
    }

    public boolean isHired() {
        return hired;
    }

    public void setHired(boolean hired) {
        this.hired = hired;
    }
}