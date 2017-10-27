package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.MyDate;
import model.NhanVien;
import model.QuanLy;
import view.ThemNhanVienView;

public class ThemNhanVienController implements ActionListener {
  private ThemNhanVienView view;
  
  public ThemNhanVienController(ThemNhanVienView view) {
    this.view = view;
  }
  
  @Override
  public void actionPerformed(ActionEvent arg0) {
    if (view.getTxtTenNhanVien().getText().equals("")) {
      JOptionPane.showMessageDialog(null, "Ban phai nhap vao ten nhan vien");
      return;
    } else if (view.getTxtTuoi().getText().equals("")) {
      JOptionPane.showMessageDialog(null, "Ban phai nhap vao tuoi");
      return;
    } else if (view.getTxtGioiTinh().getText().equals("")) {
      JOptionPane.showMessageDialog(null, "Ban phai nhap vao gioi tinh");
      return;
    } else if (view.getTxtNgaySinh().getText().equals("")) {
      JOptionPane.showMessageDialog(null, "Ban phai nhap vao ngay sinh");
      return;
    } else if (view.getTxtNgayVaoLam().getText().equals("")) {
      JOptionPane.showMessageDialog(null, "Ban phai nhap vao ngay vao lam");
      return;
    } else if (view.getTxtLuongCoBan().getText().equals("")) {
      JOptionPane.showMessageDialog(null, "Ban phai nhap vao luong theo ca");
      return;
    }
    
    NhanVien nhanVien = new NhanVien();
    nhanVien.setTenNhanVien(view.getTxtTenNhanVien().getText());
    nhanVien.setGioiTinh(view.getTxtGioiTinh().getText());
    nhanVien.setTuoiNhanVien(Integer.parseInt(view.getTxtTuoi().getText()));
    nhanVien.setNgaySinh(new MyDate(view.getTxtNgaySinh().getText()));
    nhanVien.setNgayVaoLam(new MyDate(view.getTxtNgayVaoLam().getText()));
    nhanVien.setLuongCoBan(Integer.parseInt(view.getTxtLuongCoBan().getText()));    
    new QuanLy().themNhanVien(nhanVien);
    new QuanLy().taoTaiKhoanDangNhapChoNhanVien(nhanVien);
    view.getFrame().setVisible(false);
  }
  
}
