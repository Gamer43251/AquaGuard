/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aquaguard;

/**
 *
 * @author Dreel
 */
public class User {
    protected String username, password;
    
    public User(String username, String password){
        this.username = username;
        this.password = password;
    }
    
    public void setUsername(String username){
        this.username = username;
    }
    
    public void setPassword(String pass){
        this.password = pass;
    }
    
    public boolean checkUsername(String username){
        if(this.username.equals(username)){
            return true;
        }
        return false;
    }
    
    public boolean checkPassword(String password){
        if(this.password.equals(password)){
            return true;
        }
        return false;
    }
}
