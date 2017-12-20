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
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.MyUtils.MyDate;
import model.employee.Salesman;
import model.product.ExportItem;
import model.product.Product;

/**
 *
 * @author leo
 */
public class ConnectExportItem {
    public static ExportItem createExportItem(Salesman salesman, int id, int quantity) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String query = "select product.* from product, import_item "
                    + "where product.id = ? and product.id = import_item.product_id and (product.sold + ?) <= import_item.quantity";
            con = ConnectDatabase.createConnect();
            ps = con.prepareStatement(query);
            
            ps.setInt(1, id);
            ps.setInt(2, quantity);
            
            rs = ps.executeQuery();
            
            while (rs.next()) {
                ExportItem it = new ExportItem(new Product(rs.getInt(1), rs.getString(2),
                        rs.getInt(3), rs.getString(4), MyDate.parseDateString(rs.getString(5)),
                        MyDate.parseDateString(rs.getString(6)), rs.getInt(7)), quantity, salesman);
                con.close();
                return it;
            }


        } catch (IOException | ClassNotFoundException | SQLException | ParseException ex) {
            Logger.getLogger(ConnectExportItem.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "System error!");
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
        return null;
    }
    
}
