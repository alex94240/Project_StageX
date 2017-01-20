package com.stagex.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stagex.bean.Company;
import com.stagex.bean.Offer;
import com.stagex.factory.CompanyDaoFactory;
import com.stagex.factory.OfferDaoFactory;


@WebServlet("/PostOffer")
public class PostOffer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PostOffer() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Offer offer = new Offer();
		OfferDaoFactory offerFactory = new OfferDaoFactory();
		Company company = new Company();
		CompanyDaoFactory companyFact = new CompanyDaoFactory();
		
		//Enterprise
		String group = request.getParameter("group");
			//String nom = request.getParameter("nom");
			//String liendusiteInternet = request.getParameter("liendusiteInternet");
		String description = request.getParameter("description");
		
		//contact
		String nom_contact = request.getParameter("nom_contact");
		String prenom_contact = request.getParameter("prenom_contact");
		String email = request.getParameter("email");
		String post = request.getParameter("post");
		
		//Offer
		String titre_offer = request.getParameter("titre_offer");
			//String description_offer = request.getParameter("description_offer");
		String description_profile = request.getParameter("description_profile");
			//String lieu_offer = request.getParameter("lieu_offer");
		String renumeration = request.getParameter("renumeration");
		String complete_research = request.getParameter("complete_research");
		String duration_offer = request.getParameter("duration_offer");
		
		offer.setAbilityRequirement(complete_research);
		offer.setContactFirstName(nom_contact);
		offer.setContactLastName(prenom_contact);
		offer.setDescription(description);
		offer.setEmail(email);
		offer.setProfileRequirement(description_profile);
		offer.setDuration(duration_offer);
		offer.setJob(group);
		offer.setLoction(post);
		offer.setSalary(Integer.parseInt(renumeration));
		offer.setTitle(titre_offer);
		
		try {
			int companyId = companyFact.createReturnId(company);		
			offer.setCompanyId(companyId);		
			offerFactory.createWithUncompleteObject(offer);
			
			System.out.println("create apply succ");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		this.getServletContext().getRequestDispatcher( "/post-offer.jsp" ).forward( request, response );

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("success servlet opened");
		doGet(request, response);
	}

}
