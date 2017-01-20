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
import com.stagex.bean.Teacher;
import com.stagex.bean.WebUser;
import com.stagex.factory.StudentDaoFactory;
import com.stagex.factory.TeacherDaoFactory;
import com.stagex.factory.WebUserDaoFactory;
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

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher( "/index.jsp" ).forward( request, response );

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		System.out.println(login + " " + password);
	
		String type = null;
		
		/*LDAPaccess ldapaccess = new LDAPaccess();
		LDAPObject ldapobject = null;
		
		try {
			ldapobject = ldapaccess.LDAPget(login, password);
			if(ldapobject ==null){	
				System.out.println("Login ou mot de passe incorrect");
				System.exit(1);
			}
			System.out.println(ldapobject.toString());
			type = ldapobject.getType();
	
			System.out.println("connection to ldap successful");
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);
		}
		
		this.getServletContext().getRequestDispatcher( "/home.jsp" ).forward( request, response );
*/
		//just for trying without LDAP connection
		LDAPObject ldapobject = new LDAPObject("mcauche", "PsR/r7TJ", "Myl�na Cauche", "Cauche", "Myl�na", "student", "0601020304", "mylenacauche@gmail.com");
		System.out.println(ldapobject.toString());

		
		Map<String,Object> sqlWhereUser = new HashMap<String, Object>();   
		sqlWhereUser.put("login", login);
		
		//Find if this user is into the database 
		List<WebUser> webUser;
		WebUser currentUser;
		WebUserDaoFactory userFactory = new WebUserDaoFactory();
		
		int userId = -1;
		int personId = -1;

		try {
			webUser = userFactory.findAllByConditions(sqlWhereUser, WebUser.class);
			
			if(webUser.isEmpty()){
				currentUser = new WebUser();
				currentUser.setLogin(login);
				currentUser.setPassword(password);
				
				System.out.println(currentUser.toString());
				
				userId = userFactory.createReturnId(currentUser);
				System.out.println(userId);
			}
			else{
				currentUser = webUser.get(0);
				userId = currentUser.getUserId();
			}
			

			List<Student> students;
			Student student;
	        StudentDaoFactory stuFactory = new StudentDaoFactory();
			
	        List<Teacher> teachers;
	        Teacher teacher; 
	        TeacherDaoFactory teacherFactory = new TeacherDaoFactory();
			
			Map<String,Object> sqlWhereType = new HashMap<String, Object>();   
			sqlWhereType.put("userId", userId);
			
			if(ldapobject.getType().equals("student")){
				
    			students = stuFactory.findAllByConditions(sqlWhereType, Student.class);
    			if(students.isEmpty()){    				
    				student= new Student();
    				
    				student.setFirstName(ldapobject.getPrenom());
    				student.setLastName(ldapobject.getNomFamille());
    				student.setEmail(ldapobject.getMail());
    				student.setTelphone(ldapobject.getNumber());
    				student.setUserId(userId);
    				
    				System.out.println(student.toString());
    				personId = stuFactory.createReturnId(student);
    			
    			}
    			else{
    				personId = students.get(0).getStudentId();
    			}
    			System.out.println("L'id de l'�tudiant : " + personId);
    			System.out.println("Le login de l'�tudiant est : " + login);
			}
			else if(ldapobject.getType().equals("teacher")){
					
    			teachers = teacherFactory.findAllByConditions(sqlWhereType, Teacher.class);
    			if(teachers.isEmpty()){    				
    				teacher= new Teacher();
    				
    				teacher.setFirstName(ldapobject.getPrenom());
    				teacher.setLastName(ldapobject.getNomFamille());
    				teacher.setEmail(ldapobject.getMail());
    				teacher.setTelphone(ldapobject.getNumber());
    				teacher.setUserId(userId);
    				
    				System.out.println(teacher.toString());
    				personId = teacherFactory.createReturnId(teacher);
    			
    			}
    			else{
    				personId = teachers.get(0).getTeacherId();
    			}
    			System.out.println("L'id de l'�tudiant : " + personId);
    			System.out.println("Le login de l'�tudiant est : " + login);
    			
			
			}
		}catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		HttpSession session=request.getSession();  
        session.setAttribute("login", login);
        session.setAttribute("id", personId);
        session.setAttribute("usertype", type);
		
		this.getServletContext().getRequestDispatcher( "/home.jsp" ).forward( request, response );

	}

}
