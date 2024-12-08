/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sections.Fishfall;

import Sections.Fishfall.Droppable;
import java.awt.Image;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author Jordan Dreelan x23150076
 */
public class Waste extends Droppable {
    private int x, y;
    private Image image;
    private ArrayList<Image> icons = new ArrayList<Image>();

    //initialise images for waste objects
    private Image crispWrapper = super.loadImage("Images/Fishfall/Game/Waste/Crisp Wrapper.png");
    private Image plasticBag = super.loadImage("Images/Fishfall/Game/Waste/Plastic Bag.png");
    private Image sodaCup = super.loadImage("Images/Fishfall/Game/Waste/Soda Cup.png");
    private Image straw = super.loadImage("Images/Fishfall/Game/Waste/Straw.png");
    private Image waterBottle = super.loadImage("Images/Fishfall/Game/Waste/Water Bottle.png");

    //waste constructor
    public Waste() {
        x = random.nextInt(8) * 75;
        y = -75;
        icons.add(crispWrapper);
        icons.add(plasticBag);
        icons.add(sodaCup);
        icons.add(straw);
        icons.add(waterBottle);

        int r = random.nextInt(icons.size());
        this.image = icons.get(r);
    }

    //method to return waste Image for drawing
    public Image getImage(){
        return this.image;
    }
}

