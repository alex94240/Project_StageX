package com.stagex.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stagex.bean.Apply;
import com.stagex.bean.Offer;
import com.stagex.factory.ApplyDaoFactory;
import com.stagex.factory.OfferDaoFactory;


@WebServlet("/OffersServlet")
public class OffersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public OffersServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List <Offer> offers=null;
		
		 try {
	            offers = OfferDaoFactory.displayOffers();
	            
		 } catch (Exception e) {
	        	e.printStackTrace();
	        }
		 
		 request.setAttribute("offers", offers); 
		 
         this.getServletContext().getRequestDispatcher( "/offers.jsp" ).forward( request, response );
   
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
