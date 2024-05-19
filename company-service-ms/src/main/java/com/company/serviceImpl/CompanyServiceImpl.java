package com.company.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.company.entity.Company;
import com.company.repository.CompanyRepository;


@Service
public class CompanyServiceImpl {

	private CompanyRepository companyRepository;

	public CompanyServiceImpl(CompanyRepository companyRepository) {
		super();
		this.companyRepository = companyRepository;
	}

	public List<Company> getAllCompanies() {
		return companyRepository.findAll();
	}

	public Company findCompanyById(Long companyId) {
		return companyRepository.findCompanyById(companyId);
	}

	public Company createCompany(Company company) {
		return companyRepository.save(company);
	}

	public String deleteCompanyById(Long companyId) {
		companyRepository.deleteById(companyId);
		return "Company deleted successfully ";
	}

}
