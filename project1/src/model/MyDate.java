package model;

import java.util.Date;

public class MyDate {
  private int ngay;
  private int thang;
  private int nam;
  
  /**
   * Khoi tao myDate theo ngay hien tai.
   * @param date ngay hien tai
   */
  
  @SuppressWarnings("deprecation")
  public MyDate(Date date) {
    this.ngay = date.getDate();
    this.thang = date.getMonth() + 1;
    this.nam = date.getYear() + 1900;
  }
  /**
   * 
   * @param ddmmyy string thoi gian theo dinh dang dd-mm-nn.
   */
  
  public MyDate(String ddmmyy) {
    
    char[] array = ddmmyy.toCharArray();
    this.ngay = Integer.parseInt("" + array[0] + array[1]);
    this.thang = Integer.parseInt("" + array[3] + array[4]);
    this.nam = Integer.parseInt("" + array[6] + array[7] + array[8] + array[9]);
  }

  public int getNgay() {
    return ngay;
  }

  public void setNgay(int ngay) {
    this.ngay = ngay;
  }

  public int getThang() {
    return thang;
  }

  public void setThang(int thang) {
    this.thang = thang;
  }

  public int getNam() {
    return nam;
  }

  public void setNam(int nam) {
    this.nam = nam;
  }
  
  @Override
  
  public String toString() {
    return (this.ngay < 10 ? "0" + this.ngay : "" + this.ngay)
        + (this.thang < 10 ? "-0" + this.thang : "-" + this.thang)
        + "-" + this.nam;
  }

}
