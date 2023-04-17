package org.example.service;

import jakarta.transaction.Transactional;
import org.example.model.JobListing;


@Transactional
public interface JobListingService {
    JobListing getNextJobListing(String email);
    void markJobListingSeen(long id, String email);
}
