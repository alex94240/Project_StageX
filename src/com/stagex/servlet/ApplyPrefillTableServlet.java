package com.stagex.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.stagex.bean.Student;
import com.stagex.factory.StudentDaoFactory;

/**
 * Servlet implementation class ApplyPrefillTableServlet
 */
@WebServlet("/apply-internship-agreement")
public class ApplyPrefillTableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplyPrefillTableServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		//System.out.println("servlet mapping test");
		HttpSession session = request.getSession();
		int userId = -1;
		userId = (int) session.getAttribute("id");
		System.out.println(userId);
		
		StudentDaoFactory stuFactory = new StudentDaoFactory();
		String firstName = "";
		String lastName = "";
		String telephone = "";
		String email = "";
		
		try {
			
			Student findStu = stuFactory.find(userId,Student.class);
			firstName = findStu.getFirstName();
			lastName = findStu.getLastName();
			telephone = findStu.getTelphone();
			email = findStu.getEmail();
			/*
			firstName = "test fN";
			lastName = "test lN";
			telephone = "test telephone";
			email = "test@email.com";
			*/
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		request.setAttribute("prenom", firstName);
		request.setAttribute("nom", lastName);
		request.setAttribute("telephone", telephone);
		request.setAttribute("email", email);
		RequestDispatcher view = getServletContext().getRequestDispatcher("/apply-internship-agreement.jsp"); 
		view.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
