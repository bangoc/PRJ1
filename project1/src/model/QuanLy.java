package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Vector;

public class QuanLy extends NhanVien {
  /**
   * Them nhan vien vao csdl.
   * @param nhanVien nhan vien duoc them moi
   */
  
  public void themNhanVien(NhanVien nhanVien) {
    String sql = "insert into employeeinfo_tb "
        + "(id, name, ages, sex, birth_date, hire_date, salary) "
        + "values (null, '" + nhanVien.getTenNhanVien() + "', " + nhanVien.getTuoiNhanVien() + ","
        + " '" + nhanVien.getGioiTinh() + "', '" + nhanVien.getNgaySinh().toString() + "',"
        + " '" + nhanVien.getNgayVaoLam().toString() + "', " + nhanVien.getLuongCoBan() + " )";
    try {
      new KetNoiCsdl().getStatement().executeUpdate(sql);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    
    String sql1 = "select max(id) from employeeinfo_tb";
    try {
      ResultSet result = new KetNoiCsdl().getStatement().executeQuery(sql1);
      while (result.next()) {
        nhanVien.setIdNhanVien(result.getInt(1));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    nhanVien.batDauThangLamViecMoi();
   
  }
  
  /**
   * Tao tai khoan dang nhap cho nhanVien.
   * @param nhanVien nhan vien duoc tao tai khoan moi
   */
  
  public void taoTaiKhoanDangNhapChoNhanVien(NhanVien nhanVien) {
    
    
    String sql = "insert into account_tb (id, user_name, password)"
        + "values (" + nhanVien.getIdNhanVien() + ", '" + nhanVien.getTenNhanVien()
        + "', '" + nhanVien.getTenNhanVien() + "')";
    try {
      new KetNoiCsdl().getStatement().executeUpdate(sql);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
  
  public void thayDoiLuongNhanVien(NhanVien nhanVien, int luongMoi) {
    nhanVien.setLuongCoBan(luongMoi);
    nhanVien.saveNhanVien();
  }
  
  /**
   * Phuong thuc lay thong tin danh sach nhan vien tu csdl.
   * @return vector chua thong tin nhan vien
   */
  
  public Vector<String[]> getDanhSachNhanVien() {
    String sql = "select em.id, em.name, em.salary, w.session_count "
        + "from employeeinfo_tb as em, work_time_tb as w "
        + "where em.id = w.id and w.end_date = 'now' ";
    KetNoiCsdl con = new KetNoiCsdl();
    ResultSet result;
    Vector<String[]> vector = new Vector<>();
    try {
      result = con.getStatement().executeQuery(sql);
      while (result.next()) {
        String[] str = {"" + result.getInt(1), result.getString(2), "" + result.getInt(3), "" 
            + result.getInt(4)};
        vector.add(str);
      }
      return vector;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
    
  }
  
  /**
   * Luu du lieu san pham duoc nhap vao trong csdl.
   * @param hangHoa hang hoa duoc nhap vao
   */
  
  public void themHangHoa(HangHoa hangHoa) {
    String sql = "insert into goods_tb (code, name, price, producer, produce_date, expire_date, "
        + "remain_amount, sold_amount) values (null, '" + hangHoa.getTenSanPham() + "', "
        + hangHoa.getGiaSanPham() + ", '" + hangHoa.getNhaSanXuat() + "', '"
        + hangHoa.getNgaySanXuat().toString() + "', '" + hangHoa.getNgayHetHan().toString() 
        + "', " + hangHoa.getSoLuongHienCo() + ", 0)";
    KetNoiCsdl con = new KetNoiCsdl();
    try {
      con.getStatement().executeUpdate(sql);
      String sql1 = "select max(code) from goods_tb";
      try {
        ResultSet result = con.getStatement().executeQuery(sql1);
        int maHangHoa = 0;
        while (result.next()) {
          maHangHoa = result.getInt(1);
        }
        String sql2 = "insert into import_bill_tb (code_import, id_nha_cung_cap, code, "
            + "time, sold_price) values (null, " + hangHoa.getMaNhaCungCap() + ", "
            + maHangHoa + ", '" + new MyDate(new Date()).toString() + "', " 
            + hangHoa.getGiaSanPham() + ")";
        System.out.println(sql2);
        con.getStatement().executeUpdate(sql2);
      } catch (SQLException e) {
        e.printStackTrace();
        return;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    
    
  }
}
