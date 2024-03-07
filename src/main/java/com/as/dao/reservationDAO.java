package com.as.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.as.dto.membershipDTO;
import com.as.dto.reservationDTO;

import util.DBManager;

public class reservationDAO {
	private reservationDAO() {
		
	}
	
	private static reservationDAO instance = new reservationDAO();
	
	public static reservationDAO getInstance() {
		return instance;
	}
	
	// 예약 리스트 출력
	public List<reservationDTO> selectAllReservationsWithMembership(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT r.*, m.phone, m.email FROM reservation r JOIN membership m ON r.name = m.name ORDER BY r.res_id";
		
		List<reservationDTO> list = new ArrayList<reservationDTO>();
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				reservationDTO rdto = new reservationDTO();
				membershipDTO mdto = new membershipDTO();
				rdto.setAsitem(rs.getString("asitem"));
	            rdto.setRes_date(rs.getDate("res_date"));
	            rdto.setRes_time(rs.getString("res_time"));
	            rdto.setName(rs.getString("name"));
	            rdto.setRes_id(rs.getInt("res_id"));
	            mdto.setPhone(rs.getString("phone")); // membership 테이블의 phone 컬럼
	            mdto.setEmail(rs.getString("email")); // membership 테이블의 email 컬럼
	            
	            rdto.setMembership(mdto);
				
				list.add(rdto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DBManager.close(conn, pstmt, rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	// 예약 검색 결과 리스트 출력
	public List<reservationDTO> selectSearchResultReservationsWithMembership(String searchText) {
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    List<reservationDTO> list = new ArrayList<reservationDTO>();
	    
	    try {
	        conn = DBManager.getConnection();
	        String sql = "SELECT r.*, m.phone, m.email FROM reservation r JOIN membership m ON r.name = m.name WHERE r.name=? ORDER BY r.res_id DESC";
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, searchText);
	        rs = pstmt.executeQuery();
	        
	        while(rs.next()) {
	            reservationDTO rdto = new reservationDTO();
	            membershipDTO mdto = new membershipDTO();
	            
	            rdto.setAsitem(rs.getString("asitem"));
	            rdto.setRes_date(rs.getDate("res_date"));
	            rdto.setRes_time(rs.getString("res_time"));
	            rdto.setName(rs.getString("name"));
	            rdto.setRes_id(rs.getInt("res_id"));
	            mdto.setPhone(rs.getString("phone")); // membership 테이블의 phone 컬럼
	            mdto.setEmail(rs.getString("email")); // membership 테이블의 email 컬럼
	            
	            rdto.setMembership(mdto);
	            
	            list.add(rdto);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            DBManager.close(conn, pstmt, rs);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    return list;
	}
	
	// 예약 리스트 수정
	public reservationDTO selectReservationByRes_id(String name) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		reservationDTO rdto = null;
		String sql = "select * from reservation where name=?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				rdto = new reservationDTO();
				rdto.setAsitem(rs.getString("asitem"));
				rdto.setRes_date(rs.getDate("res_date"));
				rdto.setRes_time(rs.getString("res_time"));
				rdto.setName(rs.getString("name"));
				rdto.setRes_id(rs.getInt("res_id"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return rdto;
	}
	
	// 예약 update
	public void updateReservation(reservationDTO rdto) {
		String sql = "update reservation set asitem=?, res_date=?, res_time=?, name=? where res_id=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, rdto.getAsitem());
			pstmt.setDate(2, rdto.getRes_date());
			pstmt.setString(3, rdto.getRes_time());
			pstmt.setString(4, rdto.getName());
			pstmt.setInt(6, rdto.getRes_id());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	// 예약 delete
	public void deleteReservation(String name) {
		String sql = "delete from reservation where name=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
}
