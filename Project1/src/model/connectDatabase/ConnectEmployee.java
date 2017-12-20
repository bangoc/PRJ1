/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.connectDatabase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import model.MyUtils.MyDate;
import model.employee.Division;
import model.employee.Employee;
import model.employee.Gender;

/**
 *
 * @author leo
 */
public class ConnectEmployee {
    public static void saveNewEmployee(Employee employee, String linkImage, Division division) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String query = "insert into employee "
                    + "(id, name, sex, birth_date, address, phone_no, coefficient_salary, image, division) "
                    + "values (null, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            
            con = ConnectDatabase.createConnect();
            ps = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            
            // set values
            ps.setString(1, employee.getName());
            ps.setString(2, employee.getGender().toString());
            ps.setString(3, MyDate.formatDate(employee.getDateOfBirth()));
            ps.setString(4, employee.getAddress());
            ps.setString(5, employee.getPhoneNumber());
            ps.setInt(6, employee.getCoefficientsSalary());
            
            // get image as stream to save to database
            FileInputStream fin=new FileInputStream(linkImage);
            ps.setBinaryStream(7,fin,fin.available());
            ps.setString(8, division.toString());
            // execute query
            ps.executeUpdate();
            
            rs = ps.getGeneratedKeys();
            int key = 0;
            while (rs.next()) {
                key = rs.getInt(1);
            }
            
            employee.setEmployeeId(key);
            
            // save account
            ConnectAccount.saveNewAccount(employee.getAccount(), key);
        
        } catch (IOException | ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ConnectEmployee.class.getName()).log(Level.SEVERE, null, ex);
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
    
    public static void saveChangedEmployee(Employee employee, String linkImage) {
        String query1 = "update employee "
                + "set name = ?, sex = ?, birth_date = ?, address = ?, phone_no = ?, "
                + "coefficient_salary = ?, division = ?, image = ? where id = ?";
        String query2 = "update employee "
                + "set name = ?, sex = ?, birth_date = ?, address = ?, phone_no = ?, "
                + "coefficient_salary = ?, division = ? where id = ?";
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = ConnectDatabase.createConnect();
        
            
            if (linkImage == null) {

            
                ps = con.prepareStatement(query2);
                ps.setString(1, employee.getName());
                ps.setString(2, employee.getGender().toString());
                ps.setString(3, MyDate.formatDate(employee.getDateOfBirth()));
                ps.setString(4, employee.getAddress());
                ps.setString(5, employee.getPhoneNumber());
                ps.setInt(6, employee.getCoefficientsSalary());
                
                ps.setString(7, employee.getDivision().toString());
                ps.setInt(8, employee.getEmployeeId());
                // execute query
                ps.executeUpdate();
           
             } else {

           
                ps = con.prepareStatement(query1);
                ps.setString(1, employee.getName());
                ps.setString(2, employee.getGender().toString());
                ps.setString(3, MyDate.formatDate(employee.getDateOfBirth()));
                ps.setString(4, employee.getAddress());
                ps.setString(5, employee.getPhoneNumber());
                ps.setInt(6, employee.getCoefficientsSalary());
                
                ps.setString(7, employee.getDivision().toString());
                // get image as stream to save to database
                FileInputStream fin=new FileInputStream(linkImage);
                ps.setBinaryStream(8,fin,fin.available());
                
                ps.setInt(9, employee.getEmployeeId());
                // execute query
                ps.executeUpdate();
            } 
               
        } catch (IOException | ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ConnectEmployee.class.getName()).log(Level.SEVERE, null, ex);
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
        }
        
    }

        

        // set values

     
    
    
    public static ArrayList<Employee> getEmployees() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String query = "select * from employee";
            con = ConnectDatabase.createConnect();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            
            ArrayList<Employee> employees = new ArrayList<>();
            Employee employee;
            while (rs.next()) {
                employee = new Employee();
                
                employee.setEmployeeId(rs.getInt(1));
                
                employee.setName(rs.getString(2));
                
                Gender gender;
                if (rs.getString(3).equals(Gender.FEMALE.toString())) {
                    gender = Gender.FEMALE;
                } else {
                    gender = Gender.MALE;
                }
                employee.setGender(gender);
                
                employee.setDateOfBirth(MyDate.parseDateString(rs.getString(4)));
                
                employee.setAddress(rs.getString(5));
                
                employee.setPhoneNumber(rs.getString(6));
                
                employee.setCoefficientsSalary(rs.getInt(7));
                
                Blob b=rs.getBlob(8);
                byte barr[]=b.getBytes(1,(int)b.length());
                ImageIcon img = new ImageIcon(barr);
                employee.setImage(img);
                
                String div = rs.getString(9);
                Division division;
                if (div.equals(Division.EMPLOYEE.toString())) {
                    division = Division.EMPLOYEE;
                } else if (div.equals(Division.IMPORTER.toString())) {
                    division = Division.IMPORTER;
                } else if (div.equals(Division.MANAGER.toString())) {
                    division = Division.MANAGER;
                } else {
                    division = Division.SALESMAN;
                }
                employee.setDivision(division);
                
                employees.add(employee);
            }
            return employees;
        } catch (IOException | ClassNotFoundException | SQLException | ParseException ex) {
            Logger.getLogger(ConnectEmployee.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "System error!");
            return null;
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
}
