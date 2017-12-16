/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.MyUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author leo
 */
public class MyDate {
    static DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    static DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
 
    
    public static Date parseDateString(String date) throws ParseException {
   
        return df.parse(date);
    }
    
    public static String formatDate(Date date) {
       
      return df.format(date);
    }
    
    public static Date parseDateString1(String date) throws ParseException {
        return df1.parse(date);
    }
}
