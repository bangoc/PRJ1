package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    String nameStr = view.getTxtName().getText();
    if (nameStr.equals("")) {
      JOptionPane.showMessageDialog(null, "Name required");
      return;
    }
    
    String sexStr = view.getTxtSex().getText();
    if (sexStr.equals("")) {
      JOptionPane.showMessageDialog(null, "Sex required");
      return;
    }
    
    String dateOfBirthStr = view.getTxtDateOfBirth().getText();
    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    Date dateOfBirth = new Date();
    try {
      dateOfBirth = df.parse(dateOfBirthStr);
    } catch (ParseException e) {
      JOptionPane.showMessageDialog(null, "Input data form dd/MM/yy");
    }
    
    String addressStr = view.getTxtAddress().getText();
    if (addressStr.equals("")) {
      JOptionPane.showMessageDialog(null, "Address required");
      return;
    }
    
    String phoneNoStr = view.getTxtPhoneNo().getText();
    if (phoneNoStr.equals("")) {
      JOptionPane.showMessageDialog(null, "Phone No. required");
      return;
    }
    
    String coefficientSalaryStr = view.getTxtCoefficientSalary().getText();
    if (coefficientSalaryStr.equals("")) {
      JOptionPane.showMessageDialog(null, "CoefficientSalary required");
      return;
    }
    int coefficientSalary = 0;
    try {
      coefficientSalary = Integer.parseInt(coefficientSalaryStr);
    } catch (NumberFormatException e) {
      JOptionPane.showMessageDialog(null, "Coefficient Salary must be number");
      return;
    }
    
    String linkImageFile = view.getTxtLink().getText();
    if (linkImageFile.equals("")) {
      JOptionPane.showMessageDialog(null, "Image required");
      return;
    }
    
    String inputStr = view.getTxtInput().getText();
    int input = 0;
    try {
      input = Integer.parseInt(inputStr);
    } catch (NumberFormatException e) {
      JOptionPane.showMessageDialog(null, "Number required");
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
        Saver.saveEmployee(employee);
      } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Fail to save new Employee");
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
        Saver.saveEmployee(salesman);
      } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Fail to save new Salesman");
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
        Saver.saveEmployee(manager);
      } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Fail to save new Manager");
        return;      
      }
      
    }
    JOptionPane.showMessageDialog(null, "Add successfull");
    view.getFrame().dispose();
  }
  
}
