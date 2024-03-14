package com.as.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.as.dto.reservationDTO;

import util.DBManager;

public class AsinfoDAO {

	private AsinfoDAO() {

	}

	private static AsinfoDAO instance = new AsinfoDAO();

	public static AsinfoDAO getInstance() {

		return instance;

	}

	public reservationDTO selectUserAsinfo(String email) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		reservationDTO rdto =null;

		String sql = "SELECT r.*, m.phone FROM reservation r JOIN membership m ON r.email = m.email WHERE r.email=?";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			//System.out.println("dd");
			pstmt.setString(1, email);
			//System.out.println("aa");
			rs = pstmt.executeQuery();
			//System.out.println("aa");
			if(rs.next()) {
				//System.out.println("aa");
				rdto = new reservationDTO();
				//System.out.println("aa");
				rdto.setAsitem(rs.getString("asitem"));
				rdto.setRes_date(rs.getString("res_date"));
				rdto.setRes_time(rs.getString("res_time"));
				rdto.setEmail(rs.getString("email"));
				rdto.setName(rs.getString("name"));
				rdto.setRes_id(rs.getInt("res_id"));
				//System.out.println(rdto.getRes_id());
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
		return rdto;
	}

	public reservationDTO selectAsinfobyres_id(String res_id) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		reservationDTO rdto = null;
		String sql = "SELECT r.*, m.phone FROM reservation r JOIN membership m ON r.email = m.email WHERE res_id=?";

		try {

			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, res_id);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				rdto = new reservationDTO();
				rdto.setAsitem(rs.getString("asitem"));
				rdto.setRes_date(rs.getString("res_date"));
				rdto.setRes_time(rs.getString("res_time"));
				rdto.setName(rs.getString("name"));
				rdto.setRes_id(rs.getInt("res_id"));		
				rdto.setEmail(rs.getString("email"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return rdto;
	}

	public void deleteAsinfo(String res_id) {

		String sql = "DELETE FROM reservation where res_id=?";
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
