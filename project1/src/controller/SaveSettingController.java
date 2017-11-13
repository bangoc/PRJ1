package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import model.Saver;
import view.SettingView;
import view.TaskManagerView;

public class SaveSettingController implements ActionListener {
  private  SettingView settingView;
  
  public SaveSettingController(SettingView settingView) {
    this.settingView = settingView;
  }

  @Override
  public void actionPerformed(ActionEvent arg0) {
    ResourceBundle b = ResourceBundle.getBundle("view.Label");

    try {
      Saver.saveLink(settingView.getTxtImportLocation().getText(), 1);
      Saver.saveLink(settingView.getTxtExportLocation().getText(), 2);
      int index = settingView.getComboBox().getSelectedIndex();
      String language = "";
      if (index == 1) {
        language = "English";
        Saver.saveLink(language, 3);
        Locale.setDefault(new Locale("en", "US"));
      } else if (index == 2){
        language = "VietNamese";
        Saver.saveLink(language, 3);
        Locale.setDefault(new Locale("vi", "VN"));
      }
      JOptionPane.showMessageDialog(null, b.getString("successfull"));
      settingView.getFrame().dispose();
      new TaskManagerView();
    } catch (SQLException e1) {
      JOptionPane.showMessageDialog(null, b.getString("sqlError"));
    }

    
  }

}
