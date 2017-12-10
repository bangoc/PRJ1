/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.connectDatabase;

import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import javax.swing.ImageIcon;
import model.MyUtils.MyDate;
import model.employee.Account;
import model.employee.Division;
import model.employee.Employee;
import model.employee.Gender;
import model.employee.Importer;
import model.employee.Manager;
import model.employee.Salesman;

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
        
        con.close();
    }
    
    public static void saveChangedAccount(Account account, int id) throws IOException, ClassNotFoundException, SQLException {
        String query = "update account set user_name = ?, password = ? where employee_id = ?";
        Connection con = ConnectDatabase.createConnect();
        
        PreparedStatement ps = con.prepareStatement(query);
        
        ps.setInt(3, id);
        ps.setString(1, account.getUsername());
        ps.setString(2, account.getPassword());
        
        ps.executeUpdate();
        con.close();
    }
    
    public static Object createLogin(Account account) throws IOException, ClassNotFoundException, SQLException, ParseException {
        String query = "select employee.* "
                + "from employee, account "
                + "where user_name = ? and password = ? and employee_id = id";
        
        Connection con = ConnectDatabase.createConnect();
        
        PreparedStatement ps = con.prepareStatement(query);
        
        ps.setString(1, account.getUsername());
        ps.setString(2, account.getPassword());
        
        ResultSet rs = ps.executeQuery();
 
        while (rs.next()) {
            int id = rs.getInt(1);
            
            String name = rs.getString(2);
            
            Gender gender;
            if (rs.getString(3).equals(Gender.FEMALE.toString())) {
                gender = Gender.FEMALE;
            } else {
                gender = Gender.MALE;
            }
            
            Date date = MyDate.parseDateString(rs.getString(4));
            
            String address = rs.getString(5);
            
            String phone = rs.getString(6);
            
            int coefficientSalary = rs.getInt(7);
            
            Blob b=rs.getBlob(8);
            byte barr[]=b.getBytes(1,(int)b.length());
            ImageIcon img = new ImageIcon(barr);
            
            String division = rs.getString(9);
            con.close();
            if (division.equals(Division.EMPLOYEE.toString())) {
                return new Employee(id, name, gender, date, address, phone, coefficientSalary, img, account);
            } else if (division.equals(Division.IMPORTER.toString())) {
                return new Importer(id, name, gender, date, address, phone, coefficientSalary, img, account);
            } else if (division.equals(Division.MANAGER.toString())) {
                return new Manager(id, name, gender, date, address, phone, coefficientSalary, img, account);
            } else if (division.equals(Division.SALESMAN.toString())) {
                return new Salesman(id, name, gender, date, address, phone, coefficientSalary, img, account);
            }
           
        }
        con.close();
        return null;
    }
}
