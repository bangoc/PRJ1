/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.connectDatabase;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.employee.Employee;

/**
 *
 * @author leo
 */
public class ConnectEmployee {
    public void saveNewEmployee(Employee employee, String linkImage) {
        String query = "insert into employee "
                + "(id, name, sex, birth_date, address, phone_no, coefficient_salary, image) "
                + "values (null, ?, ?, ?, ?, ?, ?, ?)";
        
        try {
            Connection con = ConnectDatabase.createConnect();
            PreparedStatement ps = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            
            // set values
            ps.setString(1, employee.getName());
            ps.setString(2, employee.getGender().toString());
            ps.setString(3, employee.getDateOfBirth().toString());
            ps.setString(4, employee.getAddress());
            ps.setString(5, employee.getPhoneNumber());
            ps.setInt(6, employee.getCoefficientsSalary());
            
            FileInputStream in = new FileInputStream(linkImage);
            ps.setBinaryStream(7, in);
            
            // execute query
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            int key = 0;
            while (rs.next()) {
                key = rs.getInt(1);
            }
            
            employee.setEmployeeId(key);
            
        } catch (IOException | ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ConnectEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void saveChangedEmployee(Employee employee) {
        
    }
}
