package model;

public class DieuKien {
  private String maSanPham;
  private String maNhaCungCap;

  public String getMaNhaCungCap() {
    return maNhaCungCap;
  }

  public void setMaNhaCungCap(String maNhaCungCap) {
    this.maNhaCungCap = maNhaCungCap;
  }

  private String dkTenSanPham;
  private String dkSoLuongHienCo;
  private String dkNhaSanXuat;
  private String dkSoLuongDaBan;

  public String getMaSanPham() {
    return maSanPham;
  }

  public void setMaSanPham(String maSanPham) {
    this.maSanPham = maSanPham;
  }
  
  public String getDkTenSanPham() {
    return dkTenSanPham;
  }

  public void setDkTenSanPham(String dkTenSanPham) {
    this.dkTenSanPham = dkTenSanPham;
  }

  public String getDkSoLuongHienCo() {
    return dkSoLuongHienCo;
  }

  public void setDkSoLuongHienCo(String dkGia) {
    this.dkSoLuongHienCo = dkGia;
  }

  public String getDkNhaSanXuat() {
    return dkNhaSanXuat;
  }

  public void setDkNhaSanXuat(String dkNhaSanXuat) {
    this.dkNhaSanXuat = dkNhaSanXuat;
  }

 

  public String getDkSoLuongDaBan() {
    return dkSoLuongDaBan;
  }

  public void setDkSoLuongDaBan(String dkSoLuongDaBan) {
    this.dkSoLuongDaBan = dkSoLuongDaBan;
  }
  
  @Override
  
  public String toString() {
    StringBuffer dieuKien = new StringBuffer();
    if (!this.maSanPham.isEmpty()) {
      dieuKien.append(" and g.code = ");
      dieuKien.append(this.maSanPham);
    }
    if (!this.maNhaCungCap.isEmpty()) {
      dieuKien.append(" and id_nha_cung_cap = ");
      dieuKien.append(this.maNhaCungCap);
    }
    if (!this.dkSoLuongHienCo.isEmpty()) {
      dieuKien.append(" and remain_amount ");
      dieuKien.append(this.dkSoLuongHienCo);
    }
    if (!this.dkTenSanPham.isEmpty()) {
      dieuKien.append(" and g.name = upper('"); 
      dieuKien.append(this.dkTenSanPham); 
      dieuKien.append("')");
    }
    if (!this.dkNhaSanXuat.isEmpty()) {
      dieuKien.append(" and producer = upper('");
      dieuKien.append(this.dkNhaSanXuat);
      dieuKien.append("')");
    }
    if (!this.dkSoLuongDaBan.isEmpty()) {
      dieuKien.append(" and sold_amount ");
      dieuKien.append(this.dkSoLuongDaBan);
    }
    return dieuKien.toString();
  }

}
