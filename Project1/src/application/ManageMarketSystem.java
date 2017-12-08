/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.io.IOException;
import java.sql.SQLException;
import listView.NewJFrame;
import model.connectDatabase.ConnectDatabase;

/**
 *
 * @author leo
 */
public class ManageMarketSystem {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
       new NewJFrame().setVisible(true);
    }
}
