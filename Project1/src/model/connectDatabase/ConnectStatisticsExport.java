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
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.MyUtils.MyDate;
import model.market.Result;


/**
 *
 * @author leo
 */
public class ConnectStatisticsExport {
    public static final int PERDAY = 1;
    public static final int PERMONTH = 2;
    public static final int PERYEAR = 3;
    
    public static ArrayList<Result> statisticsR(Date from, Date to, int option) {
        ArrayList<Result> results = new ArrayList<>();
        switch(option) {
            case(PERDAY) :
                
                statisticsAccordingToDay(from, to, results);
                break;
            case(PERMONTH) :
                statisticsAccordingToMonth(from, to, results);
                break;
            case(PERYEAR) :
                
                statisticsAccordingToYear(from, to, results);
                break;
            default : 
                break;
        }
        return results;
    }
    private static void statisticsAccordingToMonth(Date from, Date to, ArrayList<Result> result) {
        String query = "select year(date), month(date), sum(total) "
                    + "from export_receipt "
                    + "where date >= ? and date <= ? "
                    + "group by month(date), year(date)";
        
        String query1 = "select date, sum(total) "
                    + "from export_receipt "
                    + "where date >= ? and date <= ? "
                    + "group by date";
        
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
   
        Result r = null;
        try {
            con = ConnectDatabase.createConnect();
            ps = con.prepareStatement(query);
            ps.setString(1, MyDate.formatDate(from));
            ps.setString(2, MyDate.formatDate(to));
            rs = ps.executeQuery();
         
            
            while (rs.next()) {
                r = new Result(rs.getString(1) + "-" + rs.getString(2), rs.getInt(3));
                result.add(r);
            }
            
            
            
        } catch (IOException | ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ConnectSupplier.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "System error!");
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConnectSupplier.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConnectSupplier.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConnectSupplier.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    private static void statisticsAccordingToDay(Date from, Date to, ArrayList<Result> result) {
        String query = "select date, sum(total) "
                    + "from export_receipt "
                    + "where date >= ? and date <= ? "
                    + "group by date";
        
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
   
        Result r = null;
        try {
            con = ConnectDatabase.createConnect();
            ps = con.prepareStatement(query);
            ps.setString(1, MyDate.formatDate(from));
            ps.setString(2, MyDate.formatDate(to));
            rs = ps.executeQuery();
         
            
            while (rs.next()) {
                r = new Result(rs.getString(1), rs.getInt(2));
                result.add(r);
            }
            
            
            
        } catch (IOException | ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ConnectSupplier.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "System error!");
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConnectSupplier.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConnectSupplier.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConnectSupplier.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    private static void statisticsAccordingToYear(Date from, Date to, ArrayList<Result> result) {
        String query = "select year(date), sum(total) "
                    + "from export_receipt "
                    + "where date >= ? and date <= ? "
                    + "group by year(date)";
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
   
        Result r = null;
        try {
            con = ConnectDatabase.createConnect();
            ps = con.prepareStatement(query);
            ps.setString(1, MyDate.formatDate(from));
            ps.setString(2, MyDate.formatDate(to));
            rs = ps.executeQuery();
         
            
            while (rs.next()) {
                r = new Result(rs.getString(1), rs.getInt(2));
                result.add(r);
            }
            
            
            
        } catch (IOException | ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ConnectSupplier.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "System error!");
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConnectSupplier.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConnectSupplier.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConnectSupplier.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
