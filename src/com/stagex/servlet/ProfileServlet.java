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
		
		System.out.println(request.getParameter("userid"));
		
		Map<String,Object> sqlWhereStudent = new HashMap<String, Object>();   
		int id = Integer.parseInt(request.getParameter("userid"));
		Student student = null;
		try {
			student = studentBdd.find(id, Student.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Student student = studentBdd.getStudent(request); //je récupère dans la bdd l'étudiant qui est en cours de session 		
		
		
		System.out.println(student.toString());
		
		request.setAttribute("student", student); 
		
		this.getServletContext().getRequestDispatcher("/profile.jsp" ).forward( request, response );
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int studentId = (int) request.getAttribute("studentId");
		
		StudentDaoFactory studentBdd = new StudentDaoFactory();
		Map<String,Object> sqlWhereStudent = new HashMap<String, Object>(); 
		Student student = null;
		
		try {
			student = studentBdd.find(studentId, Student.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("student", student);
		
		this.getServletContext().getRequestDispatcher("/profile.jsp" ).forward( request, response );

	}
	
	/*private static String getSubmittedFileName(Part part) {
	    for (String cd : part.getHeader("content-disposition").split(";")) {
	        if (cd.trim().startsWith("filename")) {
	            String fileName = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
	            return fileName.substring(fileName.lastIndexOf('/') + 1).substring(fileName.lastIndexOf('\\') + 1); // MSIE fix.
	        }
	    }
	    return null;
	}*/

}
