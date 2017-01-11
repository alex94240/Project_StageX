package com.stagex.factory;

import java.sql.DriverManager;
import java.sql.ResultSet;

import java.sql.*;
import com.stagex.bean.Teacher;
import com.stagex.dao.GenericDaoImpl;
import com.stagex.dbutil.DatabaseConnection;

public class TeacherDaoFactory extends GenericDaoImpl<Teacher> {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TeacherDAO dao = new TeacherDAO(); //creating obj for class StudentDAO		
		for(int i=1; i>=0; i++){
		Student s1 = dao.getStudent(i);//we dont hav a method here so we hav to define below
		System.out.println(s1.userid +" "+ s1.username);
		}
	}
	
	//salary internship
	public static int salInternship() throws Exception{
		DatabaseConnection dbConn = new DatabaseConnection();
		Connection conn= dbConn.getConnection();
		Statement statement = conn.createStatement();
		ResultSet resultat = statement.executeQuery( "SELECT avg(salary) FROM stagex.apply"
				+ "WHERE validate='true';");
		int a = 0;
		while (resultat.next()){
			a=resultat.getInt("avg(salary)");
			System.out.println("Le salaire moyen des élèves en stage est:"+a);
		}
		resultat.close();
		return a;
	}
	
	//salary 
	public static void salJob() throws Exception{
		DatabaseConnection dbConn = new DatabaseConnection();
		Connection conn= (Connection) dbConn.getConnection();
		Statement statement = (Statement) conn.createStatement();
		ResultSet resultat = statement.executeQuery( "SELECT avg(salary) FROM "
				+ "stagex.experience;");
		System.out.println("Le salaire moyen des anciens élèves est:");
		while (resultat.next()){
			int a=resultat.getInt("avg(salary)");
			System.out.println(a);
		}
		resultat.close();
	}
	
	//company name of internship students
	public static void companyStudents() throws Exception{
		DatabaseConnection dbConn = new DatabaseConnection();
		Connection conn= dbConn.getConnection();
		Statement statement = conn.createStatement();
		ResultSet resultat = statement.executeQuery("SELECT distinct companyname FROM stagex.company LEFT JOIN stagex.apply ON "
				+ "stagex.company.companyId=stagex.apply.companyId;");
		
		System.out.println("Les compagnies des élèves en stage sont:");
		
		while (resultat.next()){
			String a=resultat.getString("companyname");
			System.out.println(a);
		}
		resultat.close();
	}
	
}

class TeacherDAO{
	public Student getStudent(int userid)
	{
		try{
			Student s = new Student();
			s.userid = userid;
			String query = "select username from student where userid="+userid;
		
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/stagex?useSSL=false","root","root");
			Statement  st = (Statement) con.createStatement();
		
			ResultSet rs = st.executeQuery(query);
			rs.next();
			String name = rs.getString(1);
			s.username = name;
			return s;
		}
		catch(Exception ex){
			System.out.println(ex);
		}
		return null;
		}
	} 

class Student{
	int userid;
	String username;
}