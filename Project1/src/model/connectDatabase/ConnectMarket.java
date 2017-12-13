/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.connectDatabase;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.MyUtils.MyDate;
import model.market.Cost;
import model.market.Supplier;

/**
 *
 * @author leo
 */
public class ConnectMarket {
    public static void saveCost(Cost cost) throws IOException, ClassNotFoundException, SQLException {
        String query = "insert into costs_incurred (id, name, total, paid_date) values (null, ?, ?, ?)";
        Connection con = ConnectDatabase.createConnect();
        
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, cost.getCostName().toString());
        ps.setInt(2, cost.getTotal());
        ps.setString(3, MyDate.formatDate(cost.getDate()));
        
        ps.executeUpdate();
        
        con.close();
    }
    
    public static ArrayList<Supplier> getSuppliers() throws IOException, ClassNotFoundException, SQLException {
        String query = "select * from supplier";
        Connection con = ConnectDatabase.createConnect();
        PreparedStatement ps = con.prepareStatement(query);
        
        
        ResultSet rs = ps.executeQuery();
        
        ArrayList<Supplier> list = new ArrayList<>();
        while (rs.next()) {
            list.add(new Supplier(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
        }
        
        
        
        return list;
    }
}
