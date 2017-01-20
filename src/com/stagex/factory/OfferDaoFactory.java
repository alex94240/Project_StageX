package com.stagex.factory;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.stagex.bean.Offer;
import com.stagex.bean.Student;
import com.stagex.dao.GenericDaoImpl;
import com.stagex.dbutil.DatabaseConnection;

public class OfferDaoFactory extends GenericDaoImpl<Offer>{
	
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

	
}
