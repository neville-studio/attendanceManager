package com.attendance.util;

import java.sql.*;

public class DB {
    private static String driver ="com.mysql.cj.jdbc.Driver";
    private static String url="jdbc:mysql://localhost:3306/attendance";
    private static String user="root";
    private static String password="1234";
    static
    {
        try
        {
            Class.forName(driver);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public static Connection getConnection ()
    {

        try {
            return DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void close(Connection conn, ResultSet res)
    {
        try {
            if (res != null)
                res.close();
            if (conn != null)
                conn.close();
        }catch(Exception e)
        {
            e.printStackTrace();
        }

    }
}
