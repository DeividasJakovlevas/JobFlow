package org.example.utils;

import org.example.model.Company;
import org.example.model.JobApplication;
import org.example.model.JobListing;
import org.example.repository.CompanyRepository;
import org.example.repository.JobListingRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    private final JobListingRepository jobListingRepository;
    private final CompanyRepository companyRepository;

    public DataLoader(JobListingRepository jobListingRepository, CompanyRepository companyRepository) {
        this.jobListingRepository = jobListingRepository;
        this.companyRepository = companyRepository;
    }
    public static List<Company> loadCompanies() {
        List<Company> companies = new ArrayList<>();

        Company company1 = new Company();
        company1.setName("ABC Company");
        company1.setRating(4.5f);

        Company company2 = new Company();
        company2.setName("XYZ Company");
        company2.setRating(3.8f);

        companies.addAll(Arrays.asList(company1, company2));

        return companies;
    }

    public static List<JobListing> loadJobListings(List<Company> companies) {
        List<JobListing> jobListings = new ArrayList<>();

        JobListing job1 = new JobListing();
        job1.setDescription("We are seeking a skilled Java developer to join our team " +
                "and help us build and maintain our enterprise-level applications. " +
                "The ideal candidate should have experience with Java, Spring, and Hibernate, and be comfortable working " +
                "in a team environment. Responsibilities include developing, testing, and deploying high-quality code, " +
                "troubleshooting issues, and collaborating with cross-functional teams.");
        job1.setMonthlySalary(5000);
        job1.setCompany(companies.get(0));
        job1.setSkillsRequired(Arrays.asList("Java", "Spring", "Hibernate"));

        JobListing job2 = new JobListing();
        job2.setDescription("We are seeking a talented Python developer to join our team and help us build " +
                "and maintain our web-based applications. The ideal candidate should have experience with Python, " +
                "Django, and Flask, and be comfortable working in a fast-paced, agile environment. " +
                "Responsibilities include designing and implementing new features, writing unit tests, and collaborating " +
                "with cross-functional teams to deliver high-quality software.");
        job2.setMonthlySalary(4500);
        job2.setCompany(companies.get(1));
        job2.setSkillsRequired(Arrays.asList("Python", "Django", "Flask"));

        JobListing job3 = new JobListing();
        job3.setDescription("We are looking for a Frontend Developer with experience in React to join our team " +
                "and help us build our web applications. The ideal candidate should have experience in HTML, CSS, and " +
                "Javascript, as well as proficiency in React. Responsibilities include developing user-friendly " +
                "web pages, building reusable components, and collaborating with cross-functional teams.");
        job3.setMonthlySalary(4000);
        job3.setCompany(companies.get(0));
        job3.setSkillsRequired(Arrays.asList("React", "HTML", "CSS", "Javascript"));

        JobListing job4 = new JobListing();
        job4.setDescription("We are seeking an experienced DevOps Engineer to join our team and help us deploy " +
                "and manage our applications in the cloud. The ideal candidate should have experience in AWS, " +
                "Docker, and Kubernetes, as well as knowledge of scripting languages such as Bash and Python. " +
                "Responsibilities include building and maintaining our infrastructure, automating deployments, " +
                "and ensuring high availability and scalability of our systems.");
        job4.setMonthlySalary(6000);
        job4.setCompany(companies.get(1));
        job4.setSkillsRequired(Arrays.asList("DevOps", "AWS", "Docker", "Kubernetes", "Bash", "Python"));

        jobListings.addAll(Arrays.asList(job1, job2, job3, job4));

        return jobListings;
    }

    public static List<JobApplication> loadJobApplications(List<JobListing> jobListings) {
        List<JobApplication> jobApplications = new ArrayList<>();

        JobApplication application1 = new JobApplication();
        application1.setEmail("johndoe@example.com");
        application1.setSkills(Arrays.asList("Java", "Spring"));
        application1.setJobListing(jobListings.get(0));

        JobApplication application2 = new JobApplication();
        application2.setEmail("janedoe@example.com");
        application2.setSkills(Arrays.asList("Python", "Django"));
        application2.setJobListing(jobListings.get(1));

        jobApplications.addAll(Arrays.asList(application1, application2));

        return jobApplications;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("test1");
        List<Company> companies = loadCompanies();
        companies = companyRepository.saveAll(companies);
        jobListingRepository.saveAll(loadJobListings(companies));
        System.out.println("test2: "+jobListingRepository.findAll().size());
    }
}
