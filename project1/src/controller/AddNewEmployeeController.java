package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import view.AddNewEmployee;

public class AddNewEmployeeController implements ActionListener {
  private AddNewEmployee view;
  
  public AddNewEmployeeController(AddNewEmployee view) {
    this.view = view;
  }
  
  @Override
  public void actionPerformed(ActionEvent arg0) {
    if (view.getTxtName().getText().equals("")) {
      JOptionPane.showMessageDialog(null, "Ban phai nhap vao ten nhan vien");
      return;
    } else if (view.getTxtSex().getText().equals("")) {
      JOptionPane.showMessageDialog(null, "Ban phai nhap vao tuoi");
      return;
    } else if (view.getTxtDateOfBirth().getText().equals("")) {
      JOptionPane.showMessageDialog(null, "Ban phai nhap vao gioi tinh");
      return;
    } else if (view.getTxtAddress().getText().equals("")) {
      JOptionPane.showMessageDialog(null, "Ban phai nhap vao ngay sinh");
      return;
    } else if (view.getTxtPhoneNo().getText().equals("")) {
      JOptionPane.showMessageDialog(null, "Ban phai nhap vao ngay vao lam");
      return;
    } else if (view.getTxtCoefficientSalary().getText().equals("")) {
      JOptionPane.showMessageDialog(null, "Ban phai nhap vao luong theo ca");
      return;
    }
     
    view.getFrame().dispose();
  }
  
}
