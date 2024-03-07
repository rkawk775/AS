package com.as.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.as.dao.LoginDAO;
import com.as.dto.membershipDTO;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/login.do")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("login/login.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		/*
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		int admin = Integer.parseInt(request.getParameter("admin"));
		
		String url = null;
		
		
		LoginDAO ldao = LoginDAO.getInstance();
		int result = ldao.userCheck(email, pwd, admin);
		
		//아이디와 패스워드 일치 후 권한 체크
		if(result == 2 || result == 3) {
			membershipDTO mdto = new membershipDTO();
			mdto = ldao.getMember(email);
			
			HttpSession session = request.getSession();
			session.setAttribute("email", mdto);
			session.setAttribute("result", result);
			
			url = "application.do";
		}else {
			url = "login.jsp";
			if(result == 1) {
				request.setAttribute("message", "권한 선택이 잘못되었습니다.");
			}else if(result == 0) {
				request.setAttribute("message", "비밀번호가 맞지 않습니다.");
			}else {
				request.setAttribute("message", "존재하지 않는 아이디입니다.");
			}
		}
		*/
		RequestDispatcher rd = request.getRequestDispatcher("login/login.jsp");
		rd.forward(request, response);
		
	}

}
