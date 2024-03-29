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
	
	public membershipDTO selectAll(String email){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql= "select *  from membership where email= ?";
		/*String sql= "select * from membership order by email desc";*/
		membershipDTO mdto = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			//System.out.println(rs);
			while(rs.next()) {
				//System.out.println("이동");
				mdto = new membershipDTO();
				mdto.setEmail(rs.getString("email"));
				mdto.setPw(rs.getString("pw"));
				mdto.setName(rs.getString("name"));
				mdto.setPhone(rs.getString("phone"));
				//System.out.println(mdto.getName());
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}return mdto;
		
		
	}
	
	public membershipDTO selectByCode(String email) {
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
	
	public int compare (String email) {
		int result = 1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from reservation where email=?";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = 0;
			}else {
				result = 1;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}return result;
	}
	
	
	
	
	
	
	public void insertas(reservationDTO rdto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into reservation(asitem,email,res_date,res_time,name) values(?,?,?,?,?)";
		
		//System.out.println("dao 연결 옴");
		//System.out.println(email);
		try {
			//System.out.println(rdto.getAsitem());
			//System.out.println(rdto.getRes_date());
			//System.out.println(rdto.getRes_time());
			//System.out.println(rdto.getName());
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, rdto.getAsitem());
			pstmt.setString(2, rdto.getEmail());
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
	
	public reservationDTO selectChangeByCode(String email) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from reservation where email=?";
		reservationDTO rdto = null;
		membershipDTO membership = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				rdto = new reservationDTO();
				rdto.setAsitem(rs.getString("asitem"));
				rdto.setEmail(rs.getString("email"));
				rdto.setRes_date(rs.getString("res_date"));
				rdto.setRes_time(rs.getString("res_time"));
				rdto.setName(rs.getString("name"));
				rdto.setRes_id(rs.getInt("res_id"));
				 
				membership = new membershipDTO();
		        membership.setEmail(rs.getString("asitem"));
		        membership.setName(rs.getNString("name"));
				
				rdto.setMembership(membership);
				System.out.println("연결 완료");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}return rdto;
		
	}
	
	
	public void updateas(reservationDTO rdto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql ="update reservation set asitem = ?, res_date = ?, res_time = ? where email= ?";
		try {
			
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, rdto.getAsitem());
			pstmt.setString(2, rdto.getRes_date());
			pstmt.setString(3, rdto.getRes_time());
			pstmt.setString(4, rdto.getEmail());
			
			System.out.println(rdto.getAsitem());
			System.out.println(rdto.getRes_date());
			System.out.println(rdto.getRes_time());
			System.out.println(rdto.getEmail());
			pstmt.executeUpdate();
			System.out.println("연결");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		
	}
	
}
