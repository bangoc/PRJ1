package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.DangNhapModel;
import view.DangNhapView;
import view.View;

public class DangNhapController implements ActionListener {
  private DangNhapView dangNhapView;
  
  public DangNhapController(DangNhapView dangNhapView) {
    this.dangNhapView = dangNhapView;
  }
  
  @Override
  
  public void actionPerformed(ActionEvent arg0) {
    String taiKhoan = dangNhapView.getTxtTaiKhoan().getText();
    @SuppressWarnings("deprecation")
    String matKhau = dangNhapView.getTxtMatKhau().getText();
    
    DangNhapModel dangNhap = new DangNhapModel(taiKhoan, matKhau);
    try {
      if (dangNhap.kiemTraDangNhap()) {
        new View();
      } else {
        JOptionPane.showMessageDialog(null, "Dang nhap khong thanh cong");
      }
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
  }

}
