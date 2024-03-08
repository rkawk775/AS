package com.as.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.as.dto.membershipDTO;

import util.DBManager;

public class LoginDAO {
	
	private LoginDAO() {
		
	}
	private static LoginDAO instance = new LoginDAO();
	
	public static LoginDAO getInstance() {
		return instance;
	}
	
	
	//회원 정보(DB) - 로그인
	public int userCheck(String email, String pw, int admin) {
		int result = 1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from membership where email=?";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, email);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				//비밀번호 일치
				if(pw.equals(rs.getString("pw"))) {
					//회원 등급
					if(admin == rs.getInt("admin")) {
						result = 2;   //관리자 로그인 성공
						if(admin == 0) {
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
	
	/**/
	
	
	
	//이메일로 회원 정보 가져옴 (다시 수정) 
	public membershipDTO getMember(String email) {
		membershipDTO mdto = null;
		String sql = "select * from membership where email=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				mdto = new membershipDTO();
				mdto.setEmail(rs.getString("email"));
				mdto.setPw(rs.getString("pw"));
				mdto.setName(rs.getString("name"));
				mdto.setPhone(rs.getString("phone"));
				mdto.setAdmin(rs.getInt("admin"));
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
		return mdto;
	}
	
	
	
	
}
