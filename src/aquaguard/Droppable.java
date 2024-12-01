/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aquaguard;

import java.awt.Image;
import java.net.URL;
import java.util.Random;
import javax.swing.ImageIcon;

/**
 *
 * @author Dreel
 */
public class Droppable {
    private int x,y;
    protected Random random = new Random();
    private Image image;
    
    public Droppable(){
        x = random.nextInt(8) * 75;
        y = -70;
    }
    
    public void lower() {
        System.out.println("Droppable at y = " + y + " before lowering");
        y += 10;  // Move down by 75 pixels
        System.out.println("Droppable at y = " + y + " after lowering");
    }

    
    public int getX(){
        return this.x;
    }
    
    public int getY(){
        return this.y;
    }
    
    public Image getImage(){
        return this.image;
    }
    
    // Helper method to load image
    public Image loadImage(String path) {
        URL url = getClass().getClassLoader().getResource(path);
        if (url == null) {
            System.out.println("Image not found: " + path);
            return null;  // Return null or use a default image
        }
        return new ImageIcon(url).getImage();
    }
}
