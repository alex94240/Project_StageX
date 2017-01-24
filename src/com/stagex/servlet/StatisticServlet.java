package com.stagex.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stagex.factory.CompanyDaoFactory;
import com.stagex.factory.TeacherDaoFactory;


@WebServlet("/Statistics")
public class StatisticServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public StatisticServlet() {
        super();

    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int a = 0;
		int b = 0;
		ArrayList<String> c = null;
		
		try {
			a = TeacherDaoFactory.salInternship();
			b = TeacherDaoFactory.salJob();
			c = CompanyDaoFactory.companyStudents();

		
		} catch (Exception e) {

			e.printStackTrace();
		}

		request.setAttribute("avgSalInternship",a);
		request.setAttribute("avgSalJob",b);
		request.setAttribute("companynames",c);
		//System.out.println(c.get(0));

		this.getServletContext().getRequestDispatcher( "/reporting.jsp" ).forward( request, response );
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
