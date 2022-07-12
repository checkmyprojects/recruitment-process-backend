package com.recruit.recruitment.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "selections")
public class Selection
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @OneToOne
    private AppUser created_by;

    @NotBlank
    private Date start_date, end_date;

    @NotBlank
    private String name, description, requirements, location, sector;

    @NotBlank
    @Size(max = 10)
    private String status, priority;

    @NotBlank
    private boolean remote;

    public Selection(){}

    public Selection(AppUser created_by, Date start_date, Date end_date, String name, String description, String requirements, String location, String sector, String status, String priority, boolean remote)
    {
        this.created_by = created_by;
        this.start_date = start_date;
        this.end_date = end_date;
        this.name = name;
        this.description = description;
        this.requirements = requirements;
        this.location = location;
        this.sector = sector;
        this.status = status;
        this.priority = priority;
        this.remote = remote;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AppUser getCreated_by() {
        return created_by;
    }

    public void setCreated_by(AppUser created_by) {
        this.created_by = created_by;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public boolean isRemote() {
        return remote;
    }

    public void setRemote(boolean remote) {
        this.remote = remote;
    }
}