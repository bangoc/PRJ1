package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import mdl.Employee;
import model.Loader;
import view.ManageEmployeeView;
import view.MyModel;

public class NavigateToManageEmployeeViewController implements ActionListener {
  private JFrame frame;
  
  public NavigateToManageEmployeeViewController(JFrame frame) {
    this.frame = frame;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    ResourceBundle b = ResourceBundle.getBundle("view.Label");

    ManageEmployeeView view = new ManageEmployeeView();
    frame.dispose();
    String [] columnNames = {b.getString("ID"), b.getString("Name"), b.getString("Sex"), b.getString("BirthDate"), b.getString("Address"), 
        b.getString("PhoneNo"), b.getString("Coefficient"), b.getString("Situation")};
    DefaultTableModel model = new MyModel(columnNames);
    
    ArrayList<Employee> employeeList;
    try {
      employeeList = Loader.loadEmployee();
      employeeList.addAll(Loader.loadManager());
      employeeList.addAll(Loader.loadSalesPerson());
      for (Employee employee : employeeList) {
        model.addRow(employee.toArrayString());
      }
      view.getBangNhanVienView().getTable().setModel(model);
      view.getBangNhanVienView().setModel(model);
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null, b.getString("sqlError"));
      return;
    } catch (ParseException ex) {
      JOptionPane.showMessageDialog(null, b.getString("parseError"));
      return;
    }
  
  }

}
