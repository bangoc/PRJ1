package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DangNhapModel {
  private String taiKhoan;
  private String matKhau;
  private int maNhanVien;
  
  /**
   * 
   * @param taiKhoan ten tai khoan cua nguoi su dung.
   * @param matKhau mat khau tai khoan
   */
  
  public DangNhapModel(String taiKhoan, String matKhau) {
    this.taiKhoan = taiKhoan;
    this.matKhau = matKhau;
    this.maNhanVien = -1;
  }

  public String getTaiKhoan() {
    return taiKhoan;
  }

  public void setTaiKhoan(String taiKhoan) {
    this.taiKhoan = taiKhoan;
  }

  public String getMatKhau() {
    return matKhau;
  }

  public void setMatKhau(String matKhau) {
    this.matKhau = matKhau;
  }
  
  public int getMaNhanVien() {
    return maNhanVien;
  }

  public void setMaNhanVien(int maNhanVien) {
    this.maNhanVien = maNhanVien;
  }
  
  /**
   * Phuong thuc nay kiem tra xem tai khoan mat khau con ton tai trong bang account_tb.
   * @return boolean value
   * @throws SQLException tung khi co loi voi csdl
   */
  public boolean kiemTraDangNhap() throws SQLException {
    KetNoiCsdl con = new KetNoiCsdl();
    String tenBangTaiKhoan = con.getTenBangTaiKhoan();
    System.out.println(tenBangTaiKhoan);
    String sql = "select id from " + tenBangTaiKhoan + " where user_name = '" 
        + this.taiKhoan + "' and password = '" + this.matKhau + "'";
    ResultSet result = con.getStatement().executeQuery(sql);
   
    while (result.next()) {
      this.maNhanVien = result.getInt(1);
    }
    if (this.maNhanVien == -1) {
      return false;
    } else {
      return true;
    }
  }

}
