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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

/**
 *
 * @author Dreel
 */
public class FishFallGame extends javax.swing.JPanel {
    private FishFallSection parentSection;
    private AquaGuardApp Display = AquaGuard.getDisplay();
    private int screenWidth = 600;
    private int screenHeight = 750;
    private int tileSize = 75;
    private User pl;;
    private char direction;
    private Timer timer;
    private Timer dropTime;
    private int dropSpeed = 50;
    private int score;
    private int state = 0;  // (0 = Not Started) (1 = Playing) (2= Gameover)
    private int lives;
    
    //Initialise Array of Droppable Objects
    private ArrayList<Droppable> drops = new ArrayList<Droppable>();
    
    //Images Created
    private Image basket_image = new ImageIcon(getClass().getResource("/Images/Fishfall/Game/Net.png")).getImage();
    private Image bubble = new ImageIcon(getClass().getResource("/Images/Fishfall/Game/Bubble.png")).getImage();
    private Image bubblePopped = new ImageIcon(getClass().getResource("/Images/Fishfall/Game/BubblePopped.png")).getImage();
    /**
     * Creates new form FishFallGame
     */
    public FishFallGame() {
        this.pl = AquaGuardApp.getCurrentUser();
        initComponents();
        setFocusable(true);
        addKeyListener(new MyKeyAdapter());
    }
    
    public FishFallGame(FishFallSection parent) {
        this.pl = AquaGuardApp.getCurrentUser();
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
        
                //draw droppables
                for (int i = 0; i < drops.size(); i++) {
                    Droppable drop = drops.get(i);
                    g.drawImage(drop.getImage(), drop.getX(), drop.getY(), tileSize, tileSize, null);
                }


                //draw basket
                g.drawImage(basket_image, pl.getX(), pl.getY(), tileSize, tileSize, null);
                
                //Overlay Game with semi-Transparent Aqua color
                g.setColor(new Color(0,100,100, 75));
                g.fillRect(0,0, screenWidth, screenHeight);
                
                //draw Lives
                g.setColor(new Color(255,255,255));
                g.setFont(new Font("Arial MS", 1, 40));
                metrics = getFontMetrics(g.getFont());
                g.drawString("Lives: ", 10 , screenHeight - 15);
                if(lives == 5){
                    g.drawImage(bubble, (metrics.stringWidth("Lives: ") + 10), (screenHeight - 50), 40, 40, null);
                    g.drawImage(bubble, (metrics.stringWidth("Lives: ") + 60), (screenHeight - 50), 40, 40, null);
                    g.drawImage(bubble, (metrics.stringWidth("Lives: ") + 110), (screenHeight - 50), 40, 40, null);
                    g.drawImage(bubble, (metrics.stringWidth("Lives: ") + 160), (screenHeight - 50), 40, 40, null);
                    g.drawImage(bubble, (metrics.stringWidth("Lives: ") + 210), (screenHeight - 50), 40, 40, null);
                }else if(lives == 4){
                    g.drawImage(bubble, (metrics.stringWidth("Lives: ") + 10), (screenHeight - 50), 40, 40, null);
                    g.drawImage(bubble, (metrics.stringWidth("Lives: ") + 60), (screenHeight - 50), 40, 40, null);
                    g.drawImage(bubble, (metrics.stringWidth("Lives: ") + 110), (screenHeight - 50), 40, 40, null);
                    g.drawImage(bubble, (metrics.stringWidth("Lives: ") + 160), (screenHeight - 50), 40, 40, null);
                    g.drawImage(bubblePopped, (metrics.stringWidth("Lives: ") + 210), (screenHeight - 50), 40, 40, null);
                }else if(lives == 3){
                    g.drawImage(bubble, (metrics.stringWidth("Lives: ") + 10), (screenHeight - 50), 40, 40, null);
                    g.drawImage(bubble, (metrics.stringWidth("Lives: ") + 60), (screenHeight - 50), 40, 40, null);
                    g.drawImage(bubble, (metrics.stringWidth("Lives: ") + 110), (screenHeight - 50), 40, 40, null);
                    g.drawImage(bubblePopped, (metrics.stringWidth("Lives: ") + 160), (screenHeight - 50), 40, 40, null);
                    g.drawImage(bubblePopped, (metrics.stringWidth("Lives: ") + 210), (screenHeight - 50), 40, 40, null);
                }else if(lives == 2){
                    g.drawImage(bubble, (metrics.stringWidth("Lives: ") + 10), (screenHeight - 50), 40, 40, null);
                    g.drawImage(bubble, (metrics.stringWidth("Lives: ") + 60), (screenHeight - 50), 40, 40, null);
                    g.drawImage(bubblePopped, (metrics.stringWidth("Lives: ") + 110), (screenHeight - 50), 40, 40, null);
                    g.drawImage(bubblePopped, (metrics.stringWidth("Lives: ") + 160), (screenHeight - 50), 40, 40, null);
                    g.drawImage(bubblePopped, (metrics.stringWidth("Lives: ") + 210), (screenHeight - 50), 40, 40, null);
                }else if(lives == 1){
                    g.drawImage(bubble, (metrics.stringWidth("Lives: ") + 10), (screenHeight - 50), 40, 40, null);
                    g.drawImage(bubblePopped, (metrics.stringWidth("Lives: ") + 60), (screenHeight - 50), 40, 40, null);
                    g.drawImage(bubblePopped, (metrics.stringWidth("Lives: ") + 110), (screenHeight - 50), 40, 40, null);
                    g.drawImage(bubblePopped, (metrics.stringWidth("Lives: ") + 160), (screenHeight - 50), 40, 40, null);
                    g.drawImage(bubblePopped, (metrics.stringWidth("Lives: ") + 210), (screenHeight - 50), 40, 40, null);
                }else if(lives == 1){
                    g.drawImage(bubblePopped, (metrics.stringWidth("Lives: ") + 10), (screenHeight - 50), 40, 40, null);
                    g.drawImage(bubblePopped, (metrics.stringWidth("Lives: ") + 60), (screenHeight - 50), 40, 40, null);
                    g.drawImage(bubblePopped, (metrics.stringWidth("Lives: ") + 110), (screenHeight - 50), 40, 40, null);
                    g.drawImage(bubblePopped, (metrics.stringWidth("Lives: ") + 160), (screenHeight - 50), 40, 40, null);
                    g.drawImage(bubblePopped, (metrics.stringWidth("Lives: ") + 210), (screenHeight - 50), 40, 40, null);
                }
                
                break;
            case 2:
                //draw Background
                g.setColor(new Color(0, 0, 0));
                g.fillRect(0,0,600,750);
                
                //draw Play Again Message
                g.setColor(Color.white);
                g.setFont(new Font("Comic Sans MS", 1, 48));
                metrics = getFontMetrics(g.getFont());
                g.drawString("Game Over", (screenWidth - metrics.stringWidth("Game Over")) / 2 , screenHeight / 2);
                g.setFont(new Font("Comic Sans MS", 1, 24));
                metrics = getFontMetrics(g.getFont());
                g.drawString("Press Space To Play Again", (screenWidth - metrics.stringWidth("Press Space To Play Again")) / 2 , screenHeight / 3);
                
                break;
        }
    }
    
    public void initDroppables(){
        drops.clear();
        Waste dr1 = new Waste();
        drops.add(dr1);
    }
    
    public void sortDroppables(){
        Random rand = new Random();
        int randomInt = rand.nextInt(10);
        Droppable dr;
        if(randomInt <= 6){
            dr = new Waste();
            drops.add(dr);
        }else if(randomInt > 6){
            dr = new Fish();
            drops.add(dr);
        }
        
        
        /*if(score >= 10 && drops.size() < 2){
            Fish dr2 = new Fish();
            drops.add(dr2);
        }else if(score >= 20 && drops.size() < 4){
            Waste dr3 = new Waste();
            drops.add(dr3);
        }*/
    }
    
    public void startGame(){
        score = 0;
        increaseScore(score);
        lives = 5;
        state = 1;
        repaint();
        initDroppables();
        timer = new Timer(dropSpeed, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkState();
                checkCollisions();
                for(int i = 0; i < drops.size(); i++){
                    Droppable drop = drops.get(i);
                    drop.lower();
                }
                repaint();
                System.out.println("Drops: " + drops.size());
                System.out.println("Speed: " + dropSpeed);
                
            }
        });
        timer.start();
        
        dropTime = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sortDroppables();
            }
        });
        dropTime.start();
        
        
    }
                
        
   
   
    
    public void move(){
        if (direction == 'L' && pl.getX() > 0){
            pl.setX(pl.getX() - tileSize);
        }
        else if(direction == 'R' && pl.getX() < (screenWidth - tileSize)){
            pl.setX(pl.getX() + tileSize);
        }
    }
    
    public void checkCollisions() {
        // A separate list to track new items to be added
        ArrayList<Droppable> newDrops = new ArrayList<>();

        // Use iterator to iterate through the droppables
        for (Iterator<Droppable> iterator = drops.iterator(); iterator.hasNext();) {
            Droppable dr = iterator.next();

            // Check collision with player
            if (dr.getX() == pl.getX() && dr.getY() == pl.getY()) {
                if (dr instanceof Waste) {
                    score++;
                    increaseScore(score);
                    System.out.println("Waste Collected");
                } else if (dr instanceof Fish) {
                    lives--;
                    AquaGuardApp.bubblePop();
                }
                // Remove the collided object and queue a new one
                iterator.remove(); // Safe removal
                newDrops.add(dr instanceof Waste ? new Waste() : new Fish());
                continue; // Skip further checks for this object
            }

            // Check if the object is out of bounds
            if (dr.getY() >= screenHeight) {
                if (dr instanceof Waste) {
                    lives--;
                    AquaGuardApp.bubblePop();
                }
                iterator.remove(); // Safe removal
                //newDrops.add(dr instanceof Waste ? new Waste() : new Fish());
            }
        }

        // Add all new items after iteration is complete
        //drops.addAll(newDrops);
    }


    
    public void checkState(){
        if(lives == 0){
            state = 2;
            drops.removeAll(drops);
            repaint();
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
                    if(state == 0){
                        startGame(); // call startGame method
                    }else if(state == 2){
                        startGame();
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
