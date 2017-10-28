package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import model.DieuKien;
import model.HangHoa;
import view.MyModel;
import view.QuanLyHangHoaView;

public class TimKiemSanPhamController implements ActionListener {
  private QuanLyHangHoaView view;
  
  public TimKiemSanPhamController(QuanLyHangHoaView quanLyHangHoaView) {
    this.view = quanLyHangHoaView;
  }
  
  @Override
  public void actionPerformed(ActionEvent e) {
    DieuKien dieuKien = new DieuKien();
    dieuKien.setDkTenSanPham(view.getTxtName().getText());
    dieuKien.setDkNhaSanXuat(view.getTxtProducer().getText());
    dieuKien.setDkSoLuongHienCo(view.getTxtRemainamount().getText());
    dieuKien.setDkSoLuongDaBan(view.getTxtSoldAmount().getText());
    dieuKien.setMaSanPham(view.getTxtCode().getText());
    dieuKien.setMaNhaCungCap(view.getTxtProviderId().getText());
    Vector<String[]> vector = new HangHoa().getThongTinHangHoa(dieuKien);
    String [] columnNames = {"Ma san pham", "Ma nha cung cap", "Ten san pham", "Nha san xuat",
        "So luong hien co", "So luong da ban"};
    DefaultTableModel  model = new MyModel(columnNames);
   
    for (String[] str : vector) {
      model.addRow(str);
    }
    view.getPanel().getTable().setModel(model);
    view.getPanel().setModel(model);
  }

}
