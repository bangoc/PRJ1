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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.product.Product;

/**
 *
 * @author leo
 */
public class ConnectProduct {
    public static void saveChangedSaleProduct(Product product) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            String query = "update product set sale_off = ? where id = ?";
            con = ConnectDatabase.createConnect();
            ps = con.prepareStatement(query);
            
            ps.setInt(1, product.getSaleOff());
            ps.setInt(2, product.getProductId());
            
            ps.executeUpdate();
        } catch (IOException | ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ConnectProduct.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "System error!");
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConnectProduct.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConnectProduct.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public static void saveChangedSold(Connection con, int product_id, int amount) {
        PreparedStatement ps = null;
        try {
            String query = "update product set sold = (sold + ?) where id = ?";
            
            ps = con.prepareStatement(query);
            
            ps.setInt(1, amount);
            ps.setInt(2, product_id);
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectProduct.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "System error!");
            
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConnectProduct.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
    }
    
}
