package com.as.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.List;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.as.dao.mainpageDAO;
import com.as.dto.membershipDTO;
import com.as.dto.reservationDTO;


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
		String res_id = request.getParameter("email");
		
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
		String asitem = "";
		for(int i=0;i<str.length;i++) {
			if(i == 0) {
				asitem += str[i];
			}else {
				asitem = asitem+","+str[i];
			}
		}
	
	      /*SimpleDateFormat format = new SimpleDateFormat("MMdd");
	      try {
	         Date date = (Date) format.parse(res_date);
	         rdto.setRes_date(date);
	         System.out.println("=========================");
	         System.out.println(rdto.getRes_date());
	      }catch(Exception e) {
	         e.printStackTrace();
	      }*/
		
		
		System.out.println("길이는 : "+str.length);
		System.out.println("asitem : "+ asitem);
		//SimpleDateFormat formatter = new SimpleDateFormat("MM-dd");
		System.out.println("res_date : "+ res_date);
		System.out.println("time : "+res_time);
		System.out.println("name : "+name);
		System.out.println("phone : "+ phone);
		System.out.println("email : "+ email);
		
		
		reservationDTO rdto = new reservationDTO();
		rdto.setAsitem(asitem);
		rdto.setRes_date(res_date);
		
		/*try {
			Date date = (Date) formatter.parse(res_date);
			
			java.sql.Date sqlDate = new java.sql.Date
			System.out.println("date : "+date);
			rdto.setRes_date(date);
		}catch(Exception e) {
			e.printStackTrace();
		}
		*/
		rdto.setRes_time(res_time);
		rdto.setName(name);
		
	
		
		mainpageDAO mdao = mainpageDAO.getInstance();
		
		mdao.insertas(rdto,email);
		
		//response.sendRedirect("mainpage/mainpage.jsp");
		RequestDispatcher rd = request.getRequestDispatcher("mainpage/mainpage.jsp");
		rd.forward(request, response);
		
	}

}
