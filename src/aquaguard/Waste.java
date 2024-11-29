/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aquaguard;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Dreel
 */
public class Waste extends Droppable {

    private int x,y;
    private Image image;
    
    private Image crispWrapper = new ImageIcon(getClass().getResource("/Images/Fishfall/Game/Waste/Crisp Wrapper.png")).getImage();
    public Waste() {
        x = random.nextInt(8) * 75;
        y = -75;
    }
    
    
    
    
}
