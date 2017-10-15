package main;

import java.awt.EventQueue;
import java.sql.SQLException;

import model.KetNoiCsdl;
import view.DangNhapView;

public class Main {

  /**
   * Launch the application.
   * @throws SQLException tung ra khi co loi ket noi csdl
   */
  public static void main(String[] args) throws SQLException {
    KetNoiCsdl con = new KetNoiCsdl();
    if (!con.kiemTraTatCaCacBangDaDuocTao()) {
      System.out.println("Chua tao du cac bang.");
      return;
    }
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          new DangNhapView();

        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the application.
   */

}
