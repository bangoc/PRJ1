package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.NhanVien;
import model.QuanLy;

public class TraLuongNhanVienController implements ActionListener {

  @Override
  public void actionPerformed(ActionEvent e) {
    int option = JOptionPane.showConfirmDialog(null,
        "Ban muon thuc hien thanh toan luong cho nhan vien");
    System.out.println(option);
    if (option == 0) {
      ArrayList<NhanVien> listNhanVien = new QuanLy().loadDanhSachNhanVien();
      new QuanLy().traLuongNhanVien(listNhanVien);
    } else {
      return;
    }
  }

}
