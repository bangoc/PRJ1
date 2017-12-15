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
import model.product.Product;

/**
 *
 * @author leo
 */
public class ConnectProduct {
    public void saveChangedProduct(Product product) {
        
    }
    
    public static void saveChangedSold(Connection con, int product_id, int amount) throws IOException, ClassNotFoundException, SQLException {
        String query = "update product set sold = (sold + ?) where id = ?";
 
        PreparedStatement ps = con.prepareStatement(query);
        
        ps.setInt(1, amount);
        ps.setInt(2, product_id);
        
        ps.executeUpdate();
        
    }
    
}
