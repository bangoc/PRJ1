/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.connectDatabase;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.connectDatabase.ConnectAccount;
import model.connectDatabase.ConnectDatabase;

/**
 *
 * @author leo
 */
public class ConnectLocale {
    public static ArrayList<Locale> getLocales() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "select * from locale";
        ArrayList<Locale> locales = new ArrayList<>();
        try {
            con = ConnectDatabase.createConnect();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                locales.add(new Locale(rs.getString(1), rs.getString(2)));
            }
        } catch (IOException | ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ConnectLocale.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "System error!");
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConnectAccount.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConnectAccount.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConnectAccount.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return locales;
    }
    
    public static Locale getSettingLocale() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "select * from setting where setting = ?";
        Locale locale = null;
        try {
            con = ConnectDatabase.createConnect();
            ps = con.prepareStatement(query);
            ps.setString(1, "language");
            rs = ps.executeQuery();
            while (rs.next()) {
                locale = new Locale(rs.getString(1), rs.getString(2));
            }
        } catch (IOException | ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ConnectLocale.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "System error!");
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConnectAccount.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConnectAccount.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConnectAccount.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return locale;
    }
    
    public static void saveSettingLocale(Locale locale) {
        Connection con = null;
        PreparedStatement ps = null;
        String query = "update setting set language = ?, country = ? where setting = 'language'";
        try {
            con = ConnectDatabase.createConnect();
            ps = con.prepareStatement(query);
            ps.setString(1, locale.getLanguage());
            ps.setString(2, locale.getCountry());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "OK");
        } catch (IOException | ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ConnectLocale.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "System error!");
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConnectAccount.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConnectAccount.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
           
        }
    }
}
