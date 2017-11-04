package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.NhanVien;
import view.MyModel;
import view.MyPanel;
import view.ThongTinNhanVienView;

public class XemThongTinNhanVienController implements ActionListener {
  private MyPanel bangNhanVienView;
  
  public XemThongTinNhanVienController(MyPanel bangNhanVienView) {
    this.bangNhanVienView = bangNhanVienView;
  }
  
  @Override
  public void actionPerformed(ActionEvent e) {
    DefaultTableModel model = bangNhanVienView.getModel();
    JTable table = bangNhanVienView.getTable();
    int row = table.getSelectedRow();
    if (row == -1) {
      return;
    }
    String s = (String) model.getValueAt(row, 0);
    int idNhanVien = Integer.parseInt(s);
    NhanVien nhanVien = new NhanVien();
    nhanVien.setIdNhanVien(idNhanVien);
    try {
      nhanVien.loadNhanVien();
    } catch (ParseException e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    }
    ThongTinNhanVienView thongTinView = new ThongTinNhanVienView();
    ArrayList<JLabel> listLabel = thongTinView.getListLabel();
    listLabel.get(0).setText("Ma nhan vien");
    listLabel.get(1).setText("Ho va Ten");
    listLabel.get(2).setText("Tuoi");
    listLabel.get(3).setText("Gioi tinh");
    listLabel.get(4).setText("Ngay sinh");
    listLabel.get(5).setText("Ngay vao lam");
    listLabel.get(6).setText("Luong / ca");
    ArrayList<JLabel> listText = thongTinView.getListText();
    listText.get(0).setText("" + nhanVien.getIdNhanVien());
    listText.get(1).setText(nhanVien.getTenNhanVien());
    listText.get(2).setText("" + nhanVien.getTuoiNhanVien());
    listText.get(3).setText(nhanVien.getGioiTinh());
    DateFormat df = new SimpleDateFormat("dd/mm/yyyy");

    listText.get(4).setText(df.format(nhanVien.getNgaySinh()));
    listText.get(5).setText(df.format(nhanVien.getNgayVaoLam()));
    listText.get(6).setText("" + nhanVien.getLuongCoBan());
    
    String[] array = {"Ngay bat dau", "Ngay ket thuc", "So ca lam viec", "Luong / ca"};
    DefaultTableModel newModel = new MyModel(array);
    Vector<String[]> vector;
    try {
      vector = nhanVien.vectorThongTinLichSuLamViec();
      for (String [] strArray : vector) {
        newModel.addRow(strArray);
      }
      MyPanel bang = new MyPanel();
      bang.getTable().setModel(newModel);
      thongTinView.getFrame().getContentPane().add(bang);
    } catch (ParseException e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    }
  
    
  }

}
