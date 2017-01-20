package com.stagex.factory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;
import com.stagex.bean.Apply;
import com.stagex.dao.GenericDaoImpl;
import com.stagex.dbutil.DatabaseConnection;

public class ApplyDaoFactory extends GenericDaoImpl<Apply>{
	
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
