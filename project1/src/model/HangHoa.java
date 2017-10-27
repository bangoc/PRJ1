package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class HangHoa {
  private int maHangHoa;
  private String tenSanPham;
  private int giaSanPham;
  private String nhaSanXuat;
  private int maNhaCungCap;
 

  private MyDate ngaySanXuat;
  private MyDate ngayHetHan;
  private int soLuongHienCo;
  private int soLuongDaBan;
  
  public HangHoa() {
    
  }
  
  public int getMaNhaCungCap() {
    return maNhaCungCap;
  }

  public void setMaNhaCungCap(int maNhaCungCap) {
    this.maNhaCungCap = maNhaCungCap;
  }
  
  public int getMaHangHoa() {
    return maHangHoa;
  }
  
  public void setMaHangHoa(int maHangHoa) {
    this.maHangHoa = maHangHoa;
  }
  
  public String getTenSanPham() {
    return tenSanPham;
  }
  
  public void setTenSanPham(String tenSanPham) {
    this.tenSanPham = tenSanPham;
  }
  
  public int getGiaSanPham() {
    return giaSanPham;
  }
  
  public void setGiaSanPham(int giaSanPham) {
    this.giaSanPham = giaSanPham;
  }
  
  public String getNhaSanXuat() {
    return nhaSanXuat;
  }
  
  public void setNhaSanXuat(String nhaSanXuat) {
    this.nhaSanXuat = nhaSanXuat;
  }
  
  public MyDate getNgaySanXuat() {
    return ngaySanXuat;
  }
  
  public void setNgaySanXuat(MyDate ngaySanXuat) {
    this.ngaySanXuat = ngaySanXuat;
  }
  
  public MyDate getNgayHetHan() {
    return ngayHetHan;
  }
  
  public void setNgayHetHan(MyDate ngayHetHan) {
    this.ngayHetHan = ngayHetHan;
  }
  
  public int getSoLuongHienCo() {
    return soLuongHienCo;
  }
  
  public void setSoLuongHienCo(int soLuongHienCo) {
    this.soLuongHienCo = soLuongHienCo;
  }
  
  public int getSoLuongDaBan() {
    return soLuongDaBan;
  }
  
  public void setSoLuongDaBan(int soLuongDaBan) {
    this.soLuongDaBan = soLuongDaBan;
  }
  
  /**
   * Phuong thuc lay du lieu cua san pham tu csdl.
   */
  
  public void loadHangHoa() {
    String sql = "select name, price, producer, produce_date, expire_date, remain_amount,"
        + " sold_amount, id_nha_cung_cap from goods_tb as g, import_bill_tb as i where g.code "
        + "= i.code and g.code = " + this.maHangHoa;
    try {
      ResultSet result = new KetNoiCsdl().getStatement().executeQuery(sql);
      while (result.next()) {
        this.tenSanPham = result.getString(1);
        this.giaSanPham = result.getInt(2);
        this.nhaSanXuat = result.getString(3);
        this.maNhaCungCap = result.getInt(8);
        this.ngaySanXuat = new MyDate(result.getString(4));
        this.ngayHetHan = new MyDate(result.getString(5));
        this.soLuongHienCo = result.getInt(6);
        this.soLuongDaBan = result.getInt(7);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
  
  /**
   * .
   * @param dieuKien dieu kien tim kiem
   * @return gia tri can tim
   */
  
  public Vector<String[]> getThongTinHangHoa(DieuKien dieuKien) {
    Vector<String[]> vector = new Vector<>();

    if (dieuKien.toString().isEmpty()) {
      vector.add(new String[] {"No data", "No data", "No data", "No data", "No data"});
      return vector;
    }
    String sql = "select code, name, producer, remain_amount, sold_amount from goods_tb"
        + " where code > 0 "  + dieuKien.toString();
    try {
      ResultSet result = new KetNoiCsdl().getStatement().executeQuery(sql);
      while (result.next()) {
        vector.add(new String[] {"" + result.getInt(1), result.getString(2), result.getString(3),
            "" + result.getInt(4), "" + result.getInt(5)});
      }
      if (vector.isEmpty()) {
        vector.add(new String[] {"No data", "No data", "No data", "No data", "No data"});
        return vector;
      } else {
        return vector;
      }
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
    
  }
}
