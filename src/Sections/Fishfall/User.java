/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sections.Fishfall;

/**
 *
 * @author Jordan Dreelan x23150076
 */
public class User {
    private String username, password;
    private int xPos,yPos, highScore;
    
    //constructor for User
    public User(String username, String password){
        this.username = username;
        this.password = password;
        this.xPos = 225;
        this.yPos = 600;
        this.highScore = 0;
    }
    
    //constructor for user with a highscore for loading from file
    public User(String username, String password, int highS){
        this.username = username;
        this.password = password;
        this.xPos = 225;
        this.yPos = 600;
        this.highScore = highS;  
    }
    
    //method to set Users username
    public void setUsername(String username){
        this.username = username;
    }
    
    //method to set Users password
    public void setPassword(String pass){
        this.password = pass;
    }
    
    //method to check if Users username matches what is passed
    public boolean checkUsername(String username){
        if(this.username.equals(username)){
            return true;
        }
        return false;
    }
    
    //method to check if Users password matches what is passed
    public boolean checkPassword(String password){
        if(this.password.equals(password)){
            return true;
        }
        return false;
    }
    
    //method to set users X pos
    public void setX(int x){
        this.xPos = x;
    }
    
    //method to get users X pos
    public int getX(){
        return this.xPos;
    }
    
    //method to set Users y Pos
    public void setY(int y){
        this.xPos = y;
    }
    
    //method to get users Y pos
    public int getY(){
        return this.yPos;
    }
    
    //method to reset users Position
    public void resetPos(){
        this.xPos = 225;
        this.yPos = 600;
    }
    
    //method to get users username
    public String getUsername(){
        return this.username;
    }
    
    //method to get users password
    public String getPassword(){
        return this.password;
    }
    
    //method to get users highscore
    public int getHighScore(){
        return this.highScore;
    }
    
    //method to set users High score
    public void setHighScore(int score){
        this.highScore = score;
    }
}
