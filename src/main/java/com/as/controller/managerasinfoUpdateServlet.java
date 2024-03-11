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
        
        // JSP 파일에서 전송된 데이터 받기
        String res_date = request.getParameter("res_date");
        String res_time = request.getParameter("res_time");
        int res_id = Integer.parseInt(request.getParameter("res_id"));
        
        // 받은 데이터를 DTO 객체에 설정
        reservationDTO rdto = new reservationDTO();
        rdto.setRes_date(res_date);
        rdto.setRes_time(res_time);
        rdto.setRes_id(res_id);
        
        // DAO를 사용하여 데이터베이스 업데이트
        managerAsinfoDAO mdao = managerAsinfoDAO.getInstance();
        mdao.updateAsinfo(rdto);
        
        // 업데이트 후에는 다시 예약 목록 페이지로 이동
        response.sendRedirect("reservationList.do"); 
    }
}