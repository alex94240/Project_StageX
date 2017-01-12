package com.stagex.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.stagex.bean.Student;
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
		
		LDAPaccess ldapaccess = new LDAPaccess();
		
		/*try {
			LDAPObject ldapobject = ldapaccess.LDAPget(user, password);
			if(ldapobject ==null){
				System.out.println("Login ou mot de passe incorrect");
				System.exit(1);
			}
			System.out.println(ldapobject.toString());	
			System.exit(0);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);
		}*/
		
		//just for trying without LDAP connection
		LDAPObject ldapobject = new LDAPObject("mcauche", "PsR/r7TJ", "Myléna Cauche", "Cauche", "Myléna", "student", "0601020304", "mylenacauche@gmail.com");
		
		//TODO: à modifier 
		Student student = new Student();
		student.setStudentId(9215);
		
		int studentId = student.getStudentId();
		
		
		HttpSession session=request.getSession();  
        session.setAttribute("login", user);
        session.setAttribute("id", studentId);
		
		this.getServletContext().getRequestDispatcher( "/home.jsp" ).forward( request, response );

	}

}
