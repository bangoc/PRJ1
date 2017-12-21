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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.MyUtils.MyDate;
import model.market.Cost;
import model.market.Supplier;

/**
 *
 * @author leo
 */
public class ConnectMarket {
    public static void saveCost(Cost cost) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            String query = "insert into costs_incurred (id, name, total, paid_date) values (null, ?, ?, ?)";
            con = ConnectDatabase.createConnect();
            
            ps = con.prepareStatement(query);
            ps.setString(1, cost.getCostName().toString());
            ps.setInt(2, cost.getTotal());
            ps.setString(3, MyDate.formatDate(cost.getDate()));
            
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "OK");
        } catch (IOException | ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ConnectMarket.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "System error!");
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConnectMarket.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConnectMarket.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public static ArrayList<Supplier> getSuppliers() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String query = "select * from supplier";
            con = ConnectDatabase.createConnect();
            ps = con.prepareStatement(query);
            
            
            rs = ps.executeQuery();
            
            ArrayList<Supplier> list = new ArrayList<>();
            while (rs.next()) {
                list.add(new Supplier(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
            }
            
            
            
            return list;
        } catch (IOException | ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ConnectMarket.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "System error!");
            return null;
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConnectAccount.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConnectAccount.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConnectAccount.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
