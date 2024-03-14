package com.as.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.as.dto.reservationDTO;

import util.DBManager;

public class managerAsinfoDAO {

    private managerAsinfoDAO() {

    }

    private static managerAsinfoDAO instance = new managerAsinfoDAO();

    public static managerAsinfoDAO getInstance() {
        return instance;
    }

    public List<reservationDTO> selectAllUserAsinfo() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<reservationDTO> reservationList = new ArrayList<>();

        String sql = "SELECT r.*, m.phone FROM reservation r JOIN membership m ON r.email = m.email";

        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                reservationDTO rdto = new reservationDTO();
                rdto.setAsitem(rs.getString("asitem"));
                rdto.setRes_date(rs.getString("res_date"));
                rdto.setRes_time(rs.getString("res_time"));
                rdto.setEmail(rs.getString("email"));
                rdto.setName(rs.getString("name"));
                rdto.setRes_id(rs.getInt("res_id"));
                rdto.setPhone(rs.getString("phone"));
                reservationList.add(rdto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(conn, pstmt, rs);
        }
        return reservationList;
    }

    public reservationDTO selectUserAsinfoByEmail(String email) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        reservationDTO rdto = null;

        String sql = "SELECT r.*, m.phone FROM reservation r JOIN membership m ON r.email = m.email WHERE r.email=?";

        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, email);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                rdto = new reservationDTO();
                rdto.setAsitem(rs.getString("asitem"));
                rdto.setRes_date(rs.getString("res_date"));
                rdto.setRes_time(rs.getString("res_time"));
                rdto.setEmail(rs.getString("email"));
                rdto.setName(rs.getString("name"));
                rdto.setRes_id(rs.getInt("res_id"));
                rdto.setPhone(rs.getString("phone"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(conn, pstmt, rs);
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
                rdto.setPhone(rs.getString("phone"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(conn, pstmt, rs);
        }

        return rdto;
    }

    public void updateAsinfo(reservationDTO rdto) {
        String sql = "UPDATE reservation SET res_date=?, res_time=? WHERE res_id=?";
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            
            // 문자열로 설정
            pstmt.setString(1, rdto.getRes_date());
            pstmt.setString(2, rdto.getRes_time());

            pstmt.setInt(3, rdto.getRes_id());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(conn, pstmt);
        }
    }
}