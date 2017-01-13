package com.stagex.factory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.PreparedStatement;
import com.stagex.bean.Student;
import com.stagex.dao.*;
import com.stagex.dbutil.DatabaseConnection;

public class StudentDaoFactory extends GenericDaoImpl<Student>{
	//write student own sql method
	
	 public Student getStudent(HttpServletRequest request){
		
		Student student = new Student();
	
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
        	HttpSession session= request.getSession(); 
			@SuppressWarnings("null")
			String login=(String) session.getAttribute("login");
			System.out.println(login);
            statement = (PreparedStatement) connection.prepareStatement("SELECT * FROM student WHERE login=\""+login+"\";");
           
            // request execution
            resultat = statement.executeQuery();
    
            // Récupération des donnŽes
            while (resultat.next()) {
            	
            	String firstName = resultat.getString("firstName");
            	String lastName = resultat.getString("lastName");
            	String email = resultat.getString("email");
            	String telphone = resultat.getString("telphone");
            	String garde = resultat.getString("garde");
            	String motivation = resultat.getString("motivation");
            	String cv = resultat.getString("cv");
            	String picture = resultat.getString("picture");
                 
                student.setFirstName(firstName);
                student.setLastName(lastName);
                student.setEmail(email);
                student.setTelphone(telphone);
                student.setGarde(garde); //grade TODO : voir sous quelle forme on le récupère
                student.setMotivation(motivation);
                student.setCv(cv);
                student.setPicture(picture);
                }
        }
                     
            
           catch (SQLException e) {
        	   e.printStackTrace();
           } 
           finally {
                // Fermeture de la connexion
                try {
                    if (resultat != null)
                        resultat.close();
                    if (statement != null)
                        statement.close();
                    if (connection != null)
                        connection.close();
                } catch (SQLException ignore) {
                }
           }
              
            return student; 
       
	}
	
}
