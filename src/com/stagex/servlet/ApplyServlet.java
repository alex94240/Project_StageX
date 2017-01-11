package com.stagex.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stagex.bean.Apply;
import com.stagex.bean.Company;
import com.stagex.factory.ApplyDaoFactory;
import com.stagex.factory.CompanyDaoFactory;

/**
 * Servlet implementation class ApplyServlet
 */
@WebServlet("/ApplyServlet")
public class ApplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ApplyServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Apply apply = new Apply();
		ApplyDaoFactory applyFactory = new ApplyDaoFactory();
		
		//person information
		String group = request.getParameter("group");
  		String nom = request.getParameter("nom");
  		String prenom = request.getParameter("prenom");
    	String numOfSocialSecurity = request.getParameter("numOfSocialSecurity");
    	String parcours = request.getParameter("parcours");
    	String personAddress = request.getParameter("personAddress");
    	String personEmail = request.getParameter("personEmail");
    	String personTelephone = request.getParameter("personTelephone");
    	
    	//company information
    	String companyName = request.getParameter("companyName");
    	String siretNum = request.getParameter("siretNum");
    	String CodeAPE = request.getParameter("CodeAPE");
    	String companyAddress = request.getParameter("companyAddress");
    	String receptionName = request.getParameter("receptionName");  		
  		String companyFax = request.getParameter("companyFax");
  		String companyEmail = request.getParameter("companyEmail");
  		String companyTelephone = request.getParameter("companyTelephone");
  		
  		Company company = new Company();
  		company.setCompanyName(companyName);
  		company.setSiretNumber(siretNum);
  		company.setCodeApe(CodeAPE);
  		company.setCompanyAddress(companyAddress);
  		company.setReceptionName(receptionName);
  		company.setFax(companyFax);
  		company.setEmail(companyEmail);
  		company.setTelphone(companyTelephone);
  		CompanyDaoFactory companyFact = new CompanyDaoFactory();
  		
  		//apply information
    	String chargeContact = request.getParameter("chargeContact");
  		String applyAddress = request.getParameter("applyAddress");
    	String applyPhone = request.getParameter("applyPhone");    	
    	
    	String description = request.getParameter("description");
    	String startDate = request.getParameter("startDate");
    	String endDate = request.getParameter("endDate");
    	String salary = request.getParameter("salary");
    	String benefit = request.getParameter("benefit");
    	String healthInsurance = request.getParameter("healthInsurance");
    	String workTrip = request.getParameter("workTrip");
    	String wayFindApply = request.getParameter("wayFindApply");
    	
    	String bossNom = request.getParameter("bossNom");
    	String bossPrenom = request.getParameter("bossPrenom");
  		String bossEmail = request.getParameter("bossEmail");
  		String bossJob = request.getParameter("bossJob");
    	String bossTelephone = request.getParameter("bossTelephone");
    	String bossFax = request.getParameter("bossFax");

    	String prestation = request.getParameter("prestation");
    	String contast = request.getParameter("contast");
    	String applyGoal = request.getParameter("applyGoal");
    	String pricipleSteps = request.getParameter("pricipleSteps");
    	String applyRequirement = request.getParameter("applyRequirement");
    	
    	//
		apply.setChargePersonContact(chargeContact);
		apply.setApplyAddress(applyAddress);
		apply.setApplyTelphone(applyPhone);
		apply.setDecription(description);
		try {
			apply.setStartDate(new Date(new SimpleDateFormat("yyyy-MM-dd").parse(startDate).getTime()));
			apply.setEndDate(new Date(new SimpleDateFormat("yyyy-MM-dd").parse(endDate).getTime()));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		apply.setSalary(Integer.parseInt(salary));
		apply.setBenefit(Integer.parseInt(benefit));
		apply.setHealthInsurance(Integer.parseInt(healthInsurance));
		apply.setWorkTrip(Integer.parseInt(workTrip));
		apply.setWayFindApply(wayFindApply);
		apply.setBossFirstName(bossPrenom);
		apply.setBossLastName(bossNom);
		apply.setBossEmail(bossEmail);
		apply.setBossJob(bossJob);
		apply.setBossTelphone(bossTelephone);
		apply.setBossFax(bossFax);
		apply.setCompanyPrestation(prestation);
		apply.setCompanyContast(contast);
		apply.setApplyGoal(applyGoal);
		apply.setPricipleSteps(pricipleSteps);
		apply.setApplyRequirement(applyRequirement);
		
		try {
			int companyId = companyFact.createReturnId(company);
			apply.setCompanyId(companyId);
			applyFactory.create(apply);
			
			//apply.setStudentId(studentId);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
