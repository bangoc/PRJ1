package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.NhaCungCap;
import model.QuanLy;
import view.ThemNhaCungCapView;

public class ThemNhaCungCapController implements ActionListener {
  private ThemNhaCungCapView view;
  
  public ThemNhaCungCapController(ThemNhaCungCapView themNhaCungCapView) {
    this.view = themNhaCungCapView;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    NhaCungCap ncc = new NhaCungCap();
    ncc.setTenNhaCungCap(view.getTxtName().getText());
    ncc.setDiaChia(view.getTxtAddress().getText());
    ncc.setEmail(view.getTxtEmail().getText());
    ncc.setSoDienThoai(view.getTxtPhoneNo().getText());
    new QuanLy().addNhaCungCap(ncc);
    JOptionPane.showMessageDialog(null, "Them thanh cong");
    view.getFrame().dispose();
  }

}
