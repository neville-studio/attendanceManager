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
            preStmt.setString(4,userInfo.getDepartment());
            preStmt.setBoolean(5,userInfo.isSex());
            preStmt.setString(6, userInfo.getWork());
            preStmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
