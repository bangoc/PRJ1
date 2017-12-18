/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.employee;

import java.io.Serializable;

/**
 *
 * @author leo
 */
public class Account implements Serializable {
    
    String username;
    String password;
    
    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public boolean equals(Account account) {
        return account.username.equals(this.username) && account.password.equals(this.password);
    }
    
}
