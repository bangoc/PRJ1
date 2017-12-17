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
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.MyUtils.MyDate;
import model.product.Product;
import model.product.ProductItem;

/**
 *
 * @author leo
 */
public class ConnectProductItem {
    public static final int GETALL = 1;
    public static final int GETSALE = 2;
    public static final int GETEXPIRE = 3;
    public static final int GET0QUANTITY = 4;
    public static final int GETTOPSALE = 5;
    
    public static ArrayList<ProductItem> getProductItem(int option) {
        switch(option) {
            case(1) :
                return getAll();
            case(2) :
                return getSale();
            case(3) : 
                return getExpire();
            case(4) :
                return get0Qunatity();
            case(5) :
                return getTopSale();
            default :
                return null;
                   
        }
       
    } 
    
    private static ArrayList<ProductItem> getAll() {
        Connection con = null;
        ArrayList<ProductItem> items = new ArrayList<>();
        try {
            String query = "select product.*, importer_id, supplier_id, quantity, import_price "
                    + "from product, import_item "
                    + "where product.id = import_item.product_id";
            con = ConnectDatabase.createConnect();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                items.add(new ProductItem(
                        new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4),
                        MyDate.parseDateString(rs.getString(5)), MyDate.parseDateString(rs.getString(6)), rs.getInt(7)), 
                        rs.getInt(8), rs.getInt(9), rs.getInt(10), rs.getInt(11), rs.getInt(12)));
            }
            
            return items;
        } catch (IOException | ClassNotFoundException | SQLException | ParseException ex) {
            Logger.getLogger(ConnectProductItem.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ConnectProductItem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    
    private static ArrayList<ProductItem> getSale() {
        Connection con = null;
        ArrayList<ProductItem> items = new ArrayList<>();
        try {
            String query = "select product.*, importer_id, supplier_id, quantity, import_price "
                    + "from product, import_item "
                    + "where product.id = import_item.product_id and product.sale_off > 0";
            con = ConnectDatabase.createConnect();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                items.add(new ProductItem(
                        new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4),
                        MyDate.parseDateString(rs.getString(5)), MyDate.parseDateString(rs.getString(6)), rs.getInt(7)), 
                        rs.getInt(8), rs.getInt(9), rs.getInt(10), rs.getInt(11), rs.getInt(12)));
            }
            
            return items;
        } catch (IOException | ClassNotFoundException | SQLException | ParseException ex) {
            Logger.getLogger(ConnectProductItem.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ConnectProductItem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    
    private static ArrayList<ProductItem> getExpire() {
        Connection con = null;
        ArrayList<ProductItem> items = new ArrayList<>();
        String date = MyDate.formatDate(new Date());
        try {
            String query = "select product.*, importer_id, supplier_id, quantity, import_price "
                    + "from product, import_item "
                    + "where product.id = import_item.product_id and product.expire_date <= ?";
            con = ConnectDatabase.createConnect();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, date);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                items.add(new ProductItem(
                        new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4),
                        MyDate.parseDateString(rs.getString(5)), MyDate.parseDateString(rs.getString(6)), rs.getInt(7)), 
                        rs.getInt(8), rs.getInt(9), rs.getInt(10), rs.getInt(11), rs.getInt(12)));
            }
            
            return items;
        } catch (IOException | ClassNotFoundException | SQLException | ParseException ex) {
            Logger.getLogger(ConnectProductItem.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ConnectProductItem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    
     private static ArrayList<ProductItem> get0Qunatity() {
        Connection con = null;
        ArrayList<ProductItem> items = new ArrayList<>();
        try {
            String query = "select product.*, importer_id, supplier_id, quantity, import_price "
                    + "from product, import_item "
                    + "where product.id = import_item.product_id and product.sold = import_item.quantity";
            con = ConnectDatabase.createConnect();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                items.add(new ProductItem(
                        new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4),
                        MyDate.parseDateString(rs.getString(5)), MyDate.parseDateString(rs.getString(6)), rs.getInt(7)), 
                        rs.getInt(8), rs.getInt(9), rs.getInt(10), rs.getInt(11), rs.getInt(12)));
            }
            
            return items;
        } catch (IOException | ClassNotFoundException | SQLException | ParseException ex) {
            Logger.getLogger(ConnectProductItem.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ConnectProductItem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
     
    private static ArrayList<ProductItem> getTopSale() {
        Connection con = null;
        PreparedStatement ps = null;
        ArrayList<ProductItem> items = new ArrayList<>();
        String date = MyDate.formatDate(new Date());
        try {
            String query = "select product.*, importer_id, supplier_id, quantity, import_price "
                    + "from product, import_item "
                    + "where product.id = import_item.product_id order by product.sold desc";
            con = ConnectDatabase.createConnect();
            ps = con.prepareStatement(query);
 
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                items.add(new ProductItem(
                        new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4),
                        MyDate.parseDateString(rs.getString(5)), MyDate.parseDateString(rs.getString(6)), rs.getInt(7)), 
                        rs.getInt(8), rs.getInt(9), rs.getInt(10), rs.getInt(11), rs.getInt(12)));
            }
            
            return items;
        } catch (IOException | ClassNotFoundException | SQLException | ParseException ex) {
            Logger.getLogger(ConnectProductItem.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ConnectProductItem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }


}
