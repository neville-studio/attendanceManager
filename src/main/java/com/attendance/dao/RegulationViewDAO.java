package com.attendance.dao;

import com.attendance.bean.RegulationView;
import com.attendance.util.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class RegulationViewDAO {
    public static RegulationView[] findRegulations(String name){
        Connection conn = DB.getConnection();
        ResultSet resultSet = null;
        ArrayList <RegulationView> regulationViews = new ArrayList<>();
        try
        {
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM editregulation WHERE name LIKE ?");
            preparedStatement.setString(1,"%"+name+"%");
            resultSet=preparedStatement.executeQuery();
            while(resultSet.next())
            {
                RegulationView regulationView = new RegulationView();
                regulationView.setAccount(resultSet.getString(1));
                regulationView.setName(resultSet.getString(2));
                regulationView.setComeTime(resultSet.getLong(3));
                regulationView.setExitTime(resultSet.getLong(4));
                regulationViews.add(regulationView);
            }
            RegulationView regulationViewRes[] = new RegulationView[regulationViews.size()];
            regulationViews.toArray(regulationViewRes);
            return regulationViewRes;
        }catch (Exception e)
        {
            throw new RuntimeException(e);
        }finally {
            DB.close(conn,resultSet);
        }
    }
    public static RegulationView findRegulation(String name)
    {
        return findRegulations(name)[0];
    }
    public static RegulationView findRegulationByaccount(String account)
    {
        Connection conn = DB.getConnection();
        ResultSet resultSet = null;
        RegulationView regulationView = null;
        try
        {
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM editregulation WHERE account= ?");
            preparedStatement.setString(1,account);
            resultSet=preparedStatement.executeQuery();
            while(resultSet.next())
            {
                regulationView = new RegulationView();
                regulationView.setAccount(resultSet.getString(1));
                regulationView.setName(resultSet.getString(2));
                regulationView.setComeTime(resultSet.getLong(3));
                regulationView.setExitTime(resultSet.getLong(4));
            }
            return regulationView;
        }catch (Exception e)
        {
            throw new RuntimeException(e);
        }finally {
            DB.close(conn,resultSet);
        }

    }
}
