package com.stagex.test;

import java.util.List;
import java.util.Map;

import com.stagex.bean.Company;
import com.stagex.bean.Student;
import com.stagex.factory.CompanyDaoFactory;
import com.stagex.factory.StudentDaoFactory;

public class Main {

	public static void main(String[] args) throws Exception {
		
		StudentDaoFactory stuFactory = new StudentDaoFactory();
		
		
		Student student= new Student();
		
		student.setFirstName("jiajie");
		student.setUserId(1);
		
		
		student.setPicture("http://storage.iseplive.fr/avatars/92/.jpg");
		
		int personId = stuFactory.createReturnId(student);
		System.out.println(personId);
		
		/* 
		//create a new record		 
		Student stu = new Student();
		
		stu.setAddress(null);
		stu.setCv(null);
		stu.setEmail(null);
		stu.setFirstName(null);
		stu.setGarde(null);
		stu.setLastName(null);
		stu.setMotivation(null);
		stu.setPicture(null);
		stu.setSocialSecruityNum(null);
		stu.setTelphone(null);
		stu.setUserId(1);
		stu.setStudentId(100);
		
		
		Company com = new Company();
		com.setCompanyName("TestLee");
		CompanyDaoFactory companyFact = new CompanyDaoFactory();
		
		try {
			int id = companyFact.createReturnId(com);
			System.out.println(id);
		} catch (Exception e) {
			e.printStackTrace();
		}	
		*/
		
		
		/* 
		//find a record
		try {
			Student findStu = stuFactory.find(100,Student.class);
			System.out.println(findStu.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		
		
		/*
		//delete a record
		try {
			stuFactory.delete(100,Student.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 */
		
		
		
		/*
		//update a record
		Student stu = new student();
		
		stu.setAddress("update address");
		stu.setCv("update cv");
		stu.setEmail("update email");
		stu.setFirstName("update firstname");
		stu.setGarde("update grade");
		stu.setLastName("update lastname");
		stu.setMotivation("update motivtion");
		stu.setPicture("update picture");
		stu.setSocialSecruityNum("update SocialSecruityNum");
		stu.setStudentId(3);
		stu.setTelphone("update telephone");
		stu.setUserId(1);
		
		try {
			stuFactory.update(stu);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		
		/*
		//find records by some condition
		Map<String,Object> sqlWhereMap = new HashMap<String, Object>();   
        sqlWhereMap.put("userId", "1");
        List<Student> stus;
		try {
			stus = stuFactory.findAllByConditions(sqlWhereMap, Student.class);
			
			for (Student stu : stus) {  
				System.out.println(stu);  
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
        */  
		 
		
		
	}

}
