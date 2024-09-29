package co.grandcircus.lab_jobtracker;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;




@RestController
public class JobPostingController {

    @Autowired
    private JobRepository jobRepo;

    @GetMapping("/")
    public String getDefault() {
        return "Sup!";
    }
    
    @GetMapping("/JobPostings")
    public List<JobPosting> getAllJobs(){
        return this.jobRepo.findAll();
    }

    @GetMapping("/JobPostings/{id}")
    public JobPosting GetJobById(@PathVariable("id") Long id) {
        return jobRepo.findById(id).orElse(null);
    }

    @PostMapping("/JobPostings")
    public JobPosting AddJob(@RequestBody JobPosting newJobposting){
        newJobposting.setId(null);
        this.jobRepo.save(newJobposting);
        return newJobposting;
    }

    @DeleteMapping("/JobPostings/{id}")
    public void DeleteJobPosting(@PathVariable("id") Long id){
        jobRepo.deleteById(id);
    }

    @PutMapping("JobPostings/{id}")
    public JobPosting UpdateJobPosting(@PathVariable("id") Long id, @RequestBody JobPosting updated) {
        jobRepo.save(updated);
        return updated;
    }
    
    
}
