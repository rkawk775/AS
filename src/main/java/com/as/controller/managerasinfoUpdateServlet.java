package com.as.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.as.dao.managerAsinfoDAO;
import com.as.dto.reservationDTO;

/**
 * Servlet implementation class managerasinfoUpdateServlet
 */
@WebServlet("/managerasinfoUpdate.do")
public class managerasinfoUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public managerasinfoUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String res_id = request.getParameter("res_id");
        
        managerAsinfoDAO mdao = managerAsinfoDAO.getInstance();
        reservationDTO rdto = mdao.selectAsinfobyres_id(res_id);
        request.setAttribute("rdto", rdto);
        RequestDispatcher rd = request.getRequestDispatcher("asInfo/managerasinfoUpdate.jsp");
        rd.forward(request, response);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        String res_date = request.getParameter("res_date");
        String res_time = request.getParameter("res_time");
        int res_id = Integer.parseInt(request.getParameter("res_id"));
        
        reservationDTO dto = new reservationDTO();
        dto.setRes_date(res_date);
        dto.setRes_time(res_time);
        dto.setRes_id(res_id);
        
        managerAsinfoDAO adao = managerAsinfoDAO.getInstance();
        adao.updateAsinfo(dto);
        
        response.sendRedirect("managerasinfoUpdate.do");    
    }

}
