/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.connectDatabase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.MyUtils.MyDate;
import model.employee.Division;
import model.employee.Employee;

/**
 *
 * @author leo
 */
public class ConnectEmployee {
    public static void saveNewEmployee(Employee employee, String linkImage, Division division) throws SQLException, FileNotFoundException, IOException, ClassNotFoundException {
        String query = "insert into employee "
                + "(id, name, sex, birth_date, address, phone_no, coefficient_salary, image, division) "
                + "values (null, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        
        Connection con = ConnectDatabase.createConnect();
        PreparedStatement ps = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);

        // set values
        ps.setString(1, employee.getName());
        ps.setString(2, employee.getGender().toString());
        ps.setString(3, MyDate.formatDate(employee.getDateOfBirth()));
        ps.setString(4, employee.getAddress());
        ps.setString(5, employee.getPhoneNumber());
        ps.setInt(6, employee.getCoefficientsSalary());

  
        FileInputStream fin=new FileInputStream(linkImage);  
        ps.setBinaryStream(7,fin,fin.available());  
        ps.setString(8, division.toString());
        // execute query
        ps.executeUpdate();

        ResultSet rs = ps.getGeneratedKeys();
        int key = 0;
        while (rs.next()) {
            key = rs.getInt(1);
        }

        employee.setEmployeeId(key);

        
    }
    
    public void saveChangedEmployee(Employee employee) {
        
    }
}
