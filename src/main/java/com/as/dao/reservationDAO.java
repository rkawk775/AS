package com.as.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	public List<reservationDTO> selectAllReservations(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from reservation order by res_id";
		
		List<reservationDTO> list = new ArrayList<reservationDTO>();
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				reservationDTO rdto = new reservationDTO();
				rdto.setAsitem(rs.getString("asitem"));
				rdto.setRes_date(rs.getDate("res_date"));
				rdto.setRes_time(rs.getString("res_time"));
				rdto.setRes_name(rs.getString("res_name"));
				rdto.setRes_id(rs.getInt("res_id"));
				rdto.setPhone(rs.getString("phone"));
				rdto.setEmail(rs.getString("email"));
				
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
	public List<reservationDTO> selectSearchResultReservations(String searchText) {
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    List<reservationDTO> list = new ArrayList<reservationDTO>();
	    
	    try {
	        conn = DBManager.getConnection();
	        String sql = "select * from reservation where res_id=? order by res_id desc";
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, "%" + searchText + "%"); 
	        rs = pstmt.executeQuery();
	        
	        while(rs.next()) {
	            reservationDTO rdto = new reservationDTO();
	            rdto.setAsitem(rs.getString("asitem"));
	            rdto.setRes_date(rs.getDate("res_date"));
	            rdto.setRes_time(rs.getString("res_time"));
	            rdto.setRes_name(rs.getString("res_name"));
	            rdto.setRes_id(rs.getInt("res_id"));
	            rdto.setPhone(rs.getString("phone"));
	            rdto.setEmail(rs.getString("email"));
	            
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
	
	// 예약 등록
	public void insertReservation(reservationDTO rdto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "insert into reservation(asitem,res_date,res_time,res_name,phone,email) values(?,?,?,?,?,?)";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, rdto.getAsitem());
			pstmt.setDate(2, rdto.getRes_date());
			pstmt.setString(3, rdto.getRes_time());
			pstmt.setString(4, rdto.getRes_name());
			pstmt.setString(5, rdto.getPhone());
			pstmt.setString(6, rdto.getEmail());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	// 예약 리스트 수정
	public reservationDTO selectReservationByRes_id(String res_id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		reservationDTO rdto = null;
		String sql = "select * from reservation where res_id=?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, res_id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				rdto = new reservationDTO();
				rdto.setAsitem(rs.getString("asitem"));
				rdto.setRes_date(rs.getDate("res_date"));
				rdto.setRes_time(rs.getString("res_time"));
				rdto.setRes_name(rs.getString("res_name"));
				rdto.setRes_id(rs.getInt("res_id"));
				rdto.setPhone(rs.getString("phone"));
				rdto.setEmail(rs.getString("email"));
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
		String sql = "update reservation set asitem=?, res_date=?, res_time=?, res_name=?, phone=?, email=? where res_id=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, rdto.getAsitem());
			pstmt.setDate(2, rdto.getRes_date());
			pstmt.setString(3, rdto.getRes_time());
			pstmt.setString(4, rdto.getRes_name());
			pstmt.setString(5, rdto.getPhone());
			pstmt.setString(6, rdto.getEmail());
			pstmt.setInt(6, rdto.getRes_id());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	// 예약 delete
	public void deleteReservation(String res_id) {
		String sql = "delete from reservation where res_id=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, res_id);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
}
