package model;

public class LichSuLamViec {
  private MyDate ngayBatDau;
  private MyDate ngayKetThuc;
  private int soNgayLamViec;
  private int luongThoiDiemDo;
  
  public MyDate getNgayBatDau() {
    return ngayBatDau;
  }
  
  public void setNgayBatDau(MyDate ngayBatDau) {
    this.ngayBatDau = ngayBatDau;
  }
  
  public MyDate getNgayKetThuc() {
    return ngayKetThuc;
  }
  
  public void setNgayKetThuc(MyDate ngayKetThuc) {
    this.ngayKetThuc = ngayKetThuc;
  }
  
  public int getSoNgayLamViec() {
    return soNgayLamViec;
  }
  
  public void setSoNgayLamViec(int soNgayLamViec) {
    this.soNgayLamViec = soNgayLamViec;
  }
  
  public int getLuongThoiDiemDo() {
    return luongThoiDiemDo;
  }
  
  public void setLuongThoiDiemDo(int luongThoiDiemDo) {
    this.luongThoiDiemDo = luongThoiDiemDo;
  }

}
