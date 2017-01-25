package com.stagex.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stagex.bean.Apply;
import com.stagex.bean.Student;
import com.stagex.factory.ApplyDaoFactory;
import com.stagex.factory.StudentDaoFactory;

@WebServlet("/ValidateApplyServlet")
public class ValidateApplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ValidateApplyServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List <Apply> applyList=null;
		
		 try {
	            applyList = ApplyDaoFactory.list();
	            
		 } catch (Exception e) {
	        	e.printStackTrace();
	        }
		 request.setAttribute("apply", applyList); 
        this.getServletContext().getRequestDispatcher( "/validate-apply.jsp" ).forward( request, response );
    

	    }


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int validate = Integer.parseInt(request.getParameter("validate"));
		System.out.println(validate);
		
		ApplyDaoFactory applyDaoFactory = new ApplyDaoFactory();
		
		if(validate==1){
			applyDaoFactory.validateApply(request.getParameter("applyid"), "1");
		}
		else{
			applyDaoFactory.validateApply(request.getParameter("applyid"), "0");
		}
		
		doGet(request, response);

	}

}
