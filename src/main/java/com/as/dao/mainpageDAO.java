package com.as.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.as.dto.membershipDTO;
import com.as.dto.reservationDTO;

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
		
		String sql= "select * from membership order by email desc";
		List<membershipDTO> list = new ArrayList<membershipDTO>();
		
		try {
			System.out.println("연결 완료");
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			//System.out.println(rs);
			while(rs.next()) {
				//System.out.println("이동");
				membershipDTO mdto = new membershipDTO();
				mdto.setEmail(rs.getString("email"));
				mdto.setPw(rs.getString("pw"));
				mdto.setName(rs.getString("name"));
				mdto.setPhone(rs.getString("phone"));
				list.add(mdto);
				//System.out.println(mdto.getName());
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}return list;
		
		
	}
	
	public membershipDTO selectMovieByCode(String email) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from membership where email=?";
		membershipDTO mdto = null;
		//System.out.println(email);
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			//System.out.println(rs.toString());
			if(rs.next()) {
				//System.out.println("값 들어옴");
				mdto = new membershipDTO();
				mdto.setEmail(rs.getString("email"));
				mdto.setName(rs.getString("name"));
				mdto.setPhone(rs.getString("phone"));
				mdto.setPw(rs.getString("pw"));
				//mdto.setRes_id(rs.getInt("res_id"));
				//System.out.println(mdto.getEmail());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}return mdto;
		
	}
	
	
	public void insertas(reservationDTO rdto, String email) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into reservation(asitem,email,res_date,res_time,name) values(?,?,?,?,?)";
		
		System.out.println("dao 연결 옴");
		System.out.println(email);
		try {
			System.out.println(rdto.getAsitem());
			System.out.println(rdto.getRes_date());
			System.out.println(rdto.getRes_time());
			System.out.println(rdto.getName());
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, rdto.getAsitem());
			pstmt.setString(2, email);
			pstmt.setString(3, rdto.getRes_date());
			pstmt.setString(4, rdto.getRes_time());
			pstmt.setString(5, rdto.getName());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		
	}
	
}
