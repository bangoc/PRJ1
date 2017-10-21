package model;

public class HoaDonNhap {
  private String thongTinNhaCungCap;
  private int giaNhap;
  
  public String getthongTinNhaCungCap() {
    return thongTinNhaCungCap;
  }
  
  public void setthongTinNhaCungCap(String thongTinNhaCungCap) {
    this.thongTinNhaCungCap = thongTinNhaCungCap;
  }
  
  public int getgiaNhap() {
    return giaNhap;
  }
  
  public void setgiaNhap(int giaNhap) {
    this.giaNhap = giaNhap;
  }
  
  public void inHoaDon() {
    System.out.println("thong tin nha cung cap la:" + thongTinNhaCungCap);
    System.out.println("gia nhap la:" + giaNhap);
  }

}
