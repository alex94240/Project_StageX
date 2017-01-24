package com.stagex.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.stagex.bean.Student;
import com.stagex.factory.StudentDaoFactory;

/**
 * Servlet implementation class Profile
 */
@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileServlet() {
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
		
		//Student student = studentBdd.getStudent(request); //je r�cup�re dans la bdd l'�tudiant qui est en cours de session 		
		
		
		System.out.println(student.toString());
		
		request.setAttribute("student", student); 
		
		this.getServletContext().getRequestDispatcher("/profile.jsp" ).forward( request, response );
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
