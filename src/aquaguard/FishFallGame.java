/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package aquaguard;

import aquaguard.AquaGuard;
import aquaguard.User;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

/**
 *
 * @author Dreel
 */
public class FishFallGame extends javax.swing.JPanel {
    FishFallSection parentSection;
    AquaGuardApp Display = AquaGuard.getDisplay();
    private int screenWidth = 600;
    private int screenHeight = 750;
    private int tileSize = 75;
    private User pl;;
    private Droppable dr = new Droppable();
    private char direction;
    private Timer timer;
    private int dropSpeed = 400;
    private int score = 0;
    private int state = 0;  // (0 = Not Started) (1 = Playing) (2= Gameover)
    
    //Images Created
    private Image basket_image = new ImageIcon(getClass().getResource("/Images/Fishfall/Game/Net.png")).getImage();
    /**
     * Creates new form FishFallGame
     */
    public FishFallGame() {
        this.pl = AquaGuardApp.currentUser;
        initComponents();
        setFocusable(true);
        addKeyListener(new MyKeyAdapter());
    }
    
    public FishFallGame(FishFallSection parent) {
        this.pl = AquaGuardApp.currentUser;
        this.parentSection = parent;
        initComponents();
        setFocusable(true);
        addKeyListener(new MyKeyAdapter());
    }
    
    public int getTileSize(){
        return this.tileSize;
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }
    
    public void draw(Graphics g){
        switch (state){
            case 0:
                //draw Background
                g.setColor(new Color(0, 0, 0));
                g.fillRect(0,0,600,750);
                
                //draw Start Message
                g.setColor(Color.white);
                g.setFont(new Font("Comic Sans MS", 1, 48));
                FontMetrics metrics = getFontMetrics(g.getFont());
                g.drawString("Welcome to FishFall", (screenWidth - metrics.stringWidth("Welcome to FishFall")) / 2 , screenHeight / 2);
                g.setFont(new Font("Comic Sans MS", 1, 24));
                metrics = getFontMetrics(g.getFont());
                g.drawString("Press Space to start", (screenWidth - metrics.stringWidth("Press Space To Start")) / 2 , screenHeight / 3);
                break;
            case 1:
                // draw Background
                g.setColor(new Color(0, 74, 173));
                g.fillRect(0,0,600,750);
        
                // draw vertical lines
                for(int i = tileSize; i < screenHeight; i+= tileSize){
                    g.setColor(new Color(255, 255, 255));
                    g.drawRect(0, i, screenWidth, 0);
                }

                //draw horizontal lines
                for(int i = tileSize; i < screenHeight; i+= tileSize){
                    g.setColor(new Color(255, 255, 255));
                    g.drawRect(i, 0, 0, screenHeight);
                }
                //draw droppable
                g.setColor(new Color(255,0,0));
                g.fillRect(dr.getX(),dr.getY(), tileSize, tileSize);
                

                //draw basket
                g.setColor(new Color(255, 0,255));
                g.drawImage(basket_image, pl.getX(), pl.getY(), tileSize, tileSize, null);
                break;
            case 2:
                
                break;
        }
    }
    
    public void startGame(){
        state = 1;
        timer = new Timer(dropSpeed, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Move the droppable object down every second
                checkCollisions();
                dr.lower();
                //System.out.println("Droppable: " + (dr.x * tileSize) +" : " + (dr.y) + " Player: " + pl.x +" : " + pl.y);
                repaint();  // Repaint the panel to reflect the new position
            }
        });
        timer.start();
    }
                
        
   
   
    
    public void move(){
        if (direction == 'L' && pl.getX() > 0){
            pl.setX(pl.getX() - tileSize);
        }
        else if(direction == 'R' && pl.getX() < (screenWidth - tileSize)){
            pl.setX(pl.getX() + tileSize);
        }
    }
    
    public void checkCollisions(){
        if(dr.getX() == pl.getX()  && dr.getY() == pl.getY()){
            score++;
            increaseScore(score);
            dr = new Droppable();
        }
        if(dr.getY() == screenHeight){
            dr = new Droppable();
        }
    }
    
    public void increaseScore(int score) {
        System.out.println("Updating score to: " + score);

        // Use the parent reference to update scoreLabel
        SwingUtilities.invokeLater(() -> {
            if (parentSection != null) {
                parentSection.updateScoreLabel(score);
            } else {
                System.err.println("Parent section is null!");
            }
        });
    }
    
    public class MyKeyAdapter extends KeyAdapter {
    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                direction = 'L'; // set direction to L
                move();
                repaint();
                break;
            case KeyEvent.VK_RIGHT:
                direction = 'R'; // set direction to L 
                move();
                repaint();
                break;
            case KeyEvent.VK_A:
                direction = 'L'; // set direction to L 
                move();
                repaint();
                break;
            case KeyEvent.VK_D:
                direction = 'R'; // set direction to L 
                move();
                repaint();
                break;
            case KeyEvent.VK_SPACE:
                System.out.println("Test");
                if(state == 0){
                    System.out.println("0");
                    startGame(); // call startGame method
                }else if(state == 2){
                    System.out.println("2");
                    //playAgain(); // call playAgain method
                }
                break;
        }
     
    }
    }
    
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(33, 86, 138));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 5));
        setMaximumSize(new java.awt.Dimension(600, 750));
        setMinimumSize(new java.awt.Dimension(600, 750));
        setPreferredSize(new java.awt.Dimension(600, 750));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 590, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 740, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
