package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.HangHoa;
import model.MyDate;
import model.NhaCungCap;
import model.QuanLy;
import view.ThemHangHoaView;

public class ThemHangHoaController implements ActionListener {
  private ThemHangHoaView themHangHoaView;
  
  public ThemHangHoaController(ThemHangHoaView themHangHoaView) {
    this.themHangHoaView = themHangHoaView;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    HangHoa hangHoa = new HangHoa();
    //xu li ten san pham
    String tenSanPham = themHangHoaView.getTxtName().getText();
    if (tenSanPham.isEmpty()) {
      JOptionPane.showMessageDialog(null, "Ban phai nhap vao ten san pham");
      return;
    } else {
      hangHoa.setTenSanPham(tenSanPham);
    }
    
    //xu li ma nha cung cap
    if (themHangHoaView.getTxtProviderId().getText().isEmpty()) {
      JOptionPane.showMessageDialog(null, "Ban phai nhap vao ma nha cung cap");
      return;
    }
    try {
      int maNhaCungCap = Integer.parseInt(themHangHoaView.getTxtProviderId().getText());
      NhaCungCap ncc = new NhaCungCap();
      ncc.setMaNhaCungCap(maNhaCungCap);
      ncc.loadNhaCungCap();
      if (ncc.isValid()) {
        hangHoa.setMaNhaCungCap(maNhaCungCap);
      }
    } catch (NumberFormatException ex) {
      JOptionPane.showMessageDialog(null, "Ban phai nhap ma nha cung cap dang so");
      return;
    } catch (NullPointerException ex) {
      JOptionPane.showMessageDialog(null, "Ma nha cung cap khong ton tai");
      return;
    }
    
    //xu li gia san pham
    try {
      String giaTien = themHangHoaView.getTxtPrice().getText();
      if (giaTien.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Ban phai nhap vao gia san pham");
        return;
      } else {
        hangHoa.setGiaSanPham(Integer.parseInt(giaTien));
      }
    } catch (NumberFormatException ex) {
      JOptionPane.showMessageDialog(null, "Ban phai nhap gia tien dang so");
      return;
    }
    
    //xu li nha san xuat
    String nhaSanXuat = themHangHoaView.getTxtProducer().getText();
    if (nhaSanXuat.isEmpty()) {
      JOptionPane.showMessageDialog(null, "Ban phai nhap vao ten nha san xuat");
      return;
    } else {
      hangHoa.setNhaSanXuat(nhaSanXuat);
    }
    //xu li ngay san xuat va ngay het han
    try {
      hangHoa.setNgaySanXuat(new MyDate(themHangHoaView.getTxtProduceDate().getText()));
      hangHoa.setNgayHetHan(new MyDate(themHangHoaView.getTxtExpireDate().getText()));
    } catch (NumberFormatException ex) {
      JOptionPane.showMessageDialog(null, "Ban phai nhap time dang dd/mm/yyyy");
      return;
    } catch (ArrayIndexOutOfBoundsException ex) {
      JOptionPane.showMessageDialog(null, "Ban phai nhap time dang dd/mm/yyyy");
      return;
    }
    
    //xy ly so luong san pham
    
    try {
      String soLuong = themHangHoaView.getTxtAmount().getText();
      if (soLuong.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Ban phai nhap vao so luong hang hoa");
        return;
      } 
      int soLuongInt = Integer.parseInt(soLuong);
      if (soLuongInt == 0) {
        JOptionPane.showMessageDialog(null, "So luong phai khac 0");
        return;
      } else {
        hangHoa.setSoLuongHienCo(soLuongInt);
        hangHoa.setSoLuongDaBan(0);
      }
    } catch (NumberFormatException ex) {
      JOptionPane.showMessageDialog(null, "Ban phai nhap so luong dang so");
      return;
    }
    
    new QuanLy().themHangHoa(hangHoa);
  }

}
