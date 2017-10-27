package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Vector;

public class NhanVien {
  private int idNhanVien;
  private String tenNhanVien;
  private int tuoiNhanVien;
  private String gioiTinh;
  private MyDate ngaySinh;
  private MyDate ngayVaoLam;
  private int luongCoBan;
  
  public NhanVien() {
    
  }

  public int getIdNhanVien() {
    return idNhanVien;
  }

  public void setIdNhanVien(int idNhanVien) {
    this.idNhanVien = idNhanVien;
  }

  public String getTenNhanVien() {
    return tenNhanVien;
  }

  public void setTenNhanVien(String tenNhanVien) {
    this.tenNhanVien = tenNhanVien;
  }

  public int getTuoiNhanVien() {
    return tuoiNhanVien;
  }

  public void setTuoiNhanVien(int tuoiNhanVien) {
    this.tuoiNhanVien = tuoiNhanVien;
  }

  public String getGioiTinh() {
    return gioiTinh;
  }

  public void setGioiTinh(String gioiTinh) {
    this.gioiTinh = gioiTinh;
  }

  public MyDate getNgaySinh() {
    return ngaySinh;
  }

  public void setNgaySinh(MyDate ngaySinh) {
    this.ngaySinh = ngaySinh;
  }

  public MyDate getNgayVaoLam() {
    return ngayVaoLam;
  }

  public void setNgayVaoLam(MyDate ngayVaoLam) {
    this.ngayVaoLam = ngayVaoLam;
  }

  public int getLuongCoBan() {
    return luongCoBan;
  }

  public void setLuongCoBan(int luongCoBan) {
    this.luongCoBan = luongCoBan;
  }
  /**
   * Phuong thuc nay lay du lieu thong tin cua nhanVien theo id cua nhanVien tu csdl.
   */
  
  public void loadNhanVien() {
    // code here to get data from database
    String sql = "select * from employeeinfo_tb where id = " + this.idNhanVien;
    KetNoiCsdl con = new KetNoiCsdl();
    try {
      ResultSet result = con.getStatement().executeQuery(sql);
      while (result.next()) {
        this.idNhanVien = result.getInt(1);
        this.tenNhanVien = result.getString(2);
        this.tuoiNhanVien = result.getInt(3);
        this.gioiTinh = result.getString(4);
        this.ngaySinh = new MyDate(result.getString(5));
        this.ngayVaoLam = new MyDate(result.getString(6));
        this.luongCoBan = result.getInt(7);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
  
  /**
   * Phuong thuc nay luu thong tin cua nhanVien vao csdl sau khi thay doi thong tin.
   */
  
  public void saveNhanVien() {
    String sql = "update employeeinfo_tb set name = '" + this.tenNhanVien + "', ages = " 
        + this.tuoiNhanVien + ", sex = '" + this.gioiTinh + "', birth_date = '" 
        + this.ngaySinh.toString() + "', hire_date = '" + this.ngayVaoLam.toString() 
        + "', salary = " + this.luongCoBan + " where employeeinfo_tb.id = " + this.idNhanVien;
    System.out.println(sql);
    KetNoiCsdl con = new KetNoiCsdl();
    try {
      con.getStatement().executeUpdate(sql);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
  
  
  /**
   * Phuong thuc nay lay thong tin cua 1 doi tuong nhanVien luu vao 1 vector.
   * @return vector chua thong tin cua nhanVien
   */
  
  public Vector<String> getThongTin() {
    Vector<String> vector = new Vector<>();
    vector.add("" + this.idNhanVien);
    vector.add(this.tenNhanVien);
    vector.add("" + this.tuoiNhanVien);
    vector.add(this.gioiTinh);
    vector.add(this.ngaySinh.toString());
    vector.add(this.ngayVaoLam.toString());
    vector.add("" + this.luongCoBan);
    return vector;
    
  }
  
  /**
   * .
   */
  
  public void batDauThangLamViecMoi() {
    String sql = "insert into work_time_tb (id, begin_date, end_date, session_count, salary)"
        + " values (" + this.getIdNhanVien() + ", '" + new MyDate(new Date()).toString() 
        + "', 'now', 0, " + this.getLuongCoBan() + ")";
    try {
      new KetNoiCsdl().getStatement().executeUpdate(sql);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
  
  /**
   * Tinh luong cua nhan vien.
   * @return luong nhan vien
   */
  
  public int tinhLuong() {
    int luong = 0;
    String sql = "select session_count from work_time_tb where id = " 
        + this.getIdNhanVien() + " and end_date = 'now'";
    KetNoiCsdl con = new KetNoiCsdl();
    try {
      ResultSet result = con.getStatement().executeQuery(sql);
      while (result.next()) {
        int count = result.getInt(1);
        luong = this.luongCoBan * count;
      }
    } catch (SQLException e) {
      
      e.printStackTrace();
      return 0;
    }
    String sql1 = "update work_time_tb as w set end_date = '" + new MyDate(new Date()).toString() 
        + "'," + " salary = " + this.getLuongCoBan() + " where w.id = " + this.getIdNhanVien() 
        + " and end_date = 'now'";
    try {
      con.getStatement().executeUpdate(sql1);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return luong;
  }
  
  /**
   * .
   * @return vector luu chu lich su lam viec cua nhan vien
   */
  
  public Vector<String[]> loadLichSuLamViec() {
    String sql = "select begin_date, end_date, session_count, "
        + "salary from work_time_tb where id = " + this.idNhanVien;
    Vector<String[]> vector = new Vector<>();
    try {
      ResultSet result = new KetNoiCsdl().getStatement().executeQuery(sql);
      while (result.next()) {
        vector.add(new String[] {result.getString(1), result.getString(2), "" 
            + result.getInt(3), "" + result.getInt(4)});
      }
      return vector;
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }
}
