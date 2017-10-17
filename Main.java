package main;

import java.awt.EventQueue;
import java.sql.SQLException;

import model.KetNoiCsdl;
import model.NhanVien;
import model.SanPham;
import view.DangNhapView;

public class Main {

  /**
   * Launch the application.
   * @throws SQLException tung ra khi co loi ket noi csdl
   */
  public static void main(String[] args) throws SQLException {
    //    KetNoiCsdl con = new KetNoiCsdl();
    //    if (!con.kiemTraTatCaCacBangDaDuocTao()) {
    //      System.out.println("Chua tao du cac bang.");
    //      return;
    //    }
    //    EventQueue.invokeLater(new Runnable() {
    //      public void run() {
    //        try {
    //          new DangNhapView();
    //
    //        } catch (Exception e) {
    //          e.printStackTrace();
    //        }
    //      }
    //    });
    NhanVien nhanVien1 = new NhanVien("Duyen", "ma1");
   
    nhanVien1.setDiaChi("số 1 đại cồ việt");
    nhanVien1.setEmail("123@");
    nhanVien1.setNgaySinh("25-07");
    nhanVien1.setLuong(120);
    nhanVien1.setSoDienThoai("01234568888");
    nhanVien1.setSoChungMinhNhanDan(123456777);
    nhanVien1.inThongTin();
   
    
  }

  /**
   * Create the application.
   */

}
