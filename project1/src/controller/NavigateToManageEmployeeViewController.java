package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
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
    ManageEmployeeView view = new ManageEmployeeView();
    frame.dispose();
    String [] columnNames = {"ID", "Name", "Sex", "Birth Of Date", "Address", 
        "Phone No.", "Co. Salary", "Situation"};
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
    } catch (SQLException | ParseException e1) {
      JOptionPane.showMessageDialog(null, "Something wrong!" + e1);
    }
  
  }

}
