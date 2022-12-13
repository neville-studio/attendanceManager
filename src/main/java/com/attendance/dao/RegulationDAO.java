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
            PreparedStatement preStmt = conn.prepareStatement("INSERT INTO Regulation VALUES (?,?,?)");
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
            PreparedStatement preStmt = conn.prepareStatement("UPDATE FROM attendance SET comeTime=?,ExitTime=? WHERE account=?");
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

    public static void deleteInfo(UserInformation userInfo)
    {
        Connection conn = DB.getConnection();
        try {
            PreparedStatement preStmt = conn.prepareStatement("DELETE FROM userInformation WHERE account=?");
            preStmt.setString(1, userInfo.getAccount());

            preStmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally
        {
            DB.close(conn,null);
        }
    }
    public UserInformation[] getUsersInfo(String name)
    {
        ArrayList<UserInformation> userInformationArrayList = new ArrayList<>();
        Connection conn = DB.getConnection();
        try {
            PreparedStatement preStmt = conn.prepareStatement("SELECT * FROM userInformation WHERE name LIKE ?");
            preStmt.setString(1, "%" + name + "%");
            ResultSet res = preStmt.executeQuery();
            while(res.next())
            {
                UserInformation userInfo = new UserInformation();
                userInfo.setAccount(res.getString(1));
                userInfo.setName(res.getString(2));
                userInfo.setDepartment(res.getString(3));
                userInfo.setDegree(res.getString(4));
                userInfo.setSex(res.getBoolean(5));
                userInfo.setWork(res.getString(6));
                userInformationArrayList.add(userInfo);
            }

            return (UserInformation[]) userInformationArrayList.toArray();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally
        {
            DB.close(conn,null);
        }
    }

    public UserInformation getUserInfo(String name)
    {
        return getUsersInfo(name)[0];
    }
}
