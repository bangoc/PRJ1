package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;
import model.ConnectDatabase;
import model.ResolveLoginProcess;
import view.LoginView;
import view.TaskManagerView;

public class LoginController implements ActionListener {
  private LoginView dangNhapView;
  
  public LoginController(LoginView dangNhapView) {
    this.dangNhapView = dangNhapView;
  }
  
  @SuppressWarnings("deprecation")
  @Override
  
  public void actionPerformed(ActionEvent arg0) {
    ResourceBundle b = ResourceBundle.getBundle("view.Label");

    String taiKhoan = dangNhapView.getTxtTaiKhoan().getText();
    String matKhau = dangNhapView.getTxtMatKhau().getText();
    
    ResolveLoginProcess dangNhap = new ResolveLoginProcess(taiKhoan, matKhau);
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
          new ConnectDatabase().getStatement().executeUpdate(sql);
        } catch (SQLException e1) {
          e1.printStackTrace();
        }
        new TaskManagerView();
        
      } else {
        JOptionPane.showMessageDialog(null, b.getString("fail"));
        dangNhapView.getTxtMatKhau().setText(null);
      }
    } catch (SQLException e) {
      JOptionPane.showMessageDialog(null, b.getString("sqlError"));
    }
    
  }

}
