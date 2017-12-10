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
import javax.swing.ImageIcon;
import model.MyUtils.MyDate;
import model.employee.Division;
import model.employee.Employee;
import model.employee.Gender;

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

        // get image as stream to save to database
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
        
        // save account
        ConnectAccount.saveNewAccount(employee.getAccount(), key);
        con.close();
    }
    
    public void saveChangedEmployee(Employee employee, String linkImage, Division division) throws IOException, ClassNotFoundException, SQLException {
        String query = "update employee "
                + "set name = ?, sex = ?, birth_date = ?, address = ?, phone_no = ?, "
                + "coefficient_salary = ?, image = ?, division = ? where id = ?";
        Connection con = ConnectDatabase.createConnect();
        PreparedStatement ps = con.prepareStatement(query);

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
        ps.setInt(9, employee.getEmployeeId());
        // execute query
        ps.executeUpdate();
        
        con.close();
    }
    
    public static ArrayList<Employee> getEmployees() throws IOException, ClassNotFoundException, SQLException, ParseException {
        String query = "select * from employee";
        Connection con = ConnectDatabase.createConnect();
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        
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
        con.close();
        return employees;
    }
}
