package com.ls.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.ls.entity.Company;
import com.ls.entity.CompanyAdditional;
import com.ls.entity.Problem;
import com.ls.vo.CompanySearchVo;

public interface CompanyService {
	List<Company> findCompany(String name);

	List<Company> findAllCompanies();

	Page<Company> getCompanyInPage(Integer index);

	Page<Company> getCompanyInPage(String companyNameParam, String contactorParam, String starParam, String allStarCheckboxParam, String distinctParam, Integer pageNumber);

	Page<Company> getCompanyInPage(CompanySearchVo companySearchVo);

	Problem saveProblem(Problem problem);
	
	CompanyAdditional saveAdditionalCompanyInformation(CompanyAdditional addtion);
	
	CompanyAdditional findCompanyAddtionalInformationByCompanyId(Integer companyId);
	
	void checkOrUncheckProblem(String companyJson, String problemJson, String checkFlag);
}
