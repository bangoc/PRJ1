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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.MyUtils.MyDate;
import model.product.ExportItem;
import model.product.ExportReceipt;

/**
 *
 * @author leo
 */
public class ConnectExportReceipt {
    public static void saveNewExportReceipt(ExportReceipt receipt) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String query = "insert into export_receipt (id, date, total) "
                    + "values (null, ?, ?)";
            con = ConnectDatabase.createConnect();
            ps = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            
            ps.setString(1, MyDate.formatDate(receipt.getTime()));
            ps.setInt(2, receipt.getTotal());
            
            ps.executeUpdate();
            
            rs = ps.getGeneratedKeys();
            int id = 0;
            while (rs.next()) {
                id = rs.getInt(1);
            }
            
            receipt.setCode(id);
            for (ExportItem it : receipt.getItems()) {
                ConnectProduct.saveChangedSold(con, it.getProduct().getProductId(), it.getAmount());
                saveExportItem(id, it, con);
                
            }
            
        } catch (IOException | ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ConnectExportReceipt.class.getName()).log(Level.SEVERE, null, ex);
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
    }
    
    public static void saveExportItem(int receiptId, ExportItem item, Connection con) {
        PreparedStatement ps = null;
        try {
            String query = "insert into export_item (id_receipt, id_product, sale_id, amount, price) "
                    + "values (?, ?, ?, ?, ?)";
            ps = con.prepareStatement(query);
            
            ps.setInt(1, receiptId);
            ps.setInt(2, item.getProduct().getProductId());
            ps.setInt(3, item.getSalesman().getEmployeeId());
            ps.setInt(4, item.getAmount());
            ps.setInt(5, item.getPrice());
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectExportReceipt.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "System error!");
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConnectAccount.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
           
        }
    }
}
