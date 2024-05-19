package com.company.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.company.entity.Company;
import com.company.serviceImpl.CompanyServiceImpl;

@RestController
@RequestMapping("/company")
public class CompanyController {

	private CompanyServiceImpl companyServiceImpl;

	public CompanyController(CompanyServiceImpl companyServiceImpl) {
		super();
		this.companyServiceImpl = companyServiceImpl;
	}

	@GetMapping("/findAllCompanies")
	public List<Company> findAll() {
		return companyServiceImpl.getAllCompanies();
	}

	@GetMapping("/findCompanyById/{companyId}")
	public ResponseEntity<Company> findCompanyById(@PathVariable("companyId") Long companyId) {
		Company company = companyServiceImpl.findCompanyById(companyId);
		if (company != null)
			return new ResponseEntity<>(company, HttpStatus.OK);
		return new ResponseEntity<>(company, HttpStatus.NOT_FOUND);
	}

	@PostMapping("/createCompany")
	public ResponseEntity<Company> createCompany(@RequestBody Company company) {

		Company companydtl = companyServiceImpl.createCompany(company);
		return new ResponseEntity<>(companydtl, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/deleteCompanyById/{companyId}")
	public ResponseEntity<String> deleteCompanyById(@PathVariable("companyId") Long companyId) {
		 String deleteJobById = companyServiceImpl.deleteCompanyById(companyId);
		 if(deleteJobById!=null)
	    return new ResponseEntity<>(deleteJobById, HttpStatus.OK);
	    else return new ResponseEntity<>(deleteJobById, HttpStatus.NOT_FOUND);
	}

}
