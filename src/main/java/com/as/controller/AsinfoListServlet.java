package com.as.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.as.dao.AsinfoDAO;
import com.as.dto.reservationDTO;

/**
 * Servlet implementation class asinfoListServlet
 */
@WebServlet("/asinfoList.do")
public class AsinfoListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AsinfoListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AsinfoDAO adao = AsinfoDAO.getInstance();
		reservationDTO asinfoList = adao.selectUserAsinfo("email");
		String res_id = request.getParameter("res_id");
		request.setAttribute("asinfoList", asinfoList);
		if(res_id == null) {
			request.setAttribute("message", "등록된 예약이 없습니다.");
		}

		RequestDispatcher rd = request.getRequestDispatcher("asInfo/asinfoList.jsp");
		rd.forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}