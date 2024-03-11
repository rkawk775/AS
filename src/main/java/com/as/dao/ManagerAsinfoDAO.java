package com.as.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.as.dto.reservationDTO;

import util.DBManager;

public class ManagerAsinfoDAO {

    private ManagerAsinfoDAO() {

    }

    private static ManagerAsinfoDAO instance = new ManagerAsinfoDAO();

    public static ManagerAsinfoDAO getInstance() {
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

    public void deleteAsinfo(int res_id) {
        String sql = "DELETE FROM reservation WHERE res_id=?";
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, res_id);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(conn, pstmt);
        }
    }

    public void updateAsinfo(reservationDTO dto) {
        String sql = "UPDATE reservation SET res_date=?, res_time=? WHERE res_id=?";
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, dto.getRes_date());
            pstmt.setString(2, dto.getRes_time());
            pstmt.setInt(3, dto.getRes_id());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(conn, pstmt);
        }
    }
}