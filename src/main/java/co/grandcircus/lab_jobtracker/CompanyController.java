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
public class CompanyController {

    @Autowired
    private CompanyRepository companyRepo;

    @GetMapping("/Companies")
    public List<Company> GetAllCompanies(){
        
        return this.companyRepo.findAll();
    }

    @GetMapping("/Companies/{id}")
    public Company GetCompanyById(@PathVariable("id") Long id){
        return companyRepo.findById(id).orElse(null);
    }

    @PostMapping("/Companies")
    public Company postMethodName(@RequestBody Company company) {
        company.setId(null);
        this.companyRepo.save(company);
        return company;
    }

    @DeleteMapping("/Companies/{id}")
    public void DeleteCompany(@PathVariable("id") Long id){
        companyRepo.deleteById(id);
    }

    @PutMapping("Companies/{id}")
    public Company UpdateCompany(@PathVariable("id") Long id, @RequestBody Company updated){
        companyRepo.save(updated);
        return updated;
    }
    

}
