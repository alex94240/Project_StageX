package com.stagex.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stagex.bean.Student;
import com.stagex.factory.StudentDaoFactory;

/**
 * Servlet implementation class ResearchServlet
 */
@WebServlet("/ResearchServlet")
public class ResearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//
		String keyword = request.getParameter("keyword");
		
		StudentDaoFactory stufactory = new StudentDaoFactory();
		List<Student> students = new ArrayList<Student>();
		try {
			students = stufactory.searchStudentBycompany(keyword);
			/*
			for(int i = 0; i< students.size(); i++){
				Student temp = students.get(i);
				System.out.print(temp.getFirstName());
				System.out.print(" ");
				System.out.print(temp.getLastName());
				System.out.print(" ");
				System.out.print(temp.getEmail());
				System.out.print(" ");
				System.out.print(temp.getTelphone());
				System.out.print("\n");
				
			}
			*/
			request.setAttribute("students",students);
			RequestDispatcher view = getServletContext().getRequestDispatcher("/researchResult.jsp"); 
			view.forward(request,response); 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
