package com.attendance.dao;

import com.attendance.bean.Regulation;
import com.attendance.bean.UserInformation;
import com.attendance.util.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RegulationDAO {
    public static void insertInfo(Regulation regulation)
    {
        Connection conn = DB.getConnection();
        try {
            PreparedStatement preStmt = conn.prepareStatement("INSERT INTO regulation VALUES (?,?,?)");
            preStmt.setString(1, regulation.getAccount());
            preStmt.setLong(2, regulation.getComeTime());
            preStmt.setLong(3, regulation.getExitTime());
            preStmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally
        {
            DB.close(conn,null);
        }

    }
    public static void editInfo(Regulation regulation)
    {
        Connection conn = DB.getConnection();
        try {
            PreparedStatement preStmt = conn.prepareStatement("UPDATE regulation SET comeTime=?,ExitTime=? WHERE account=?");
            preStmt.setString(3, regulation.getAccount());
            preStmt.setLong(1, regulation.getComeTime());
            preStmt.setLong(2, regulation.getExitTime());
            preStmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally
        {
            DB.close(conn,null);
        }
    }

    public static void deleteInfo(Regulation regulation)
    {
        Connection conn = DB.getConnection();
        try {
            PreparedStatement preStmt = conn.prepareStatement("DELETE FROM regulation WHERE account=?");
            preStmt.setString(1, regulation.getAccount());

            preStmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally
        {
            DB.close(conn,null);
        }
    }
    public static void editInfos(String type, long value)
    {
        Connection conn = DB.getConnection();
        try {
            PreparedStatement preStmt = conn.prepareStatement("UPDATE regulation SET "+type+"=?");
            preStmt.setLong(1, value);
            preStmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally
        {
            DB.close(conn,null);
        }
    }
}
