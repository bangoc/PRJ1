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
import model.MyUtils.MyDate;
import model.employee.Salesman;
import model.product.ExportItem;
import model.product.Product;

/**
 *
 * @author leo
 */
public class ConnectExportItem {
    public static ExportItem createExportItem(Salesman salesman, int id, int quantity
           ) throws IOException, ClassNotFoundException, SQLException, ParseException {
        
        String query = "select product.* from product, import_item "
                + "where product.id = ? and product.id = import_item.product_id and (product.sold + ?) <= import_item.quantity";
        Connection con = ConnectDatabase.createConnect();
        PreparedStatement ps = con.prepareStatement(query);
        
        ps.setInt(1, id);
        ps.setInt(2, quantity);
        
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            ExportItem it = new ExportItem(new Product(rs.getInt(1), rs.getString(2),
                    rs.getInt(3), rs.getString(4), MyDate.parseDateString(rs.getString(5)),
                    MyDate.parseDateString(rs.getString(6)), rs.getInt(7)), quantity, salesman);
            con.close();
            return it;
        }
        con.close();
        return null;
    }
    
}
