package com.attendance.dao;

import com.attendance.bean.Record;
import com.attendance.bean.RecordView;
import com.attendance.util.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class RecordViewDao {
    public static RecordView[] findAllRecords(String q){
        Connection conn = DB.getConnection();
        ResultSet resultSet = null;
        ArrayList<RecordView> records = new ArrayList<>();
        try
        {
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM recordview WHERE name like ?");
            preparedStatement.setString(1,"%"+q+"%");
            resultSet=preparedStatement.executeQuery();
            while(resultSet.next())
            {
                RecordView record = new RecordView();
                record.setAccount(resultSet.getString(1));
                record.setDate(resultSet.getLong(2));
                record.setName(resultSet.getString(3));
                record.setCometime(resultSet.getLong(4));
                record.setExitTime(resultSet.getLong(5));
                records.add(record);
            }
            RecordView[] rec = new RecordView[records.size()];
            records.toArray(rec);
            return rec;
        }catch (Exception e)
        {
            throw new RuntimeException(e);
        }finally {
            DB.close(conn,resultSet);
        }
    }
}
