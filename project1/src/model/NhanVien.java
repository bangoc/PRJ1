package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
  private ArrayList<LichSuLamViec> lsLamViec;
  
  public NhanVien() {

  }

  
  public ArrayList<LichSuLamViec> getLsLamViec() {
    return lsLamViec;
  }

  public void setLsLamViec(ArrayList<LichSuLamViec> lsLamViec) {
    this.lsLamViec = lsLamViec;
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
    LichSuLamViec ls = new LichSuLamViec();
    this.lsLamViec.add(ls);
    String sql = "insert into work_time_tb (id, begin_date, end_date, session_count, salary)"
        + " values (" + this.getIdNhanVien() + ", '" + ls.getNgayBatDau().toString() 
        + "', '99-99-9999', 0, " + this.getLuongCoBan() + ")";
    try {
      new KetNoiCsdl().getStatement().executeUpdate(sql);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
  
  /**
   * Tra luong cua nhan vien.
   * 
   */
  
  public void traLuong() {

    LichSuLamViec ls = this.lsLamViec.get(this.lsLamViec.size() - 1);
    ls.setNgayKetThuc(new MyDate(new Date()));
    ls.setLuongThoiDiem(this.luongCoBan);
    KetNoiCsdl con = new KetNoiCsdl();
    String sql1 = "update work_time_tb as w set end_date = '" + new MyDate(new Date()).toString() 
        + "'," + " salary = " + this.getLuongCoBan() + " where w.id = " + this.getIdNhanVien() 
        + " and end_date = '99-99-9999'";
    try {
      con.getStatement().executeUpdate(sql1);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    
  }
  
  /**
   * .
   * @return vector luu chu lich su lam viec cua nhan vien
   */
  
  public Vector<String[]> convertVector() {
    this.loadLsLamViec();
    Vector<String[]> vector = new Vector<>();
    for (LichSuLamViec ls : this.lsLamViec) {
      String[] str = {ls.getNgayBatDau().toString(), ls.getNgayKetThuc().toString(),
          "" + ls.getSoCaLamViec(), "" + ls.getLuongThoiDiem()};
      vector.add(str);
    }
    return vector;
  }
   
    
  
  /**
   * Lay du lieu lich su lam viec cho nhan vien.
   */
  
  public void loadLsLamViec() {
    String sql = "select begin_date, end_date, session_count, "
        + "salary from work_time_tb where id = " + this.idNhanVien;
    this.lsLamViec = new ArrayList<>();
    try {
      ResultSet result = new KetNoiCsdl().getStatement().executeQuery(sql);
      while (result.next()) {
        LichSuLamViec ls = new LichSuLamViec();
        ls.setNgayBatDau(new MyDate(result.getString(1)));
        ls.setNgayKetThuc(new MyDate(result.getString(2)));
        ls.setSoCaLamViec(result.getInt(3));
        ls.setLuongThoiDiem(result.getInt(4));
        this.lsLamViec.add(ls);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
