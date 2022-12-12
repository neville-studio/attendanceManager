package com.attendance.dao;

import com.attendance.bean.UserInformation;
import com.attendance.util.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserInformationDao {
    public static void insertInfo(UserInformation userInfo)
    {
        Connection conn = DB.getConnection();
        try {
            PreparedStatement preStmt = conn.prepareStatement("INSERT INTO userinformation VALUES (?,?,?,?,?,?)");
            preStmt.setString(1, userInfo.getAccount());
            preStmt.setString(2, userInfo.getName());
            preStmt.setString(3, userInfo.getDepartment());
            preStmt.setString(4,userInfo.getDegree());
            preStmt.setBoolean(5,userInfo.isSex());
            preStmt.setString(6, userInfo.getWork());
            preStmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally
        {
            DB.close(conn,null);
        }

    }
    public static void editInfo(UserInformation userInfo)
    {
        Connection conn = DB.getConnection();
        try {
            PreparedStatement preStmt = conn.prepareStatement("SET name=?,department=?,degree=?,sex=?,work=? WHERE account=?");
            preStmt.setString(6, userInfo.getAccount());
            preStmt.setString(1, userInfo.getName());
            preStmt.setString(2, userInfo.getDepartment());
            preStmt.setString(3,userInfo.getDegree());
            preStmt.setBoolean(4,userInfo.isSex());
            preStmt.setString(5, userInfo.getWork());
            preStmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally
        {
            DB.close(conn,null);
        }
    }

    public static void deleteInfo(UserInformation userInfo)
    {
        Connection conn = DB.getConnection();
        try {
            PreparedStatement preStmt = conn.prepareStatement("DELETE name=?,department=?,degree=?,sex=?,work=? WHERE account=?");
            preStmt.setString(6, userInfo.getAccount());
            preStmt.setString(1, userInfo.getName());
            preStmt.setString(2, userInfo.getDepartment());
            preStmt.setString(3,userInfo.getDegree());
            preStmt.setBoolean(4,userInfo.isSex());
            preStmt.setString(5, userInfo.getWork());
            preStmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally
        {
            DB.close(conn,null);
        }
    }
}
