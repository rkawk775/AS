package com.as.controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.as.dao.JoinDAO;
import com.as.dto.membershipDTO;

import util.DBManager;

/**
 * Servlet implementation class joinServlet
 */
@WebServlet("/join.do")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("ASMember/join.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		Connection conn = DBManager.getConnection();
		
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		
		membershipDTO mdto = new membershipDTO();
		mdto.setEmail(email);
		mdto.setPw(pw);
		mdto.setName(name);
		mdto.setPhone(phone);
		
		JoinDAO jdao = JoinDAO.getInstance();
		int result = jdao.insertJoin(mdto);
		
		HttpSession session = request.getSession();
		if(result == 1) {
			session.setAttribute("email", mdto.getEmail());
			request.setAttribute("message", "회원가입에 성공 했습니다.");
		}else {
			request.setAttribute("message", "회원가입에 실패하였습니다.");
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("login/login.jsp");
		rd.forward(request, response);
	}

}
