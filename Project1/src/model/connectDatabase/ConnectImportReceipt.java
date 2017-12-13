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
import model.MyUtils.MyDate;
import model.product.ImportItem;
import model.product.ImportReceipt;
import model.product.Product;

/**
 *
 * @author leo
 */
public class ConnectImportReceipt {
    public static void saveNewImportReceipt(ImportReceipt receipt) throws IOException, ClassNotFoundException, SQLException {
        String query = "insert into import_receipt (id, date, total)"
                + " values (null, ?, ?)";
        
        Connection con = ConnectDatabase.createConnect();
        PreparedStatement ps = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
        
        ps.setString(1, MyDate.formatDate(receipt.getDate()));
        ps.setLong(2, receipt.getTotal());
        
        ps.executeUpdate();

        ResultSet rs = ps.getGeneratedKeys();
        int receiptId = 0;
        while (rs.next()) {
            receiptId = rs.getInt(1);
        }
        
        receipt.setId(receiptId);
        
        for (ImportItem it : receipt.getItems()) {
            saveNewProduct(con, it.getProduct());
            saveImportItem(con, receiptId, it);
        }
        
        con.close();
    }
    
    static void saveNewProduct(Connection con, Product product) throws SQLException {
        String query = "insert into product (id, name, price, producer, produce_date, expire_date)"
                + " values (null, ?, ?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
        
        ps.setString(1, product.getName());
        ps.setInt(2, product.getPrice());
        ps.setString(3, product.getProducer());
        ps.setString(4, MyDate.formatDate(product.getProduceTime()));
        ps.setString(5, MyDate.formatDate(product.getExpireTime()));
        
        ps.executeUpdate();

        ResultSet rs = ps.getGeneratedKeys();
        int key = 0;
        while (rs.next()) {
            key = rs.getInt(1);
        }
        
        product.setProductId(key);
    }
    
    static void saveImportItem(Connection con, int receiptId, ImportItem item) throws SQLException {
        String query = "insert into import_item "
                + "(receipt_id, product_id, importer_id, supplier_id, quantity, import_price) "
                + "values (?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(query);
        
        ps.setInt(1, receiptId);
        ps.setInt(2, item.getProduct().getProductId());
        ps.setInt(3, item.getImporter().getEmployeeId());
        ps.setInt(4, item.getSupplier().getSupplierId());
        ps.setInt(5, item.getQuantity());
        ps.setInt(6, item.getImportPrice());
        
        ps.executeUpdate();
    }
}
