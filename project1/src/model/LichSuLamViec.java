package model;

import java.util.Date;

public class LichSuLamViec {
  private MyDate ngayBatDau;
  private MyDate ngayKetThuc;
  private int luongThoiDiem;
  private int soCaLamViec;
  
  public LichSuLamViec() {
    this.ngayBatDau = new MyDate(new Date());
    this.ngayKetThuc = new MyDate("99-99-9999");
    this.luongThoiDiem = 0;
    this.soCaLamViec = 0;
  }

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

  public int getLuongThoiDiem() {
    return luongThoiDiem;
  }

  public void setLuongThoiDiem(int luongThoiDiem) {
    this.luongThoiDiem = luongThoiDiem;
  }

  public int getSoCaLamViec() {
    return soCaLamViec;
  }

  public void setSoCaLamViec(int soCaLamViec) {
    this.soCaLamViec = soCaLamViec;
  }
}
