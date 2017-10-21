package model;

public class HoaDon {
  private int maHoaDon;
  private MyDate ngayTao;
  private int maSanPham;
  private int soLuong;
  
  public int getMaHoaDon() {
    return maHoaDon;
  }
  
  public void setMaHoaDon(int maHoaDon) {
    this.maHoaDon = maHoaDon;
  }
  
  public MyDate getNgayTao() {
    return ngayTao;
  }
  
  public void setNgayTao(MyDate ngayTao) {
    this.ngayTao = ngayTao;
  }
  
  public int getMaSanPham() {
    return maSanPham;
  }
  
  public void setMaSanPham(int maSanPham) {
    this.maSanPham = maSanPham;
  }
  
  public int getSoLuong() {
    return soLuong;
  }
  
  public void setSoLuong(int soLuong) {
    this.soLuong = soLuong;
  }
  
  
  /*
  * in thong tin cua hoa don ra console.
  */
  
  public void inHoaDon() {
    System.out.println("ma hoa don la:" + maHoaDon);
    System.out.println("ngay tao la:" + ngayTao);
    System.out.println("ma san pham la:" + soLuong);
    System.out.println("so luong la:" + soLuong);
  }
}
