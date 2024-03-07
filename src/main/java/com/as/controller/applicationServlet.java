package com.as.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.as.dao.mainpageDAO;
import com.as.dto.membershipDTO;

/**
 * Servlet implementation class applicationServlet
 */
@WebServlet("/application.do")
public class applicationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public applicationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String res_id = request.getParameter("res_id");
		
		mainpageDAO adao = mainpageDAO.getInstance();
		membershipDTO mdto = adao.selectMovieByCode(res_id);
		request.setAttribute("mdto", mdto);
		
		RequestDispatcher rd = request.getRequestDispatcher("mainpage/application.jsp");
		rd.forward(request, response);
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String[] str = request.getParameterValues("asitem");
		String res_date = request.getParameter("res_date");
		String res_time = request.getParameter("res_time");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String asitem ="";
		for(int i=0;i<str.length;i++) {
			if(i == 0) {
				asitem += str[i];
			}else {
				asitem = asitem+","+str[i];
			}
		}
		
		System.out.println("길이는 : "+str.length);
		System.out.println("asitem : "+ str);
		System.out.println("date : "+res_date);
		System.out.println("time : "+res_time);
		System.out.println("name : "+name);
		System.out.println("phone : "+ phone);
		System.out.println("email : "+ email);
		
		
		
		System.out.println("도착");
		
		
		
		
		RequestDispatcher rd = request.getRequestDispatcher("mainpage.jsp");
		rd.forward(request, response);
		
	}

}
