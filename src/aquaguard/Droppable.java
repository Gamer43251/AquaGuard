/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aquaguard;

import java.util.Random;

/**
 *
 * @author Dreel
 */
public class Droppable {
    private int x,y;
    Random random = new Random();
    
    public Droppable(){
        x = random.nextInt(8) * 75;
        y = -75;
    }
    
    public void lower(){
        System.out.println("X: " + x + " Y: " + y);
        y += 75;
    }
    
    public int getX(){
        return this.x;
    }
    
    public int getY(){
        return this.y;
    }
}
