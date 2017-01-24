package com.stagex.factory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.stagex.bean.Company;
import com.stagex.dao.GenericDaoImpl;
import com.stagex.dbutil.DatabaseConnection;

public class CompanyDaoFactory extends GenericDaoImpl<Company>{
	
	//company name of internship students
		public static ArrayList<String> companyStudents() throws Exception{
			DatabaseConnection dbConn = new DatabaseConnection();
			Connection conn= dbConn.getConnection();
			Statement statement = conn.createStatement();
			ResultSet resultat = statement.executeQuery("SELECT distinct companyname,COUNT(*) FROM company LEFT JOIN stagex.apply ON "
					+ "stagex.company.companyId=stagex.apply.companyId ORDER BY COUNT(*) ASC LIMIT 5;");
			
			ArrayList companies= new ArrayList<String>();
			
			while (resultat.next()){
				String a=resultat.getString("companyname");
				companies.add(a);
			}
			resultat.close();
			
			
			return companies;
		}	
}
