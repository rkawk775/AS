package com.as.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.as.dto.membershipDTO;
import com.as.dto.reservationDTO;

import util.DBManager;

public class AsinfoDAO {

	private AsinfoDAO() {

	}

	private static AsinfoDAO instance = new AsinfoDAO();

	public static AsinfoDAO getInstance() {

		return instance;

	}

	public List<reservationDTO> selectUserAsinfo() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT r.*, m.phone, m.email FROM reservation r JOIN membership m ON r.name = m.name ORDER BY r.res_id DESC";

		List<reservationDTO> aslist = new ArrayList<reservationDTO>();

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				reservationDTO rdto = new reservationDTO();
				membershipDTO mdto = new membershipDTO();
				rdto.setAsitem(rs.getString("asitem"));
				rdto.setRes_date(rs.getDate("res_date"));
				rdto.setRes_time(rs.getString("res_time"));
				rdto.setName(rs.getString("name"));
				rdto.setRes_id(rs.getInt("res_id"));
				mdto.setPhone(rs.getString("phone"));
				mdto.setEmail(rs.getString("email"));
				rdto.setMembership(mdto);

				aslist.add(rdto);

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
		return aslist;
	}

	public reservationDTO selectAsinfobyres_id(String res_id) {

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

			if (rs.next()) {
				rdto = new reservationDTO();
				rdto.setRes_id(rs.getInt("res_id"));
				rdto.setAsitem(rs.getString("asitem"));
				rdto.setRes_date(rs.getDate("res_date"));
				rdto.setRes_time(rs.getString("res_time"));
				rdto.setName(rs.getString("name"));			
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return rdto;
	}

	public void deleteAsinfo(String res_id) {

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
