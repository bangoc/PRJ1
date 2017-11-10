package model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Vector;

public class ConnectDatabase {
  private Statement statement;
  private PreparedStatement preparedStatement;
  private Connection connect;
  public Connection getConnect() {
    return connect;
  }

  public void setConnect(Connection connect) {
    this.connect = connect;
  }

  public PreparedStatement getPreparedStatement() {
    return preparedStatement;
  }

  public void setPreparedStatement(PreparedStatement preparedStatement) {
    this.preparedStatement = preparedStatement;
  }

  private String databaseName;
  private String tenBangTaiKhoan;
  private String tenBangHoaDonXuat;
  private String tenBangHoaDonNhap;
  private String tenBangNhanVien;
  private String tenBangNhaCungCap;
  private String tenBangChamCong;
  private String tenBangHangHoa;
  
  /**
   * Tao ket noi voi csdl.
   */
  
  public ConnectDatabase() {
    try {
      this.taoKetNoiVoiCsdl();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  
  public String getTenBangTaiKhoan() {
    return tenBangTaiKhoan;
  }

  public void setTenBangTaiKhoan(String tenBangTaiKhoan) {
    this.tenBangTaiKhoan = tenBangTaiKhoan;
  }

  public String getTenBangHoaDonXuat() {
    return tenBangHoaDonXuat;
  }

  public void setTenBangHoaDonXuat(String tenBangHoaDonXuat) {
    this.tenBangHoaDonXuat = tenBangHoaDonXuat;
  }

  public String getTenBangHoaDonNhap() {
    return tenBangHoaDonNhap;
  }

  public void setTenBangHoaDonNhap(String tenBangHoaDonNhap) {
    this.tenBangHoaDonNhap = tenBangHoaDonNhap;
  }

  public String getTenBangNhanVien() {
    return tenBangNhanVien;
  }

  public void setTenBangNhanVien(String tenBangNhanVien) {
    this.tenBangNhanVien = tenBangNhanVien;
  }

  public String getTenBangNhaCungCap() {
    return tenBangNhaCungCap;
  }

  public void setTenBangNhaCungCap(String tenBangNhaCungCap) {
    this.tenBangNhaCungCap = tenBangNhaCungCap;
  }

  public String getTenBangChamCong() {
    return tenBangChamCong;
  }

  public void setTenBangChamCong(String tenBangChamCong) {
    this.tenBangChamCong = tenBangChamCong;
  }

  public String getTenBangHangHoa() {
    return tenBangHangHoa;
  }

  public void setTenBangHangHoa(String tenBangHangHoa) {
    this.tenBangHangHoa = tenBangHangHoa;
  }

  public Statement getStatement() {
    return statement;
  }

  public void setStatement(Statement statement) {
    this.statement = statement;
  }

  public String getDatabaseName() {
    return databaseName;
  }

  public void setDatabaseName(String databaseName) {
    this.databaseName = databaseName;
  }
  
  /**
   * Phuong thuc nay giup ta tao ket noi voi co so du lieu
   * thong tin ve ten csdl, tai khoan, mat khau duoc dat trong 
   * file jdbc.properties.
   * @throws IOException tung ra khi khong ket noi duoc voi csdl
   */
  
  public void taoKetNoiVoiCsdl() throws IOException {
    Properties prop = new Properties();
   
    prop.load(ConnectDatabase.class.getClassLoader()
        .getResourceAsStream("jdbc.properties"));

    String driverClass = prop.getProperty("MYSQLJDBC.driver");
    String url = prop.getProperty("MYSQLJDBC.url");
    String userName = prop.getProperty("MYSQLJDBC.username");
    String password = prop.getProperty("MYSQLJDBC.password");
    String databaseName = prop.getProperty("MYSQLJDBC.databaseName");
    this.tenBangChamCong = prop.getProperty("MYSQLJDBC.tenBangChamCong");
    this.tenBangHangHoa = prop.getProperty("MYSQLJDBC.tenBangHangHoa");
    this.tenBangHoaDonNhap = prop.getProperty("MYSQLJDBC.tenBangHoaDonNhap");
    this.tenBangHoaDonXuat = prop.getProperty("MYSQLJDBC.tenBangHoaDonXuat");
    this.tenBangNhaCungCap = prop.getProperty("MYSQLJDBC.tenBangNhaCungCap");
    this.tenBangNhanVien = prop.getProperty("MYSQLJDBC.tenBangNhanVien");
    this.tenBangTaiKhoan = prop.getProperty("MYSQLJDBC.tenBangTaiKhoan");
    
    try {  
      Class.forName(driverClass);  
      Connection con = DriverManager.getConnection(url,userName,password); 
      this.statement = con.createStatement();  
      this.connect = con;
      this.databaseName = databaseName;
    } catch (ClassNotFoundException e) {
      System.out.println(e);
    } catch (SQLException e) {
      System.out.println(e);
    }
  }
  /**
   * 
   * @param tenBang ten bang muon kiem tra.
   * @return true neu bang ton tai, false neu bang khong ton tai
   * @throws SQLException tung khi co loi khi thao tac voi co so du lieu
   */
  
  public boolean kiemTraTonTaiBang(String tenBang) throws SQLException {
    String sql = "SELECT COUNT(*) FROM information_schema.`TABLES` WHERE `TABLE_SCHEMA` "
        + "= '" + this.databaseName + "' AND `TABLE_NAME` = '" + tenBang + "'";
    ResultSet rs = this.statement.executeQuery(sql);
    int count = 0;
    while (rs.next()) {
      count = rs.getInt(1);
      
    }
    if (count == 0) {
      return false;
    } else {
      return true;
    }
  }
  /**
   * 
   * @return true neu cac bang theo yeu cau da duoc tao, nguoc lai tra ve false.
   * @throws SQLException tung ra khi co loi thao tac voi co so du lieu
   */
  
  public boolean kiemTraTatCaCacBangDaDuocTao() throws SQLException {
    if (!this.kiemTraTonTaiBang(tenBangChamCong)) {
      return false;
    } else if (!this.kiemTraTonTaiBang(tenBangHangHoa)) {
      return false;
    } else if (!this.kiemTraTonTaiBang(tenBangHoaDonNhap)) {
      return false;
    } else if (!this.kiemTraTonTaiBang(tenBangHoaDonXuat)) {
      return false;
    } else if (!this.kiemTraTonTaiBang(tenBangNhaCungCap)) {
      return false;
    } else if (!this.kiemTraTonTaiBang(tenBangNhanVien)) {
      return false;
    } else if (!this.kiemTraTonTaiBang(tenBangTaiKhoan)) {
      return false;
    } else {
      return true;
    }
  }  
  
  /**
   * .
   * @return vector
   */
  
  public Vector<String> getTaiKhoanMatKhau() {
   
    String sql = "select * from save where id = 2";
    Vector<String> vector = new Vector<>();
    try {
      ResultSet result = this.statement.executeQuery(sql);
      while (result.next()) {
        vector.add(result.getString(1));
        vector.add(result.getString(2));
        vector.add(result.getString(3));
      }
      return vector;
      
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }
}
