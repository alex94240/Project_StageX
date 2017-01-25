package com.stagex.factory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.stagex.bean.Company;
import com.stagex.dao.GenericDaoImpl;
import com.stagex.dbutil.DatabaseConnection;

public class CompanyDaoFactory extends GenericDaoImpl<Company>{
	
	//company name of internship students
		public static List<Company> companyStudents() throws Exception{
			DatabaseConnection dbConn = new DatabaseConnection();
			Connection conn= dbConn.getConnection();
			Statement statement = conn.createStatement();
			ResultSet resultat = statement.executeQuery("SELECT companyname,AVG(salary)as a FROM company "
					+ "RIGHT JOIN apply ON company.companyId=apply.companyId GROUP BY companyName;");
			
			List<Company> companies= new ArrayList<Company>();
			
			while (resultat.next()){
				Company company=new Company();
				
				company.setCompanyName(resultat.getString("companyname"));
				company.setCompanyId(resultat.getInt("a"));
				companies.add(company);
			}
			resultat.close();
			
			
			return companies;
		}	
}
