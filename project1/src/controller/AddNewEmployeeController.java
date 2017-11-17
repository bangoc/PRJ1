package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import mdl.Employee;
import mdl.Manager;
import mdl.SalesPerson;
import model.Saver;
import view.AddNewEmpployeeView;

public class AddNewEmployeeController implements ActionListener {
  private AddNewEmpployeeView view;
  
  public AddNewEmployeeController(AddNewEmpployeeView view) {
    this.view = view;
  }
  
  @Override
  public void actionPerformed(ActionEvent arg0) {
    ResourceBundle b = ResourceBundle.getBundle("view.Label");
    String nameStr = view.getTxtName().getText();
    if (nameStr.equals("")) {
      JOptionPane.showMessageDialog(null, b.getString("nameRequired"));
      return;
    }
    
    String sexStr = view.getTxtSex().getText();
    if (sexStr.equals("")) {
      JOptionPane.showMessageDialog(null, b.getString("sexRequired"));
      return;
    }
    
    String dateOfBirthStr = view.getTxtDateOfBirth().getText();
    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    Date dateOfBirth = new Date();
    try {
      dateOfBirth = df.parse(dateOfBirthStr);
    } catch (ParseException e) {
      JOptionPane.showMessageDialog(null, b.getString("inputDateForm"));
      return;
    }
    
    String addressStr = view.getTxtAddress().getText();
    if (addressStr.equals("")) {
      JOptionPane.showMessageDialog(null, b.getString("addressRequired"));
      return;
    }
    
    String phoneNoStr = view.getTxtPhoneNo().getText();
    if (phoneNoStr.equals("")) {
      JOptionPane.showMessageDialog(null, b.getString("phoneRequired"));
      return;
    }
    
    String coefficientSalaryStr = view.getTxtCoefficientSalary().getText();
    if (coefficientSalaryStr.equals("")) {
      JOptionPane.showMessageDialog(null, b.getString("coRequired"));
      return;
    }
    int coefficientSalary = 0;
    try {
      coefficientSalary = Integer.parseInt(coefficientSalaryStr);
    } catch (NumberFormatException e) {
      JOptionPane.showMessageDialog(null, b.getString("numberRequired"));
      return;
    }
    
    String linkImageFile = view.getTxtLink().getText();
    if (linkImageFile.equals("")) {
      JOptionPane.showMessageDialog(null, b.getString("imageRequired"));
      return;
    }
    
    String inputStr = view.getTxtInput().getText();
    int input = 0;
    try {
      input = Integer.parseInt(inputStr);
    } catch (NumberFormatException e) {
      JOptionPane.showMessageDialog(null, b.getString("numberRequired"));
      return;
    }
    
    int index = view.getComboBox().getSelectedIndex();
    
    if (index == 0) {
      Employee employee = new Employee();
      employee.setName(nameStr);
      employee.setSex(sexStr);
      employee.setDateOfBirth(dateOfBirth);
      employee.setAddress(addressStr);
      employee.setCoefficientsSalary(coefficientSalary);
      employee.setPhoneNumber(phoneNoStr);
      try {
        Saver.saveEmployee(employee, linkImageFile);
      } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, b.getString("sqlError"));
        return;
      } catch (ClassNotFoundException e) {
        JOptionPane.showMessageDialog(null, b.getString("Error"));
        return;
      } catch (IOException e) {
        JOptionPane.showMessageDialog(null, b.getString("Error"));
        return;
      }
    } else if (index == 1) {
      SalesPerson salesman = new SalesPerson();
      salesman.setName(nameStr);
      salesman.setSex(sexStr);
      salesman.setDateOfBirth(dateOfBirth);
      salesman.setAddress(addressStr);
      salesman.setCoefficientsSalary(coefficientSalary);
      salesman.setPhoneNumber(phoneNoStr);
      salesman.setSubsidy(input);
     
      try {
        Saver.saveEmployee(salesman, linkImageFile);
        JOptionPane.showMessageDialog(null, b.getString("successfull"));
      } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, b.getString("sqlError") 
            + ". " + b.getString("fail"));
        return;
      }catch (ClassNotFoundException e) {
        JOptionPane.showMessageDialog(null, b.getString("Error"));
        return;
      } catch (IOException e) {
        JOptionPane.showMessageDialog(null, b.getString("Error"));
        return;
      }
    } else {
      Manager manager = new Manager();
      manager.setName(nameStr);
      manager.setSex(sexStr);
      manager.setDateOfBirth(dateOfBirth);
      manager.setAddress(addressStr);
      manager.setCoefficientsSalary(coefficientSalary);
      manager.setPhoneNumber(phoneNoStr);
      manager.setCommission(input);
      try {
        Saver.saveEmployee(manager, linkImageFile);
        JOptionPane.showMessageDialog(null, b.getString("successfull"));
      } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, b.getString("sqlError") 
            + ". " + b.getString("fail"));
        return;      
      } catch (ClassNotFoundException e) {
        JOptionPane.showMessageDialog(null, b.getString("Error"));
        return;
      } catch (IOException e) {
        JOptionPane.showMessageDialog(null, b.getString("Error"));
        return;
      }
      
    }
    view.getFrame().dispose();
  }
  
}
