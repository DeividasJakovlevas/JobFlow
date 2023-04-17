package org.example.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class JobListing {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "description", length = 4000)
    private String description;

    private int monthlySalary;
    @JoinColumn(name = "company_id")
    @ManyToOne
    private Company company;

//    @Column(name = "seen_emails", length = 4000)
    @ElementCollection
    private List<String> seenEmails;

    private List<String> skillsRequired;

    public JobListing() {
    }

    public JobListing(Long id, String description, int monthlySalary, Company company, List<String> seenEmails, List<String> skillsRequired) {
        this.id = id;
        this.description = description;
        this.monthlySalary = monthlySalary;
        this.company = company;
        this.seenEmails = seenEmails;
        this.skillsRequired = skillsRequired;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(int monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<String> getSeenEmails() {
        return seenEmails;
    }

    public void setSeenEmails(List<String> seenEmails) {
        this.seenEmails = seenEmails;
    }

    public List<String> getSkillsRequired() {
        return skillsRequired;
    }

    public void setSkillsRequired(List<String> skillsRequired) {
        this.skillsRequired = skillsRequired;
    }
}
