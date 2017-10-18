package model;

public class SanPham {
  private String tenSanPham;
  private String maSanPham;
  private String gia;
  private int soLuong;
  private String ngayPhatHanh;
  private String ngayHetHan;
 
  
  public String getNgayPhatHanh() {
    return ngayPhatHanh;
  }

  public void setNgayPhatHanh(String ngayPhatHanh) {
    this.ngayPhatHanh = ngayPhatHanh;
  }

  public String getNgayHetHan() {
    return ngayHetHan;
  }

  public void setNgayHetHan(String ngayHetHan) {
    this.ngayHetHan = ngayHetHan;
  }

  public int getSoLuong() {
    return soLuong;
  }

  public void setSoLuong(int soLuong) {
    this.soLuong = soLuong;
  }

  public SanPham() {
    
  }

  public String getTenSanPham() {
    return tenSanPham;
  }

  public void setTenSanPham(String tenSanPham) {
    this.tenSanPham = tenSanPham;
  }

  public String getMaSanPham() {
    return maSanPham;
  }

  public void setMaSanPham(String maSanPham) {
    this.maSanPham = maSanPham;
  }

  public String getGia() {
    return gia;
  }

  public void setGia(String gia) {
    this.gia = gia;
  }
  
  //  public void biBan(int soLuongBan) {
  //    this.soLuong = this.soLuong - soLuongBan;
  //  }
  
  /**
   * in thong tin cua san pham ra console
   */
  
  public void inThongTin() {
    System.out.println("ten san pham la:" + tenSanPham);
    System.out.println("ma san pham la :" + maSanPham);
    System.out.println("gia san pham la:" + gia);
    System.out.println("so luong san pham la:" + soLuong);
    System.out.println("ngay phat hanh la:" + ngayPhatHanh);
    System.out.println("ngay het han la:" + ngayHetHan);
  }
}
