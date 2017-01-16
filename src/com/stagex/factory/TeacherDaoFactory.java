package com.stagex.factory;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.*;

import com.stagex.bean.Student;
import com.stagex.bean.Teacher;
import com.stagex.dao.GenericDaoImpl;
import com.stagex.dbutil.DatabaseConnection;

public class TeacherDaoFactory extends GenericDaoImpl<Teacher> {
	
	//salary internship
	public static int salInternship() throws Exception{
		DatabaseConnection dbConn = new DatabaseConnection();
		Connection conn= dbConn.getConnection();
		Statement statement = conn.createStatement();
		ResultSet resultat = statement.executeQuery( "SELECT avg(salary) FROM stagex.apply"	+ " WHERE validate = 1;");
		int a = 0;
		while (resultat.next()){
			a=resultat.getInt("avg(salary)");
		}
		resultat.close();
		return a;
	}
	
	//salary 
	public static int salJob() throws Exception{
		DatabaseConnection dbConn = new DatabaseConnection();
		Connection conn= (Connection) dbConn.getConnection();
		Statement statement = (Statement) conn.createStatement();
		ResultSet resultat = statement.executeQuery( "SELECT avg(salary) FROM "
				+ "stagex.experience;");
		int a=0;
		while (resultat.next()){
			 a=resultat.getInt("avg(salary)");
		
		}
		resultat.close();
		return a;
	}
	
	//company name of internship students
	public static ArrayList<String> companyStudents() throws Exception{
		DatabaseConnection dbConn = new DatabaseConnection();
		Connection conn= dbConn.getConnection();
		Statement statement = conn.createStatement();
		ResultSet resultat = statement.executeQuery("SELECT distinct companyname FROM stagex.company LEFT JOIN stagex.apply ON "
				+ "stagex.company.companyId=stagex.apply.companyId;");
		
		System.out.println("Les compagnies des élèves en stage sont:");
		
		ArrayList companies = new ArrayList<String>();
		while (resultat.next()){
			String a=resultat.getString("companyname");
			companies.add(a);
		}
		resultat.close();
		return companies;
	}
	
}