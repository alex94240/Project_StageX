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
	public static int salJob() throws Exception{
		DatabaseConnection dbConn = new DatabaseConnection();
		Connection conn= (Connection) dbConn.getConnection();
		Statement statement = (Statement) conn.createStatement();
		ResultSet resultat = statement.executeQuery( "SELECT avg(salary) FROM "
				+ "stagex.experience;");
		int a = 0;
		while (resultat.next()){
			a=resultat.getInt("avg(salary)");
		}
		resultat.close();
		
	return a;
	}
	
}