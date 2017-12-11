/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.connectDatabase;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.MyUtils.MyDate;
import model.market.Cost;

/**
 *
 * @author leo
 */
public class ConnectMarket {
    public void saveCost(Cost cost) throws IOException, ClassNotFoundException, SQLException {
        String query = "insert into costs_incurred (id, name, total, paid_date) values (null, ?, ?, ?)";
        Connection con = ConnectDatabase.createConnect();
        
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, cost.getCostName().toString());
        ps.setInt(2, cost.getTotal());
        ps.setString(3, MyDate.formatDate(cost.getDate()));
        
        ps.executeUpdate();
        
        con.close();
    }
}
