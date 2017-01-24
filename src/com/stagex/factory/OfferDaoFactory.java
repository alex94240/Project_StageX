package com.stagex.factory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;
import com.stagex.bean.Apply;
import com.stagex.bean.Offer;
import com.stagex.bean.Student;
import com.stagex.dao.GenericDaoImpl;
import com.stagex.dbutil.DatabaseConnection;

public class OfferDaoFactory extends GenericDaoImpl<Offer>{
	
	
	public static List<Offer> displayOffers() throws Exception{
		List<Offer> offers= new ArrayList<Offer>();
		DatabaseConnection dbConn = new DatabaseConnection();
		Connection conn= dbConn.getConnection();
		Statement statement = conn.createStatement();
		ResultSet resultat = statement.executeQuery("SELECT title,companyName,duration,salary,job FROM offer "
				+ "LEFT JOIN company ON offer.companyId=company.companyId WHERE validate=1;");
		
		
		
		 while (resultat.next()) {

         	Offer offer = new Offer();
         	offer.setDuration(resultat.getString("duration"));
         	offer.setSalary(resultat.getInt("salary"));
         	offer.setJob(resultat.getString("job"));
         	offer.setTitle(resultat.getString("title"));
         	offer.setContactFirstName(resultat.getString("companyName"));
    
         	offers.add(offer);     
     }
		return offers;
	}	

	
	
	public List<Offer> searchOfferByComapny(String company) throws Exception{
		List<Offer> offers = new ArrayList<Offer>();
		
		DatabaseConnection dbconn = new DatabaseConnection();

	      String sql = "SELECT * FROM stagex.offer as o, company as c where o.companyId = c.companyId and c.companyName like ? and o.validate = 1";
	      Statement statement = dbconn.getConnection().createStatement();
	      String c = "'%" + company + "%'";
	      String replacedSql = sql.replaceAll("\\?", c);
	      System.out.println(replacedSql);

	      ResultSet rs = statement.executeQuery(replacedSql);	      

	      while(rs.next()){
	    	  Offer temp = new Offer();
	    	  temp.setContactFirstName(rs.getString("contactFirstName"));
	    	  temp.setContactLastName(rs.getString("contactLastName"));
	    	  temp.setEmail(rs.getString("email"));
	    	  temp.setJob(rs.getString("job"));
	    	  temp.setTitle(rs.getString("title"));
	    	  temp.setDescription(rs.getString("description"));
	    	  temp.setProfileRequirement(rs.getString("profileRequirement"));
	    	  temp.setAbilityRequirement(rs.getString("abilityRequirement"));
	    	  temp.setLoction(rs.getString("loction"));
	    	  temp.setSalary(rs.getInt("salary"));
	    	  temp.setDuration(rs.getString("duration"));
	    	  offers.add(temp);
	      }
	      rs.close();	

		  return offers;
	}
	
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
