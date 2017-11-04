package model;

import java.util.Date;

public class ChiPhiKhac {
  private int maGiaoDich;
  private String tenChiPhi;
  private Date ngayPhatSinh;
  private int giaTien;
  
  public ChiPhiKhac() {
    
  }
  
  public int getMaGiaoDich() {
    return this.maGiaoDich;
  }
  
  public void setMaGiaoDich(int maGiaoDich) {
    this.maGiaoDich = maGiaoDich;
  }
  
  public String getTenChiPhi() {
    return tenChiPhi;
  }

  public void setTenChiPhi(String tenChiPhi) {
    this.tenChiPhi = tenChiPhi;
  }

  public Date getNgayPhatSinh() {
    return ngayPhatSinh;
  }

  public void setNgayPhatSinh(Date ngayPhatSinh) {
    this.ngayPhatSinh = ngayPhatSinh;
  }

  public int getGiaTien() {
    return giaTien;
  }

  public void setGiaTien(int giaTien) {
    this.giaTien = giaTien;
  }
  
  
 
}
