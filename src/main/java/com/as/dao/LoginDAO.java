package com.as.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.DBManager;

public class LoginDAO {
	
	private LoginDAO() {
		
	}
	private static LoginDAO instance = new LoginDAO();
	
	public static LoginDAO getInstance() {
		return instance;
	}
	
	//회원 정보 확인(DB) - 로그인
	public int userCheck(String email, String pwd, int admin) {
		int result = 1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from membershop where email=?";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, email);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				//비밀번호 일치
				if(pwd.equals(rs.getString("pwd"))) {
					//회원 등급
					if(admin == rs.getInt("admin")) {
						result = 2;   //관리자 로그인 성공
						if(admin == 1) {
							result = 3;  //일반 회원 로그인 성공
						}
					}
				}else {
					result = 0;    //비밀번호 맞지 않을 때
				}
			}else {
				result = -1;     //아이디 존재하지 않을 때
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				DBManager.close(conn, pstmt, rs);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
