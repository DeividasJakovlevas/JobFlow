package org.example.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class JobApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String email;
    private List<String> skills;

    @ManyToOne
    @JoinColumn(name = "job_description_id")
    private JobListing jobListing;

    public JobApplication() {
    }

    public JobApplication(Long id, String email, List<String> skills, JobListing jobListing) {
        this.id = id;
        this.email = email;
        this.skills = skills;
        this.jobListing = jobListing;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public JobListing getJobListing() {
        return jobListing;
    }

    public void setJobListing(JobListing jobListing) {
        this.jobListing = jobListing;
    }
}
