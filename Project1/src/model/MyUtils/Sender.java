/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.MyUtils;

import model.employee.Employee;

/**
 *
 * @author leo
 */

public class Sender {
    
    // Phuong thuc gui mat khau dang nhap den email cua nhan vien   
    public static void sendPassword(Employee employee) {
        System.out.println("Ma nhan vien : " + employee.getEmployeeId());

        System.out.println("Ten : " + employee.getName());
     
        System.out.println("Tai khoan : " + employee.getAccount().getUsername());
        
        System.out.println("Mat khau : " + employee.getAccount().getPassword());
    }
}
