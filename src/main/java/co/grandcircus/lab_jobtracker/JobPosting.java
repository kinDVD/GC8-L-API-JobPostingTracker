package co.grandcircus.lab_jobtracker;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "[JobPostTracker]")
public class JobPosting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private boolean applied;
    private LocalDate dateApplied;
    private String result;
    @ManyToOne
    private Company company;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Company getCompany() {
        return company;
    }
    public void setCompany(Company company) {
        this.company = company;
    }
    public boolean isApplied() {
        return applied;
    }
    public void setApplied(boolean applied) {
        this.applied = applied;
    }
    public LocalDate getDateApplied() {
        return dateApplied;
    }
    public void setDateApplied(LocalDate dateApplied) {
        this.dateApplied = dateApplied;
    }
    public String getResult() {
        return result;
    }
    public void setResult(String result) {
        this.result = result;
    }

    public JobPosting(Long id, String title, Company company, boolean applied, LocalDate dateApplied, String result) {
        this.id = id;
        this.title = title;
        this.company = company;
        this.applied = applied;
        this.dateApplied = dateApplied;
        this.result = result;
    }
    
    public JobPosting() {
    }

    
}
