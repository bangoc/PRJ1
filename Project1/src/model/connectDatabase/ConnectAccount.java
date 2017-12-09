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
import model.employee.Account;

/**
 *
 * @author leo
 */
public class ConnectAccount {
    public static void saveNewAccount(Account account, int id) throws IOException, ClassNotFoundException, SQLException {
        String query = "insert into account "
                + "(employee_id, user_name, password) "
                + "values (?, ?, ?)";
        Connection con = ConnectDatabase.createConnect();
        PreparedStatement ps = con.prepareStatement(query);
        
        ps.setInt(1, id);
        ps.setString(2, account.getUsername());
        ps.setString(3, account.getPassword());
        
        ps.executeUpdate();
    }
}
