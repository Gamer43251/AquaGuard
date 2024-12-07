/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sections.Fishfall;

import Sections.Fishfall.Droppable;
import java.awt.Image;

/**
 *
 * @author Jordan Dreelan x23150076
 */
public class Life extends Droppable {
    private int x,y;
    private Image image;
    
    public Life() {
        x = random.nextInt(8) * 75;
        y = -75;
        this.image = super.loadImage("Images/Fishfall/Game/Bubble.png");
    }
    
    public Image getImage(){
        return this.image;
    }
}
