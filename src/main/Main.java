package main;

import java.awt.EventQueue;
import java.io.File;

import view.LoginView;

public class Main {
  
  public static void main(String[] args) {
    System.out.println(new File(".").getAbsolutePath());
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          LoginView window = new LoginView();
         
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

}
