package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

public class Hh {
  private int maHangHoa;
  private String tenSanPham;
  private int giaSanPham;
  private String nhaSanXuat;
  private int maNhaCungCap;
  private Date ngaySanXuat;
  private Date ngayHetHan;
  private int soLuongHienCo;
  private int soLuongDaBan;
  
  public Hh() {
    
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
  
  public Date getNgaySanXuat() {
    return ngaySanXuat;
  }
  
  public void setNgaySanXuat(Date ngaySanXuat) {
    this.ngaySanXuat = ngaySanXuat;
  }
  
  public Date getNgayHetHan() {
    return ngayHetHan;
  }
  
  public void setNgayHetHan(Date ngayHetHan) {
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
   * @throws ParseException e
   */
  
  public void loadHangHoa() throws ParseException {
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
        //to do///
        DateFormat df = new SimpleDateFormat("dd/mm/yyyy");

        this.ngaySanXuat = df.parse(result.getString(4));
        this.ngayHetHan = df.parse(result.getString(5));
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
      vector.add(new String[] {"No data", "No data", "No data", "No data", "No data", "No data"});
      return vector;
    }
    String sql = "select g.code, id_nha_cung_cap, name, producer, remain_amount,"
        + " sold_amount from goods_tb as g, import_bill_tb as i where g.code = i.code "
        + dieuKien.toString();
    try {
      ResultSet result = new KetNoiCsdl().getStatement().executeQuery(sql);
      while (result.next()) {
        vector.add(new String[] {"" + result.getInt(1), "" + result.getInt(2), result.getString(3),
            result.getString(4), "" + result.getInt(5), "" + result.getInt(6)});
      }
      if (vector.isEmpty()) {
        vector.add(new String[] {"No data", "No data", "No data", "No data", "No data", "No data"});
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
