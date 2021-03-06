package com.ls.script;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.ls.constants.XinXinConstants;
import com.ls.entity.Company;
import com.ls.entity.Dictionary;
import com.ls.entity.Phase;
import com.ls.entity.Step;
import com.ls.enums.CustomerStatusEnum;
import com.ls.repository.CompanyRepository;
import com.ls.repository.DropDownRepository;
import com.ls.repository.PhaseRepository;
import com.ls.repository.ProblemRepository;
import com.ls.repository.StepRepository;

/**
 * This class is for basic data preparation for the web app starting up. using this class without retrieving data from the UI. The data must not be
 * changed.
 * 
 * @author jjiang
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestInitializationScripts {

	@Autowired
	private StepRepository stepRepository;
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@Autowired
	private PhaseRepository phaseRepository;
	
	@Autowired
	private DropDownRepository dropDownRepository;
	
	@Autowired
	private ProblemRepository problemRepository;

	@Test
	public void testInitialCompanySteps() throws Exception {

		Step stepOne = new Step(10, "非意向客户", 1);
		Step stepTwo = new Step(20, "申请成为意向客户", 2);
		Step stepThree = new Step(30, "公开课", 4);
		Step stepFour = new Step(40, "内训班", 3);
		Step stepFive = new Step(50, "精品班", 5);
		Step stepSix = new Step(60, "院长班", 6);
		Step stepSeven = new Step(70, "连锁班", 7);
		
		stepRepository.save(stepOne);
		stepRepository.save(stepTwo);
		stepRepository.save(stepThree);
		stepRepository.save(stepFour);
		stepRepository.save(stepFive);
		stepRepository.save(stepSix);
		stepRepository.save(stepSeven);
		
	}

	/**
	 * init company data
	 * 
	 * star : 0
	 * status : no willing 
	 * istracked : false
	 * 
	 * @throws Exception
	 */
	@Test
	public void testInitialCompanyStatus() throws Exception {

		List<Company> companies = companyRepository.findAll();
		for (Company company : companies) {
			company.setStatus(CustomerStatusEnum.NO_WILLING_CUSTOMER.getId().toString());
			company.setIsTracked(false);
			company.setStar(0);
			
			companyRepository.save(company);
		}
		
	}
	
	@Test
	public void testInitialPhase() throws Exception {
		
		Phase firstPhase = new Phase(10, "一期");
		Phase secondPhase = new Phase(10, "二期");
		Phase thirdPhase = new Phase(10, "三期");
		Phase fourthPhase = new Phase(10, "四期");
		
		List<Phase> phases = ImmutableList.of(firstPhase, secondPhase, thirdPhase, fourthPhase);
		
		phaseRepository.save(phases);
	}
	
	@Test
	public void testInitialCompanyType() throws Exception {
		
		Dictionary firstDictionary = new Dictionary(XinXinConstants.COMPANY_TYPE, "A", "A类顾客", "");
		Dictionary secondDictionary = new Dictionary(XinXinConstants.COMPANY_TYPE, "B", "B类顾客", "");
		Dictionary threeDictionary = new Dictionary(XinXinConstants.COMPANY_TYPE, "C", "C类顾客", "");
		
		List<Dictionary> dictionaries = ImmutableList.of(firstDictionary, secondDictionary, threeDictionary);
		
		dropDownRepository.save(dictionaries);
	}
	
	@Test
	public void removeProblems() {
		problemRepository.deleteAll();
	}
	
	@Test
	public void removeCompany() {
		companyRepository.deleteAll();
	}
}
