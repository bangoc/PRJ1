package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

import view.MyModel;
import view.QuanLyHangHoaView;

public class QuanLyHangHoaCotroller implements ActionListener {
  private JFrame frame;
  
  public QuanLyHangHoaCotroller(JFrame frame) {
    this.frame = frame;
  }
  
  @Override
  public void actionPerformed(ActionEvent e) {
    String [] columnNames = {"Ma san pham", "Ten san pham", "Nha san xuat",
        "So luong hien co", "So luong da ban"};
    DefaultTableModel  model = new MyModel(columnNames);
    QuanLyHangHoaView view = new QuanLyHangHoaView();
    view.getPanel().getTable().setModel(model);
    view.getPanel().setModel(model);
    frame.dispose();
    
  }

}
