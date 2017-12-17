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
import model.MyUtils.MyDate;


/**
 *
 * @author leo
 */
public class ConnectStatisticsCost {
    public static final int PERDAY = 1;
    public static final int PERMONTH = 2;
    public static final int PERYEAR = 3;
    
    public static ArrayList<CostResult> statisticsR(Date from, Date to, int option) {
        ArrayList<CostResult> results = new ArrayList<>();
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
    private static void statisticsAccordingToMonth(Date from, Date to, ArrayList<CostResult> result) {
        String query = "select name, year(paid_date), month(paid_date), sum(total) "
                    + "from costs_incurred "
                    + "where paid_date >= ? and paid_date <= ? "
                    + "group by month(paid_date), year(paid_date)";
 
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
   
        CostResult r = null;
        try {
            con = ConnectDatabase.createConnect();
            ps = con.prepareStatement(query);
            ps.setString(1, MyDate.formatDate(from));
            ps.setString(2, MyDate.formatDate(to));
            rs = ps.executeQuery();
         
            
            while (rs.next()) {
                r = new CostResult(rs.getString(1), rs.getString(2) + "-" + rs.getString(3), rs.getInt(4));
                result.add(r);
            }
            
            
            
        } catch (IOException | ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ConnectSupplier.class.getName()).log(Level.SEVERE, null, ex);
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
    
    private static void statisticsAccordingToDay(Date from, Date to, ArrayList<CostResult> result) {
        String query = "select name, paid_date, sum(total) "
                    + "from costs_incurred "
                    + "where paid_date >= ? and paid_date <= ? "
                    + "group by paid_date";
        
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
   
        CostResult r = null;
        try {
            con = ConnectDatabase.createConnect();
            ps = con.prepareStatement(query);
            ps.setString(1, MyDate.formatDate(from));
            ps.setString(2, MyDate.formatDate(to));
            rs = ps.executeQuery();
         
            
            while (rs.next()) {
                r = new CostResult(rs.getString(1), rs.getString(2), rs.getInt(3));
                result.add(r);
            }
            
            
            
        } catch (IOException | ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ConnectSupplier.class.getName()).log(Level.SEVERE, null, ex);
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
    
    private static void statisticsAccordingToYear(Date from, Date to, ArrayList<CostResult> result) {
        String query = "select name, year(paid_date), sum(total) "
                    + "from costs_incurred "
                    + "where paid_date >= ? and paid_date <= ? "
                    + "group by year(paid_date)";
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
   
        CostResult r = null;
        try {
            con = ConnectDatabase.createConnect();
            ps = con.prepareStatement(query);
            ps.setString(1, MyDate.formatDate(from));
            ps.setString(2, MyDate.formatDate(to));
            rs = ps.executeQuery();
         
            
            while (rs.next()) {
                r = new CostResult(rs.getString(1), rs.getString(2), rs.getInt(3));
                result.add(r);
            }
            
            
            
        } catch (IOException | ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ConnectSupplier.class.getName()).log(Level.SEVERE, null, ex);
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
