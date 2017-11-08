package main;

import java.awt.EventQueue;
import java.sql.SQLException;
import view.LoginView;

public class Main {

  /**
   * Launch the application.
   * @throws SQLException tung ra khi co loi ket noi csdl
   */
  public static void main(String[] args) throws SQLException {

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
