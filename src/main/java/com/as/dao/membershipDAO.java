package com.as.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.as.dto.membershipDTO;

import util.DBManager;

	public class membershipDAO {
		private membershipDAO() {
			
		}
		
		private static membershipDAO instance = new membershipDAO();
		
		public static membershipDAO getInstance() {
			return instance;
		}
		
		// 예약 리스트 출력
		public List<membershipDTO> selectAllMemberships(){
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			String sql = "select * from membership order by desc";
			
			List<membershipDTO> list = new ArrayList<membershipDTO>();
			
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					membershipDTO mdto = new membershipDTO();
					mdto.setEmail(rs.getString("email"));
					mdto.setPw(rs.getString("pw"));
					mdto.setName(rs.getString("name"));
					mdto.setPhone(rs.getString("phone"));
					mdto.setRes_id(rs.getInt("res_id"));
					
					list.add(mdto);
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
		
		// 예약 등록
		public int insertMembership(membershipDTO mdto) {
			int result = -1;
			Connection conn = null;
			PreparedStatement pstmt = null;
			
			String sql = "insert into membership(email,pw,name,phone) values(?,?,?,?);";
			
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, mdto.getEmail());
				pstmt.setString(2, mdto.getPw());
				pstmt.setString(3, mdto.getName());
				pstmt.setString(4, mdto.getPhone());
				//pstmt.setInt(5,mdto.getAdmin());
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			}
			return result;
		}
		
		// 예약 리스트 수정
		public membershipDTO selectMembershipByRes_id(String res_id) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			membershipDTO mdto = null;
			String sql = "select * from membership where res_id=?";
			
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, res_id);
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					mdto = new membershipDTO();
					mdto.setEmail(rs.getString("email"));
					mdto.setPw(rs.getString("pw"));
					mdto.setName(rs.getString("name"));
					mdto.setPhone(rs.getString("phone"));
					mdto.setRes_id(rs.getInt("res_id"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
			return mdto;
		}
		
		// 예약 update
		public void updateMembership(membershipDTO mdto) {
			String sql = "update membership set email=?, pw=?, name=?, phone=? where res_id=?";
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, mdto.getEmail());
				pstmt.setString(2, mdto.getPw());
				pstmt.setString(3, mdto.getName());
				pstmt.setString(4, mdto.getPhone());
				pstmt.setInt(5, mdto.getRes_id());
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			}
		}
		
		// 예약 delete
		public void deleteMembership(String res_id) {
			String sql = "delete from membership where res_id=?";
			
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
