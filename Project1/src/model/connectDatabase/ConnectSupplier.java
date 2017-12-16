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
import model.market.Supplier;

/**
 *
 * @author leo
 */
public class ConnectSupplier {
    public static void saveNewSupplier(Supplier supplier) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            String query = "insert into supplier "
                    + "(id, name, address, mail, phone_no) "
                    + "values (null, ?, ?, ?, ?)";
            con = ConnectDatabase.createConnect();
            ps = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            
            ps.setString(1, supplier.getName());
            ps.setString(2, supplier.getAddress());
            ps.setString(3, supplier.getEmail());
            ps.setString(4, supplier.getPhoneNumber());
            
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            int key = 0;
            while (rs.next()) {
                key = rs.getInt(1);
            }
            
            supplier.setSupplierId(key);
        } catch (IOException | ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ConnectSupplier.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConnectSupplier.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConnectSupplier.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public static void saveChangedSupplier(Supplier supplier) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            String query = "update supplier "
                    + "set name = ?, address = ?, mail = ?, phone_no = ? "
                    + "where id = ?";
            con = ConnectDatabase.createConnect();
            ps = con.prepareStatement(query);
            
            ps.setString(1, supplier.getName());
            ps.setString(2, supplier.getAddress());
            ps.setString(3, supplier.getEmail());
            ps.setString(4, supplier.getPhoneNumber());
            ps.setInt(5, supplier.getSupplierId());
            
            ps.executeUpdate();
            
        } catch (IOException | ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ConnectSupplier.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConnectSupplier.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConnectSupplier.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    } 
    
    public static ArrayList<Supplier> getSuppliers() {
        String query = "select * "
                + "from supplier";
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Supplier> suppliers = null;
        Supplier sup = null;
        try {
            con = ConnectDatabase.createConnect();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            suppliers = new ArrayList<>();
            
            while (rs.next()) {
                sup = new Supplier(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5));
                suppliers.add(sup);
            }
            
            
            
        } catch (IOException | ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ConnectSupplier.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConnectSupplier.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConnectSupplier.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConnectSupplier.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return suppliers;
    }
}
