package com.as.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.as.dto.membershipDTO;

import util.DBManager;

public class mainpageDAO {
	public mainpageDAO() {
		// TODO Auto-generated constructor stub
	}
	
	private static mainpageDAO instance = new mainpageDAO();
	public static mainpageDAO getInstance() {
		return instance;
	}
	
	public List<membershipDTO> selectAll(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql= "select * from membership order by res_id desc";
		List<membershipDTO> list = new ArrayList<membershipDTO>();
		
		try {
			System.out.println("연결 완료");
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			System.out.println(rs);
			while(rs.next()) {
				System.out.println("이동");
				membershipDTO mdto = new membershipDTO();
				mdto.setRes_id(rs.getInt("res_id"));
				mdto.setEmail(rs.getString("email"));
				mdto.setPw(rs.getString("pw"));
				mdto.setName(rs.getString("name"));
				mdto.setPhone(rs.getString("phone"));
				list.add(mdto);
				System.out.println(mdto.getName());
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}return list;
		
		
	}
	
	public membershipDTO selectMovieByCode(String res_id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from membership where res_id=?";
		membershipDTO mdto = null;
		System.out.println(res_id);
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, res_id);
			rs = pstmt.executeQuery();
			System.out.println(rs.toString());
			if(rs.next()) {
				System.out.println("값 들어옴");
				mdto = new membershipDTO();
				mdto.setEmail(rs.getString("email"));
				mdto.setName(rs.getString("name"));
				mdto.setPhone(rs.getString("phone"));
				mdto.setPw(rs.getString("pw"));
				mdto.setRes_id(rs.getInt("res_id"));
				System.out.println(mdto.getEmail());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}return mdto;
		
		
		
	}
	
	
}
