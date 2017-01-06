package com.stagex.factory;

import java.sql.ResultSet;

import com.stagex.bean.Student;
import com.stagex.dao.*;

public class StudentDaoFactory extends GenericDaoImpl<Student>{
	//write student own sql method
	public boolean login(String usename,String password){
		
		return false;
		
	}
	
}
