package com.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.company.entity.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {

	@Query("select p from Company p where p.id=:companyId")
	Company findCompanyById(@Param("companyId") Long companyId);

}
