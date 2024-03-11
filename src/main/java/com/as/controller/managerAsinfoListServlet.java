package com.as.controller;

import java.io.IOException;


import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.as.dao.ManagerAsinfoDAO;
import com.as.dao.reservationDAO;
import com.as.dto.reservationDTO;

/**
 * Servlet implementation class asinfoListServlet
 */
@WebServlet("/managerasinfoList.do")
public class managerAsinfoListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public managerAsinfoListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String resId = request.getParameter("res_id");
        
        if (resId != null) {
            reservationDAO rdao = reservationDAO.getInstance(); // reservationDAO 인스턴스 생성
            reservationDTO reservation = rdao.selectReservationByRes_id(resId);
            request.setAttribute("reservation", reservation);
        }
        
        RequestDispatcher rd = request.getRequestDispatcher("asInfo/managerAsinfoList.jsp");
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
