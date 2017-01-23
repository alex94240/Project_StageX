package com.stagex.factory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;
import com.stagex.bean.Apply;
import com.stagex.bean.Student;
import com.stagex.dao.GenericDaoImpl;
import com.stagex.dbutil.DatabaseConnection;

public class ApplyDaoFactory extends GenericDaoImpl<Apply>{
	
	
	public static List<Apply> list() throws Exception {
			List<Apply> ApplyList = new ArrayList<Apply>();

        	DatabaseConnection dbConn = new DatabaseConnection();
        	Connection conn= dbConn.getConnection();
        	Statement statement = conn.createStatement();
        	ResultSet resultat = statement.executeQuery("SELECT applyGoal,validate,apply.studentId,salary,apply.companyId,startDate,decription,firstName,lastName,companyName FROM apply RIGHT JOIN student ON student.studentId=apply.studentId LEFT JOIN company ON company.companyId=apply.companyId WHERE apply.validate=0");  
     
            while (resultat.next()) {
                
                
                	
                	Apply apply = new Apply();
                	apply.setStudentId(resultat.getInt("studentId"));
                	apply.setSalary(resultat.getInt("salary"));
                	apply.setCompanyId(resultat.getInt("companyId"));
                	apply.setStartDate(resultat.getDate("startDate"));
                	apply.setDecription(resultat.getString("decription"));
                	apply.setApplyRequirement(resultat.getString("lastName"));
                	apply.setBossFax(resultat.getString("firstName"));
                	apply.setPricipleSteps(resultat.getString("companyName"));
                	apply.setApplyGoal(resultat.getString("applyGoal"));
                	
                	ApplyList.add(apply);
                
            }
            return ApplyList;
        }

        


	public void validateApply(Apply apply, boolean bool ){
		 
		DatabaseConnection databaseConnection = null;
	    Connection connection = null;
	    PreparedStatement statement = null;
	    ResultSet resultat = null;
	       
	    try{
	    	databaseConnection = new DatabaseConnection();
	    	connection = databaseConnection.getConnection();
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
	     
	    try {
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement("UPDATE INTO apply (validate) VALUES(?);");
            preparedStatement.setBoolean(0, bool);
            
            preparedStatement.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	     

}
	
