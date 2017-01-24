package com.stagex.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.stagex.bean.Student;
import com.stagex.factory.StudentDaoFactory;

/**
 * Servlet implementation class UpdateProfilServlet
 */
@WebServlet("/UpdateProfilServlet")
public class UpdateProfilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProfilServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentDaoFactory studentBdd = new StudentDaoFactory();
		HttpSession session = request.getSession();
		
		Map<String,Object> sqlWhereStudent = new HashMap<String, Object>();   
		int id = (int) session.getAttribute("userid");
		Student student = null;
		try {
			student = studentBdd.find(id, Student.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("student", student);
		request.setAttribute("year", new SimpleDateFormat("yyyy").format(new Date()));
		this.getServletContext().getRequestDispatcher("/update-profile.jsp" ).forward( request, response );

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentDaoFactory studentBdd = new StudentDaoFactory();
		HttpSession session = request.getSession();
		
		Map<String,Object> sqlWhereStudent = new HashMap<String, Object>();  
		int id = (int) session.getAttribute("userid");
		Student student = null;
		try {
			student = studentBdd.find(id, Student.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		student.setGarde(request.getParameter("grade"));
		student.setEmail(request.getParameter("email"));
		student.setTelphone(request.getParameter("telphone"));
		String parcours = getParcours(request.getParameter("parcours"));
		student.setStudentSpe(parcours);
				
		try {
			studentBdd.update(student);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(student.toString());
		
		request.setAttribute("student", student); 

		
		this.getServletContext().getRequestDispatcher("/profile.jsp").forward( request, response );
		
	}
	
	public String getParcours(String input){
		String parcours = null;
		switch (input){
			case "information system" : 
				parcours = "Système d'Information";
				break;
			case "software" :
				parcours = "Génie Logiciel";
				break;
			case "business intelligence" :
				parcours = "Business Intelligence";
				break;
			case "telecom" : 
				parcours = "Télécom et IoT";
				break;
			case "network" : 
				parcours = "Réseau";
				break;
			case "health" : 
				parcours = "Numérique et Santé";

		}
		return parcours;
	}

}
