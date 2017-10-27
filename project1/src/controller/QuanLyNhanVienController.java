package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

import model.QuanLy;
import view.MyModel;
import view.QuanLyNhanVienView;

public class QuanLyNhanVienController implements ActionListener {
  private JFrame frame;
  
  public QuanLyNhanVienController(JFrame frame) {
    this.frame = frame;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    QuanLyNhanVienView view = new QuanLyNhanVienView();
    frame.dispose();
    String [] columnNames = {"MSNV", "Ho va Ten", "Luong / ca", "So ca lam viec"};
    DefaultTableModel model = new MyModel(columnNames);
    Vector<String[]> vector = new QuanLy().getDanhSachNhanVien();
    for (String[] str : vector) {
      model.addRow(str);
    }
    view.getBangNhanVienView().getTable().setModel(model);
    view.getBangNhanVienView().setModel(model);
  }

}
