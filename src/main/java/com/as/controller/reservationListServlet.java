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
import com.as.dao.reservationDAO;
import com.as.dto.reservationDTO;

/**
 * Servlet implementation class reservationListServlet
 */
@WebServlet("/reservationList.do")
public class reservationListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public reservationListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	
    	reservationDAO rdao = reservationDAO.getInstance();
        String searchText = request.getParameter("textSearch");

        List<reservationDTO> reservationList = null;

        if (searchText != null && !searchText.isEmpty()) {
            reservationList = rdao.selectSearchResultReservationsWithMembership(searchText);
        } else {
            reservationList = rdao.selectAllReservationsWithMembership();
        }
        
        // 삭제 요청 처리
        String deleteEmail = request.getParameter("email");
        if (deleteEmail != null) {
            rdao.deleteReservation(deleteEmail); // email을 이용한 삭제 처리 코드
            reservationList = rdao.selectAllReservationsWithMembership();
        }

        request.setAttribute("reservationList", reservationList);
        RequestDispatcher rd = request.getRequestDispatcher("reservation/reservationList.jsp");
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
