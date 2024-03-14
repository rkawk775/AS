package com.as.controller;

import java.io.IOException;



import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.as.dao.AsinfoDAO;
import com.as.dao.mainpageDAO;
import com.as.dto.membershipDTO;
import com.as.dto.reservationDTO;

/**
 * Servlet implementation class AsinfoDeleteServlet
 */
@WebServlet("/asinfoDelete.do")
public class AsinfoDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AsinfoDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String res_id = request.getParameter("res_id");
		AsinfoDAO dao = AsinfoDAO.getInstance();
		reservationDTO dto = dao.selectAsinfobyres_id(res_id);
		request.setAttribute("asinfoDelete", dto);
		RequestDispatcher rd = request.getRequestDispatcher("asInfo/asinfoDelete.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String res_id = request.getParameter("res_id");
		String email = request.getParameter("email");
		mainpageDAO mdao = mainpageDAO.getInstance();
		membershipDTO mdto = mdao.selectByCode(email);
		System.out.println(email);
		request.setAttribute("email", mdto);
		AsinfoDAO dao = AsinfoDAO.getInstance();
		dao.deleteAsinfo(res_id);
		RequestDispatcher rd = request.getRequestDispatcher("mainpage.do");
		rd.forward(request, response);
		//response.sendRedirect("mainpage.do");
	}

}
