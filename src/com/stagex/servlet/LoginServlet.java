package com.stagex.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.stagex.bean.Student;
import com.stagex.factory.StudentDaoFactory;
import com.stagex.ldap.LDAPObject;
import com.stagex.ldap.LDAPaccess;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**	
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("login");
		String password = request.getParameter("password");
		String type = null;
		
		LDAPaccess ldapaccess = new LDAPaccess();
		
		try {
			LDAPObject ldapobject = ldapaccess.LDAPget(user, password);
			if(ldapobject ==null){
				System.out.println("Login ou mot de passe incorrect");
				System.exit(1);
			}
			System.out.println(ldapobject.toString());
			type = ldapobject.getType();
			System.exit(0);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);
		}
		
		//just for trying without LDAP connection
		//LDAPObject ldapobject = new LDAPObject("mcauche", "PsR/r7TJ", "Myléna Cauche", "Cauche", "Myléna", "student", "0601020304", "mylenacauche@gmail.com");
		
		Map<String,Object> sqlWhereMap = new HashMap<String, Object>();   
		sqlWhereMap.put("login", user);
		List<Student> students;
        StudentDaoFactory stuFactory = new StudentDaoFactory();
        int studentId = -1;
        
		try {			
			students = stuFactory.findAllByConditions(sqlWhereMap, Student.class);
			studentId = students.get(0).getStudentId();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
				
		HttpSession session=request.getSession();  
        session.setAttribute("login", user);
        session.setAttribute("id", studentId);
        session.setAttribute("usertype", type);
		
		this.getServletContext().getRequestDispatcher( "/home.jsp" ).forward( request, response );

	}

}
