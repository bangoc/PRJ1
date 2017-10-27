package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import model.QuanLy;
import view.MyModel;
import view.MyPanel;

public class CapNhapDsNhanVienController implements ActionListener {
  private MyPanel view;
  
  public CapNhapDsNhanVienController(MyPanel view) {
    this.view = view;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    String [] columnNames = {"MSNV", "Ho va Ten", "Luong / ca", "So ca lam viec"};
    DefaultTableModel  model = new MyModel(columnNames);
    Vector<String[]> vector = new QuanLy().getDanhSachNhanVien();
    for (String[] str : vector) {
      model.addRow(str);
    }
    view.getTable().setModel(model);
    view.setModel(model);
  }

}
