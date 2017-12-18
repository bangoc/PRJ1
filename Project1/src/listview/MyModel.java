/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listview;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author leo
 */
public class MyModel extends DefaultTableModel {
    public MyModel(String[] columnNames) {
        super(columnNames, 0);
    }

    @Override
    public boolean isCellEditable(int i, int i1) {
        return false;
    }
    
    
}
