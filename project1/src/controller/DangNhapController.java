package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.DangNhapModel;
import model.KetNoiCsdl;
import view.DangNhapView;
import view.QuanLyView;

public class DangNhapController implements ActionListener {
  private DangNhapView dangNhapView;
  
  public DangNhapController(DangNhapView dangNhapView) {
    this.dangNhapView = dangNhapView;
  }
  
  @SuppressWarnings("deprecation")
  @Override
  
  public void actionPerformed(ActionEvent arg0) {
    String taiKhoan = dangNhapView.getTxtTaiKhoan().getText();
    String matKhau = dangNhapView.getTxtMatKhau().getText();
    
    DangNhapModel dangNhap = new DangNhapModel(taiKhoan, matKhau);
    try {
      if (dangNhap.kiemTraDangNhap()) {
        dangNhapView.getFrame().dispose();
        String check = "";
        if (dangNhapView.getCheckLuuMatKhau().isSelected()) {
          check = check + 1;
        } else {
          check = check + 0;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("update save set check_save = '");
        stringBuilder.append(check);
        stringBuilder.append("', user_name ");
        stringBuilder.append("= '");
        stringBuilder.append(dangNhapView.getTxtTaiKhoan().getText());
        stringBuilder.append("', password ");
        stringBuilder.append("= '");
        stringBuilder.append(dangNhapView.getTxtMatKhau().getText());
        stringBuilder.append("' where id = 2");
        String sql = stringBuilder.toString();
        try {
          new KetNoiCsdl().getStatement().executeUpdate(sql);
        } catch (SQLException e1) {
          e1.printStackTrace();
        }
        new QuanLyView();
        
      } else {
        JOptionPane.showMessageDialog(null, "Dang nhap khong thanh cong");
        dangNhapView.getTxtMatKhau().setText(null);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    
  }

}
