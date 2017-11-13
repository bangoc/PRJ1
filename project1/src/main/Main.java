package main;

import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;

import model.Loader;
import view.LoginView;

public class Main {

  /**
   * Launch the application.
   * @throws SQLException tung ra khi co loi ket noi csdl
   */
  public static void main(String[] args) {
    Locale[] locales = {
        new Locale ("en", "US"),
        new Locale ("vi", "VN")
    };
    try {
      String language = Loader.loadLink(3);
      if (language.equals("English")) {
        Locale.setDefault(locales[0]);
        System.out.println("Language : English");
      } else if (language.equals("VietNamese")) {
        Locale.setDefault(locales[1]);
	System.out.println("Ngôn ngữ : Tiếng Việt");
      } else {
        return;
      }

    } catch (SQLException e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
      return;
    }
    ResourceBundle mybundle = ResourceBundle.getBundle("view.Label");
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          new LoginView();
          
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });

  }
}
