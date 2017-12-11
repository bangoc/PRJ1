/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.MyUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import model.employee.Account;
import model.employee.Employee;

/**
 *
 * @author leo
 */
public class ObjectWithFile {
    public static void saveAccountToFile(Account account) throws FileNotFoundException, IOException {
        FileOutputStream out = new FileOutputStream("account.txt");
        ObjectOutputStream objectOut = new ObjectOutputStream(out);
        objectOut.writeObject(account);
        objectOut.close();
    }
    
    public static Account getAccountFromFile() throws IOException, ClassNotFoundException {
        FileInputStream in = new FileInputStream("account.txt");
        ObjectInputStream objectIn = new ObjectInputStream(in);
        Account account = (Account) objectIn.readObject();
        objectIn.close();
        return account;
    }
    
    public static void printSalaryTable(ArrayList<Employee> employees) {
        System.out.println("salary table printed");
    }
    
    
}
