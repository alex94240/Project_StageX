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

/**
 * Servlet implementation class ValidateApplyServlet
 */
@WebServlet("/ValidateApplyServlet")
public class ValidateApplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidateApplyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//find all apply not validated by teacher 
		Map<String,Object> sqlWhereMap = new HashMap<String, Object>();   
        sqlWhereMap.put("validate", null);
        
        List<Apply> applyList = null;
        ApplyDaoFactory applyFactory = new ApplyDaoFactory();
        
		try {			
			applyList = applyFactory.findAllByConditions(sqlWhereMap, Apply.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
		if(!applyList.isEmpty()){
			for(int i =0; i<applyList.size(); i++){
				System.out.println(applyList.get(i).toString());
			}
		}
		else{
			System.out.println("Aucune demande de convention en cours de validation");
		}
		
		request.setAttribute("applyList", applyList);
		
		this.getServletContext().getRequestDispatcher( "/validate-apply.jsp" ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Apply apply = new Apply(); //TODO : modify and get parameter apply directly from jsp page
		int validate = Integer.parseInt(request.getParameter("validate"));
		System.out.println(validate);
		
		ApplyDaoFactory applyDaoFactory = new ApplyDaoFactory();
		
		if(validate==1){
			applyDaoFactory.validateApply(apply, true);
		}
		else{
			applyDaoFactory.validateApply(apply, false);
		}
		
		this.getServletContext().getRequestDispatcher( "/validate-apply.jsp" ).forward( request, response );

	}

}
