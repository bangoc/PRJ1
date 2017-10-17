package model;

public class NhanVien {
  private String tenNhanVien;
  private int tuoi;
  private String maNhanVien;
  private String soDienThoai;
  private int luong;
  private String ngaySinh;
  private String diaChi;
  private String email;
  private int soChungMinhNhanDan; 
  
  //  public String getMaNhanVien() {
  //    return maNhanVien;
  //  }
  //
  //  public void setMaNhanVien(String maNhanVien) {
  //    this.maNhanVien = maNhanVien;
  //  }

  public int getSoChungMinhNhanDan() {
    return soChungMinhNhanDan;
  }

  public void setSoChungMinhNhanDan(int soChungMinhNhanDan) {
    this.soChungMinhNhanDan = soChungMinhNhanDan;
  }

  public NhanVien() {
    
  }
  
  public NhanVien(String tenNhanVien) {
    this.tenNhanVien = tenNhanVien;
  }
  
  public NhanVien(String tenNhanVien, String maNhanVien) {
    this.tenNhanVien = tenNhanVien;
    this.maNhanVien = maNhanVien;
  }
  
  public String getTenNhanVien() {
    return tenNhanVien;
  }
 
  public void setTenNhanVien(String tenNhanVien) {
    this.tenNhanVien = tenNhanVien;
  }
 
  public int getLuong() {
    return luong;
  }
  
  public void setLuong(int luong) {
    this.luong = luong;
  }
  
  public String getNgaySinh() {
    return ngaySinh;
  }
  
  public void setNgaySinh(String ngaySinh) {
    this.ngaySinh = ngaySinh;
  }
  
  public String getDiaChi() {
    return diaChi;
  }
  
  public void setDiaChi(String diaChi) {
    this.diaChi = diaChi;
  }
  
  public String getEmail() {
    return email;
  }
  
  public void setEmail(String email) {
    this.email = email;
  }
  
  public void setSoDienThoai(String soDienThoai) {
    this.soDienThoai = soDienThoai;
  }
  
  public int getTuoi() {
    return tuoi;
  }
   
  public void setTuoi(int tuoi) {
    this.tuoi = tuoi;
  }
   
  public String getSoDienThoai() {
    return soDienThoai;
  }
  /**
   *in thong tin cua nhan vien ra console.
   *
   */ 
  
  public void inThongTin() {
    System.out.println("tên là:" + tenNhanVien);
    System.out.println("mã nhân viên là:" + maNhanVien);
    System.out.println("số điện thoại là:" + soDienThoai);
    System.out.println("lương là:" + luong);
    System.out.println("ngày sinh là:" + ngaySinh);
    System.out.println("địa chỉ là:" + diaChi);
    System.out.println("email là:" + email);
    System.out.println("số chứng minh nhân dân là:" + soChungMinhNhanDan);
  }
  
}

