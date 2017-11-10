package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import mdl.Employee;
import mdl.WorkHistory;
import model.Loader;
import view.EmployeeInfomationView;
import view.MyTable;

public class DoubleClickEmployee implements MouseListener {
  private MyTable bangNhanVienView;
  
  public DoubleClickEmployee(MyTable bangNhanVienView) {
    this.bangNhanVienView = bangNhanVienView;
  }
  
  @Override
  public void mouseClicked(MouseEvent arg0) {
    if (arg0.getClickCount() != 2) {
      return;
    } else {
      DefaultTableModel model = bangNhanVienView.getModel();
      JTable table = bangNhanVienView.getTable();
      int row = table.getSelectedRow();
      String s = (String) model.getValueAt(row, 0);
      int id = Integer.parseInt(s);
      try {
  
        EmployeeInfomationView thongTinView = new EmployeeInfomationView();
        ArrayList<JLabel> listLabel = thongTinView.getListLabel();
        listLabel.get(0).setText("ID");
        listLabel.get(1).setText("Name");
        listLabel.get(2).setText("Sex");

        listLabel.get(3).setText("Date Of Birth");
        listLabel.get(4).setText("Address");
        listLabel.get(5).setText("Phone No.");
        listLabel.get(6).setText("Coefficient Salary");
        ArrayList<JLabel> listData = thongTinView.getListText();
        Employee employee = Loader.loadEmployeeById(id);
        listData.get(0).setText("" + employee.getIdNumber());
        listData.get(1).setText(employee.getName());
        listData.get(2).setText(employee.getSex());
        DateFormat df = new SimpleDateFormat("dd/mm/yyyy");
        listData.get(3).setText(df.format(employee.getDateOfBirth()));
        listData.get(4).setText(employee.getAddress());
        listData.get(5).setText(employee.getPhoneNumber());
        listData.get(6).setText("" + employee.getCoefficientsSalary());
        
        thongTinView.getLblImage().setIcon(employee.getImage());
        
        DefaultTableModel newModel = thongTinView.getMyTable().getModel();
        for (WorkHistory history : employee.getWorkHistory()) {
          newModel.addRow(history.toArrayString());
        }
        


      } catch (SQLException | ParseException e) {
        e.printStackTrace();
      }

    }
  }

  @Override
  public void mouseEntered(MouseEvent arg0) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void mouseExited(MouseEvent arg0) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void mousePressed(MouseEvent arg0) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void mouseReleased(MouseEvent arg0) {
    // TODO Auto-generated method stub
    
  }

}
