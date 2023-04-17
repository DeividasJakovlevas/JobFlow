package org.example.repository;

import org.example.model.JobListing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface JobListingRepository extends JpaRepository<JobListing,Long> {

//    @Query(value = "SELECT j FROM job_listing j WHERE NOT EXISTS (SELECT e FROM j.seenEmails e)", nativeQuery = true)
//    List<JobListing> findUnseenListingsByEmail(String email);

    List<JobListing> findBySeenEmailsNotContaining(String email);

}
