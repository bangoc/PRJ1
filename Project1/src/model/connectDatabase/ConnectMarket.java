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
    
    public static ArrayList<Supplier> getSuppliers() {
        Supplier s = new Supplier("ncc1", "ha noi", "a", "139320");
        s.setSupplierId(1);
        
        Supplier s1 = new Supplier("ncc2", "ha noi", "a", "139320");
        s1.setSupplierId(2);
        ArrayList<Supplier> list = new ArrayList<>();
        list.add(s);
        list.add(s1);
        
        
        return list;
    }
}
