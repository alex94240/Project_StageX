package com.stagex.factory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;
import com.stagex.bean.Offer;
import com.stagex.dao.GenericDaoImpl;
import com.stagex.dbutil.DatabaseConnection;

public class OfferDaoFactory extends GenericDaoImpl<Offer>{
	
	public void validateOffer(Offer offer, boolean bool ){
		 
		DatabaseConnection databaseConnection = null;
	    Connection connection = null;
	    PreparedStatement statement = null;
	    ResultSet result = null;
	       
	    try{
	    	databaseConnection = new DatabaseConnection();
	    	connection = databaseConnection.getConnection();
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
	     
	    try{
	    	statement = (PreparedStatement) connection.prepareStatement("INSERT INTO offer (validate) VALUES(?);");
            statement.setBoolean(0, bool);
	    	result = statement.executeQuery(); 
	    	result.next();
	         }
		catch (SQLException e) {
    	   e.printStackTrace();
       } 
    }
	    
}
