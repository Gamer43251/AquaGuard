/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aquaguard;

/**
 *
 * @author Jordan Dreelan x23150076
 */
public class User {
    private String username, password;
    private int xPos,yPos, highScore;
    
    public User(String username, String password){
        this.username = username;
        this.password = password;
        this.xPos = 225;
        this.yPos = 600;
        this.highScore = 0;
    }
    
    public User(String username, String password, int highS){
        this.username = username;
        this.password = password;
        this.xPos = 225;
        this.yPos = 600;
        this.highScore = highS;  
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
    
    public void setX(int x){
        this.xPos = x;
    }
    
    public int getX(){
        return this.xPos;
    }
    
    public void setY(int y){
        this.xPos = y;
    }
    
    public int getY(){
        return this.yPos;
    }
    
    public void resetPos(){
        this.xPos = 225;
        this.yPos = 600;
    }
    
    public String getUsername(){
        return this.username;
    }
    
    public String getPassword(){
        return this.password;
    }
    
    public int getHighScore(){
        return this.highScore;
    }
    
    public void setHighScore(int score){
        this.highScore = score;
    }
}
