package model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LichSuLamViec {
  private Date ngayBatDau;
  private Date ngayKetThuc;
  private int luongThoiDiem;
  private int soCaLamViec;
  
  /**
   * Constructor.
   * @throws ParseException e
   */
  
  public LichSuLamViec() throws ParseException {
    this.ngayBatDau = new Date();
    DateFormat df = new SimpleDateFormat("dd/mm/yyyy");

    this.ngayKetThuc = df.parse("11/11/2100");
    this.luongThoiDiem = 0;
    this.soCaLamViec = 0;
  }

  public Date getNgayBatDau() {
    return ngayBatDau;
  }

  public void setNgayBatDau(Date ngayBatDau) {
    this.ngayBatDau = ngayBatDau;
  }

  public Date getNgayKetThuc() {
    return ngayKetThuc;
  }

  public void setNgayKetThuc(Date ngayKetThuc) {
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
