package org.example.controller;

import org.example.exception.ResourceNotFoundException;
import org.example.model.Company;
import org.example.model.JobListing;
import org.example.service.JobListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/job-listings")
public class JobListingController {
    @Autowired
    private JobListingService jobListingService;

    private record JobListingResponse(long id,String companyName, float rating, String description, int salary, List<String> skills){}


    @GetMapping("/next")
    public ResponseEntity<JobListingResponse> getNextJobListing(@RequestParam("email") String email) {
        try {
            JobListing jobListing = jobListingService.getNextJobListing(email);
            if(jobListing.getSeenEmails()!=null){
                jobListing.getSeenEmails().forEach(System.out::println);
            }

            Company company = jobListing.getCompany();
            JobListingResponse response = new JobListingResponse(jobListing.getId(),
                    company.getName(),
                    company.getRating(),
                    jobListing.getDescription(),
                    jobListing.getMonthlySalary(),
                    jobListing.getSkillsRequired());
            return ResponseEntity.ok(response);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/{jobListingId}/seen")
    public ResponseEntity<?> markJobListingSeen(@PathVariable Long jobListingId, @RequestBody String userEmail) {
        try {
            jobListingService.markJobListingSeen(jobListingId, userEmail);
            return ResponseEntity.ok().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
