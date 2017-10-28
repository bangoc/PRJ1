package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NhaCungCap {
  private int maNhaCungCap;
  private String tenNhaCungCap;
  private String diaChia;
  private String email;
  private String soDienThoai;
  
  public NhaCungCap() {
    
  }

  public int getMaNhaCungCap() {
    return maNhaCungCap;
  }

  public void setMaNhaCungCap(int maNhaCungCap) {
    this.maNhaCungCap = maNhaCungCap;
  }

  public String getTenNhaCungCap() {
    return tenNhaCungCap;
  }

  public void setTenNhaCungCap(String tenNhaCungCap) {
    this.tenNhaCungCap = tenNhaCungCap;
  }

  public String getDiaChia() {
    return diaChia;
  }

  public void setDiaChia(String diaChia) {
    this.diaChia = diaChia;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getSoDienThoai() {
    return soDienThoai;
  }

  public void setSoDienThoai(String soDienThoai) {
    this.soDienThoai = soDienThoai;
  }
  
  /**
   * Lay du lieu nha cung cap tu csdl.
   */
  
  public void loadNhaCungCap() {
    String sql = "select * from nha_cung_cap_tb where id = " + this.maNhaCungCap;
    try {
      ResultSet result = new KetNoiCsdl().getStatement().executeQuery(sql);
      while (result.next()) {
        this.tenNhaCungCap = result.getString(2);
        this.diaChia = result.getString(3);
        this.email = result.getString(4);
        this.soDienThoai = result.getString(5);
        System.out.println(tenNhaCungCap);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
  
  /**
   * Kiem tra ton tai cua nha cung cap.
   * @return boolean value
   * @throws NullPointerException when nha cung cap khong ton tai
   */
  
  public boolean isValid() throws NullPointerException {
    if (this.tenNhaCungCap.isEmpty()) {
      return false;
    } else if (this.diaChia.isEmpty()) {
      return false;
    } else if (this.email.isEmpty()) {
      return false;
    } else if (this.soDienThoai.isEmpty()) {
      return false;
    } else {
      return true;
    }
  }
}
