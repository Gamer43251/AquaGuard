/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sections.Fishfall;

import java.awt.Image;
import java.net.URL;
import java.util.Random;
import javax.swing.ImageIcon;

/**
 *
 * @author Jordan Dreelan x23150076
 */
public class Droppable {
    private int x,y; //Used to track the x & y position of the droppable
    protected Random random = new Random(); // used for randomising the droppables x position
    private Image image; // image displayed for the droppable
    
    
    //constructor for droppable
    public Droppable(){
        x = random.nextInt(8) * 75;
        y = -70;
    }
    
    // Method to lower down droppables by 10px at a time
    public void lower() {
        y += 10;  // Move down by 10 pixels
    }

    // returns droppables x Position
    public int getX(){
        return this.x;
    }
    
    // returns droppables Y position
    public int getY(){
        return this.y;
    }
    
    // returns droppables image for being displayed
    public Image getImage(){
        return this.image;
    }
    
    // method to load droppables image used in child classes
    public Image loadImage(String path) {
        URL url = getClass().getClassLoader().getResource(path);
        if (url == null) {
            System.out.println("Image not found: " + path);
            return null;  // Return null or use a default image
        }
        return new ImageIcon(url).getImage();
    }
}
