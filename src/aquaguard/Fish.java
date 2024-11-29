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
 * @author Dreel
 */
public class Fish extends Droppable {
    
    private int x,y;
    private Image image;
    private ArrayList<Image> icons = new ArrayList<Image>();
    
    private Image crispWrapper = new ImageIcon(getClass().getResource("/Images/Fishfall/Game/Waste/Crisp Wrapper.png")).getImage();
    private Image plasticBag = new ImageIcon(getClass().getResource("/Images/Fishfall/Game/Waste/Plastic Bag.png")).getImage();
    private Image sodaCup = new ImageIcon(getClass().getResource("/Images/Fishfall/Game/Waste/Soda Cup.png")).getImage();
    private Image straw = new ImageIcon(getClass().getResource("/Images/Fishfall/Game/Waste/Straw.png")).getImage();
    private Image waterBottle = new ImageIcon(getClass().getResource("/Images/Fishfall/Game/Waste/Water Bottle.png")).getImage();
    
    public Fish() {
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
    
}
