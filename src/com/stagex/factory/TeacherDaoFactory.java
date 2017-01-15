package com.stagex.factory;

import java.sql.DriverManager;
import java.sql.ResultSet;

import java.sql.*;
import com.stagex.bean.Teacher;
import com.stagex.dao.GenericDaoImpl;
import com.stagex.dbutil.DatabaseConnection;

public class TeacherDaoFactory extends GenericDaoImpl<Teacher>  {
	
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