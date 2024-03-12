package com.as.controller;

import java.io.IOException;

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
 * Servlet implementation class changeServlet
 */
@WebServlet("/change.do")
public class changeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public changeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		
		mainpageDAO mdao = mainpageDAO.getInstance();
		//reservationDTO rdto = mdao.selectChangeByCode(email);
		membershipDTO mdto = mdao.selectByCode(email);
		request.setAttribute("rdto", mdto);
		RequestDispatcher rd = request.getRequestDispatcher("mainpage/change.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		System.out.println("연결");
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
		//System.out.println("길이는 : "+str.length);
		//System.out.println("asitem : "+ asitem);
		//System.out.println("res_date : "+ res_date);
		//System.out.println("time : "+res_time);
		//System.out.println("name : "+name);
		//System.out.println("phone : "+ phone);
		//System.out.println("email : "+ email);
		mainpageDAO mdao = mainpageDAO.getInstance();
		reservationDTO rdto = new reservationDTO();
		rdto.setAsitem(asitem);
		rdto.setRes_date(res_date);
		rdto.setRes_time(res_time);
		rdto.setName(name);
		rdto.setEmail(email);
		
		mdao.updateas(rdto);
		//response.sendRedirect("mainpage.do");
		RequestDispatcher rd = request.getRequestDispatcher("mainpage.do");
		rd.forward(request, response);
		
	}

}
