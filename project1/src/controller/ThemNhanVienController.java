package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

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
    try {
      nhanVien.setTuoiNhanVien(Integer.parseInt(view.getTxtTuoi().getText()));
    } catch (NumberFormatException e) {
      JOptionPane.showMessageDialog(null, "Ban phai nhap vao so" + e);
      return;
    }
    try {
      DateFormat df = new SimpleDateFormat("dd/mm/yyyy");

      nhanVien.setNgaySinh(df.parse(view.getTxtNgaySinh().getText()));
      nhanVien.setNgayVaoLam(df.parse(view.getTxtNgayVaoLam().getText()));
    } catch (ParseException e) {
      JOptionPane.showMessageDialog(null, "Ban phai nhap ngay dinh dang dd/mm/yyyy" + e);
      return;
    } catch (ArrayIndexOutOfBoundsException e) {
      JOptionPane.showMessageDialog(null, "Ban phai nhap ngay dinh dang dd/mm/yyyy" + e);
      return;
    }
    try {
      nhanVien.setLuongCoBan(Integer.parseInt(view.getTxtLuongCoBan().getText()));  
    } catch (NumberFormatException e) {
      JOptionPane.showMessageDialog(null, "Ban phai nhap vao so" + e);
      return;
    }
    try {
      new QuanLy().themNhanVien(nhanVien);
    } catch (ParseException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    new QuanLy().taoTaiKhoanDangNhapChoNhanVien(nhanVien);
    view.getFrame().setVisible(false);
  }
  
}
