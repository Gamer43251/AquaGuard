/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aquaguard;

import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author Jordan Dreelan x23150076
 */
public class Fish extends Droppable {
    
    private int x,y;
    private Image image;
    private ArrayList<Image> icons = new ArrayList<Image>();
    
    private Image blueFish = super.loadImage("Images/Fishfall/Game/Fish/Blue Fish.png");
    private Image hammerhead = super.loadImage("Images/Fishfall/Game/Fish/Hammerhead.png");
    private Image seahorse = super.loadImage("Images/Fishfall/Game/Fish/Seahorse.png");
    private Image starfish = super.loadImage("Images/Fishfall/Game/Fish/Starfish.png");
    private Image turtle = super.loadImage("Images/Fishfall/Game/Fish/Turtle.png");
    
    public Fish() {
        x = random.nextInt(8) * 75;
        y = -75;
        icons.add(blueFish);
        icons.add(hammerhead);
        icons.add(seahorse);
        icons.add(starfish);
        icons.add(turtle);
        
        int r = random.nextInt(icons.size());
        this.image = icons.get(r);
    }
    
    public Image getImage(){
        return this.image;
    }
    
    
    
}
