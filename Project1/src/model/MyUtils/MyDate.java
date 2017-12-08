/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.MyUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author leo
 */
public class MyDate extends Date {
    public MyDate() {
        super();
    }
    
    @Override
    public String toString() {
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd hh/mm/ss");
        return df.format(this);
    }
}
