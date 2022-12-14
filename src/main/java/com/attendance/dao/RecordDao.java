package com.attendance.dao;

import com.attendance.bean.Record;
import com.attendance.util.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RecordDao {
    public static void insertInfo(Record record)
    {
        Connection conn = DB.getConnection();
        try {
            PreparedStatement preStmt = conn.prepareStatement("INSERT INTO record VALUES (?,?,?,?,?)");
            preStmt.setString(1, record.getAccount());
            preStmt.setLong(2, record.getComeTime());
            preStmt.setLong(3, record.getExitTime());
            preStmt.setInt(4, record.getStatus());
            preStmt.setLong(5, record.getDate());
            preStmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally
        {
            DB.close(conn,null);
        }

    }
    public static void editInfo(Record record)
    {
        Connection conn = DB.getConnection();
        try {
            PreparedStatement preStmt = conn.prepareStatement("UPDATE record SET comeTime=?,ExitTime=?,status=?,Date=? WHERE account=?");
            preStmt.setString(5, record.getAccount());
            preStmt.setLong(4, record.getDate());

            preStmt.setInt(3, record.getStatus());
            preStmt.setLong(1, record.getComeTime());
            preStmt.setLong(2, record.getExitTime());
            preStmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally
        {
            DB.close(conn,null);
        }
    }
    public static Record[] findRecords(String name){
        Connection conn = DB.getConnection();
        ResultSet resultSet = null;
        ArrayList<Record> records = new ArrayList<>();
        try
        {
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM record WHERE account=?");
            preparedStatement.setString(1,name);
            resultSet=preparedStatement.executeQuery();
            while(resultSet.next())
            {
                Record record = new Record();
                record.setAccount(resultSet.getString(1));
                record.setStatus(resultSet.getInt(4));
                record.setComeTime(resultSet.getLong(2));
                record.setExitTime(resultSet.getLong(3));
                record.setDate(resultSet.getLong(5));
                records.add(record);
            }
            Record[] rec = new Record[records.size()];
            records.toArray(rec);
            return rec;
        }catch (Exception e)
        {
            throw new RuntimeException(e);
        }finally {
            DB.close(conn,resultSet);
        }
    }
    public static Record findRecord(String name)
    {
        return findRecords(name)[0];
    }public static Record getRecord(String user,long date)
    {
        Connection conn = DB.getConnection();
        ResultSet resultSet = null;
        try
        {
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM record WHERE account=? AND Date=?");
            preparedStatement.setString(1,user);
            preparedStatement.setLong(2,date);
            resultSet=preparedStatement.executeQuery();
            Record record = null;
            if(resultSet.next())
            {
                record = new Record();
                record.setAccount(resultSet.getString(1));
                record.setStatus(resultSet.getInt(4));
                record.setComeTime(resultSet.getLong(2));
                record.setExitTime(resultSet.getLong(3));
                record.setDate(resultSet.getLong(5));
            }
            return record;
        }catch (Exception e)
        {
            throw new RuntimeException(e);
        }finally {
            DB.close(conn,resultSet);
        }
    }

}
