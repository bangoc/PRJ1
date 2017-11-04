package main;

import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;

import mdl.Employee;
import mdl.ImportReceipt;
import mdl.Manager;
import mdl.Product;
import mdl.SalesPerson;
import mdl.SuperMarket;
import mdl.Supplier;
import model.KetNoiCsdl;
import view.DangNhapView;

public class Main {

  /**
   * Launch the application.
   * @throws SQLException tung ra khi co loi ket noi csdl
   */
  public static void main(String[] args) throws SQLException {
    KetNoiCsdl con = new KetNoiCsdl();
    if (!con.kiemTraTatCaCacBangDaDuocTao()) {
      System.out.println("Chua tao du cac bang.");
      return;
    }
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          new DangNhapView();
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
 
  
//    Manager quanLy = new Manager();
//    quanLy.setName("quanly1");
//    quanLy.setCoefficientsSalary(19);
//    quanLy.setCommission(2000000);
//    Employee nhanVien = new Employee();
//    nhanVien.setName("nhanVien1");
//    nhanVien.setCoefficientsSalary(7);
//    SalesPerson nvBanHang = new SalesPerson();
//    nvBanHang.setName("Ban hang");
//    nvBanHang.setCoefficientsSalary(10);
//    nvBanHang.setSubsidy(1000000);
//    ArrayList<Employee> list = new ArrayList<>();
//    list.add(quanLy);
//    list.add(nvBanHang);
//    list.add(nhanVien);
//    SuperMarket st = new SuperMarket();
//
//    st.setEmployeeList(list);
//    for (Employee nv : st.getEmployeeList()) {
//      System.out.println(nv.getName());
//    }
//    System.out.println(st.countSummarySalary());
//    Product sp1 = new Product();
//    sp1.setName("nuoc ngot");
//    Integer[] i1 = {5, 100000};
//    LinkedHashMap<Product, Integer[]> listItem = new LinkedHashMap<>();
//    listItem.put(sp1, i1);
//    Product sp2 = new Product();
//    sp2.setName("banh keo");
//    Integer[] i2 = {10, 20000};
//    listItem.put(sp2, i2);
//    Supplier ncc = new Supplier();
//    ncc.setIdNumber(1);
//    ncc.setName("aaa");
//    ncc.setEmail("aaa@gmail.com");
//    ncc.setPhoneNumber("0132343232");
//    ImportReceipt hd = quanLy.makeImportReceipt(ncc, listItem);
//    hd.setCode(1);
//    System.out.println(hd.getTotal());
  }

  /**
   * Create the application.
   */

}
