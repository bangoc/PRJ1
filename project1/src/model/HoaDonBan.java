package model;

public class HoaDonBan {
  private int giaBan;
  
  public int getgiaBan() {
    return giaBan;
  }
  
  public void setgiaBan(int giaBan) {
    this.giaBan = giaBan;
  }
  
  public void inHoaDon() {
    System.out.println("gia ban la:" + giaBan );
  }

}
