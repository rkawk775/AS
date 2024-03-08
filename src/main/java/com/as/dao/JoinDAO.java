package com.as.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.as.dto.membershipDTO;

import util.DBManager;

public class JoinDAO {
	
	private JoinDAO() {
		
	}
	private static JoinDAO instance = new JoinDAO();
	
	public static JoinDAO getInstance() {
		return instance;
	}
	
	public int insertJoin(membershipDTO mdto) {
		int result = 1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "insert into membership(email,pw,name,phone) values(?,?,?,?)";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mdto.getEmail());
			pstmt.setString(2, mdto.getPw());
			pstmt.setString(3, mdto.getName());
			pstmt.setString(4, mdto.getPhone());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return result;
	}
}
