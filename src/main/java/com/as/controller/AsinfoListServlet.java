package com.as.controller;

import java.io.IOException;


import java.util.List;

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
		List<reservationDTO> asinfoList = adao.selectUserAsinfo();
		request.setAttribute("asinfoList", asinfoList);

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