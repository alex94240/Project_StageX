package com.stagex.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stagex.factory.TeacherDaoFactory;

/**
 * Servlet implementation class Statistics
 */
@WebServlet("/Statistics")
public class StatisticServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StatisticServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int a = 0;
		int b = 0;
		ArrayList<String> c;
		try {
			a = TeacherDaoFactory.salInternship();
			b = TeacherDaoFactory.salJob();
			c = TeacherDaoFactory.companyStudents();
			request.setAttribute("avgSalInternship", a);
			request.setAttribute("avgSalJob", b);
			request.setAttribute("companyname", c);
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		this.getServletContext().getRequestDispatcher( "/reporting.jsp" ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
