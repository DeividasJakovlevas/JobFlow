package org.example.service.impl;

import org.example.exception.ResourceNotFoundException;
import org.example.model.JobListing;
import org.example.repository.JobListingRepository;
import org.example.service.JobListingService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class JobListingServiceImpl implements JobListingService {
    private JobListingRepository jobListingRepository;

    public JobListingServiceImpl(JobListingRepository jobListingRepository) {
        this.jobListingRepository = jobListingRepository;
    }


    @Override
    public JobListing getNextJobListing(String email) {
        return jobListingRepository.findBySeenEmailsNotContaining(email)
                .stream()
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException(String.format("No job listings found for email: %s", email)));
    }

    @Override
    public void markJobListingSeen(long id, String email) {
         JobListing listing = jobListingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("No job listings found for id: %s", id)));

        List<String> emails = listing.getSeenEmails();
        if(emails==null){
            emails = new ArrayList<>();
        }
        emails.add(email);
        listing.setSeenEmails(emails);
        jobListingRepository.save(listing);
    }
}
