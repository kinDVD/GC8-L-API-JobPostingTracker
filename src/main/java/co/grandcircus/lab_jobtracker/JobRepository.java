package co.grandcircus.lab_jobtracker;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<JobPosting, Long>{
    
}
