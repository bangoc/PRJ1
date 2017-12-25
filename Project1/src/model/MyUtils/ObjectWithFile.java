/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.MyUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.employee.Account;
import model.employee.Employee;
import model.product.ExportReceipt;
import model.product.ImportReceipt;

/**
 *
 * @author leo
 */
public class ObjectWithFile {
    public static final String IMPORT_FOLDER_PATH = "importReceiptFolderPath.txt";
    public static final String EXPORT_FOLDER_PATH = "exportReceiptFolderPath.txt";
    public static final int IMPORT_OPTION = 1;
    public static final int EXPORT_OPTION = 2;
    
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
    
    
    public static void printImportReceipt(ImportReceipt receipt) {
        FileWriter writer = null;
        
        try {
            String fileName = "../import/ImportReceitp" + receipt.getId() + ".txt";
            writer = new FileWriter(fileName);
            writer.write(receipt.toString());
            System.out.println("Receipt printed");
        } catch (IOException ex) {
            Logger.getLogger(ObjectWithFile.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                writer.close();
            } catch (IOException ex) {
                Logger.getLogger(ObjectWithFile.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    public static void printExportReceipt(ExportReceipt receipt) {
        FileWriter writer = null;
        try {
            String fileName = "../export/ExportReceitp" + receipt.getCode() + ".txt";
            writer = new FileWriter(fileName);
            writer.write(receipt.toString());
            System.out.println("Receipt printed");
        } catch (IOException ex) {
            Logger.getLogger(ObjectWithFile.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                writer.close();
            } catch (IOException ex) {
                Logger.getLogger(ObjectWithFile.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static void saveDirectory(String folderPath, int option) {
        FileOutputStream out = null;
        ObjectOutputStream objectOut = null;
        
        try {
            if (option == IMPORT_OPTION) {
                out = new FileOutputStream(IMPORT_FOLDER_PATH);
            } else if (option == EXPORT_OPTION) {
                out = new FileOutputStream(EXPORT_FOLDER_PATH);
            } else {
                return;
            }
            objectOut = new ObjectOutputStream(out);
            objectOut.writeObject(folderPath);
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ObjectWithFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ObjectWithFile.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException ex) {
                    Logger.getLogger(ObjectWithFile.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (objectOut != null) {
                try {
                    objectOut.close();
                } catch (IOException ex) {
                    Logger.getLogger(ObjectWithFile.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public static String getSavedDirectory(int option) {
        FileInputStream in = null;
        ObjectInputStream objectIn = null;
        String folderPath = null;
        try {
            if (option == IMPORT_OPTION) {
                in = new FileInputStream(IMPORT_FOLDER_PATH);
            } else if (option == EXPORT_OPTION) {
                in = new FileInputStream(EXPORT_FOLDER_PATH);
            } else {
                return null;
            }
            objectIn = new ObjectInputStream(in);
            folderPath = (String) objectIn.readObject();
            
            return folderPath;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ObjectWithFile.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(ObjectWithFile.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException ex) {
                    Logger.getLogger(ObjectWithFile.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (objectIn != null) {
                try {
                    objectIn.close();
                } catch (IOException ex) {
                    Logger.getLogger(ObjectWithFile.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return folderPath;
    }
    
}
