package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import model.QuanLy;
import view.MyModel;
import view.ThemNhaCungCapView;

public class CapNhatNhaCungCapController implements ActionListener {

  @Override
  public void actionPerformed(ActionEvent e) {
    ThemNhaCungCapView view = new ThemNhaCungCapView();
    String[] columnNames = {"Ma nha cung cap", "Ten nha cung cap",
        "Dia chi", "Email", "So dien thoai"};
    DefaultTableModel model = new MyModel(columnNames);
    Vector<String[]> vector = new QuanLy().getDanhSachNhaCungCap();
    for (String[] str : vector) {
      model.addRow(str);
    }
    
    view.getBangNhaCungCap().getTable().setModel(model);
    view.getBangNhaCungCap().setModel(model);
  }

}
