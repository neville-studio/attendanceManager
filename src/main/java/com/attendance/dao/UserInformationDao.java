package com.attendance.dao;

import com.attendance.bean.UserInformation;
import com.attendance.util.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
            PreparedStatement preStmt = conn.prepareStatement("UPDATE userInformation SET name=?,department=?,degree=?,sex=?,work=? WHERE account=?");
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
    public static UserInformation[] getUsersInfo(String name)
    {
        ArrayList<UserInformation> userInformationArrayList = new ArrayList<>();
        ResultSet res = null;
        Connection conn = DB.getConnection();
        try {
            PreparedStatement preStmt = conn.prepareStatement("SELECT * FROM userInformation WHERE name LIKE ?");
            preStmt.setString(1, "%" + name + "%");
            res = preStmt.executeQuery();
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
            UserInformation[] result=new UserInformation[userInformationArrayList.size()];
            userInformationArrayList.toArray(result);
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally
        {
            DB.close(conn,res);
        }
    }

    public static UserInformation getUserInfo(String name)
    {
        return getUsersInfo(name)[0];
    }
}
