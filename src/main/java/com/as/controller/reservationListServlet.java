package com.as.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		String searchText = request.getParameter("textSearch"); // 사용자가 입력한 검색어를 받아옴
		
		reservationDAO rdao = reservationDAO.getInstance();
		List<reservationDTO> reservationList = rdao.selectAllReservations();
		List<reservationDTO> reservationResultList = rdao.selectSearchResultReservations(searchText);
		
		request.setAttribute("reservationList", reservationList);
		request.setAttribute("reservationResultList", reservationResultList); // 검색 결과를 request에 저장하여 JSP 파일로 전달
		
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
