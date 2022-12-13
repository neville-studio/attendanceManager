package com.attendance.dao;

import com.attendance.bean.User;
import com.attendance.util.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    public static int Login(User user)
    {
        Connection conn = DB.getConnection();
        PreparedStatement prestmt = null;
        ResultSet res = null;
        try {
            prestmt = conn.prepareStatement("SELECT * FROM user where user.user=?");
            prestmt.setString(1,user.getUser());

            res = prestmt.executeQuery();
            if(res.next())
            {
                if(res.getString("password").equals(user.getPassword())){
                    user.setUser_type(res.getInt("user_type"));


                    return user.getUser_type();
                }else {
                    return -1;
                }

            }else{
                return -1;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DB.close(conn,res);
        }

    }




    public static int updatePassword(User user)
    {
        Connection conn = DB.getConnection();
        PreparedStatement prestmt = null;
        try {
            prestmt = conn.prepareStatement("UPDATE user SET password=? WHERE user.user=?");
            prestmt.setString(2,user.getUser());
            prestmt.setString(1,user.getPassword());
            int res = prestmt.executeUpdate();

            return res;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            DB.close(conn,null);
        }

    }
    public static int resetPassword(User user)
    {

        user.setPassword("123456");
        return updatePassword(user);

    }
    public static int createUser(User user)
    {
        Connection conn = DB.getConnection();
        PreparedStatement prestmt = null;
        try {
            prestmt = conn.prepareStatement("INSERT  INTO user VALUES (?,'123456',?)");
            prestmt.setString(1,user.getPassword());
            prestmt.setString(2,user.getUser());
            int res = prestmt.executeUpdate();
            return res;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            DB.close(conn,null);
        }
    }
    public static int deleteUser(User user)
    {
        Connection conn = DB.getConnection();
        PreparedStatement prestmt = null;
        try {
            prestmt = conn.prepareStatement("DELETE user WHERE user=?");
            prestmt.setString(1,user.getUser());
            int res = prestmt.executeUpdate();
            return res;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            DB.close(conn,null);
        }
    }
}
