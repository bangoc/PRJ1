/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listview;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author leo
 */
public class MyClock extends Thread {
    JLabel lblClock;
    public MyClock(JLabel lblClock) {
        this.lblClock = lblClock;
    } 
    
    @Override
    public void run() {
        while(true) {
            lblClock.setText(new Date().toString());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(MyClock.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
