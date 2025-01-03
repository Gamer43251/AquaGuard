/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Sections.Fishfall;

import aquaguard.AquaGuardApp;
import javax.swing.SwingUtilities;

/**
 *
 * @author Jordan Dreelan x23150076
 */
public class FishFallSection extends javax.swing.JPanel {
    private User Curr;
    /**
     * Creates new form FishFallSection
     */
    //constructor for FishFallSection
    public FishFallSection() {
        initComponents();
        
    }
    
    //method to set the player of the FishFallGame within the section
    public void setPlayer(){
        Game.setPlayer();
    }
    
    //method to setFocus to the game so that Keys pressed are tracked for it also sets the games User
    public void setFocus(){
        Game.requestFocus();
        Curr = AquaGuardApp.getCurrentUser();
        displayHighScore();
    }
    
    //method to increase the label
    public void increaseScore(int score){
        if (scoreLabel == null) {
            System.out.println("scoreLabel is null!");
        } else {
            System.out.println("scoreLabel initialized: " + scoreLabel.getText());
        }

        System.out.println(score);
        SwingUtilities.invokeLater(() -> scoreLabel.setText("S"));
        scoreLabel.revalidate();
        scoreLabel.repaint();

    }
    
    //method tp update whats displayed on the ScoreLabel
    public void updateScoreLabel(int score) {
        scoreLabel.setText("Score: " + score);
        scoreLabel.revalidate();
        scoreLabel.repaint();
    }
    
    //method to display HighScore
    public void displayHighScore(){
        highscoreLabel.setText("Highscore: " + Curr.getHighScore());
    }
    
    //method to display Leaderboard
    public void displayLeaderBoard(){
        leaderboard1.displayPlayers();
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Game = new Sections.Fishfall.FishFallGame(this);
        scoreLabelPane = new javax.swing.JLayeredPane();
        scoreLabel = new javax.swing.JLabel();
        scoreBackground = new javax.swing.JLabel();
        highscoreLabelPane = new javax.swing.JLayeredPane();
        highscoreLabel = new javax.swing.JLabel();
        highscoreBackground = new javax.swing.JLabel();
        leaderboard1 = new Sections.Fishfall.Leaderboard();
        instructions = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(1500, 800));
        setMinimumSize(new java.awt.Dimension(1500, 800));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(1500, 800));

        javax.swing.GroupLayout GameLayout = new javax.swing.GroupLayout(Game);
        Game.setLayout(GameLayout);
        GameLayout.setHorizontalGroup(
            GameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 590, Short.MAX_VALUE)
        );
        GameLayout.setVerticalGroup(
            GameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 740, Short.MAX_VALUE)
        );

        scoreLabel.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        scoreLabel.setForeground(new java.awt.Color(255, 255, 255));
        scoreLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        scoreLabel.setText("Score: ");

        scoreBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/score Label.png"))); // NOI18N

        scoreLabelPane.setLayer(scoreLabel, javax.swing.JLayeredPane.PALETTE_LAYER);
        scoreLabelPane.setLayer(scoreBackground, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout scoreLabelPaneLayout = new javax.swing.GroupLayout(scoreLabelPane);
        scoreLabelPane.setLayout(scoreLabelPaneLayout);
        scoreLabelPaneLayout.setHorizontalGroup(
            scoreLabelPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scoreBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(scoreLabelPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(scoreLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE))
        );
        scoreLabelPaneLayout.setVerticalGroup(
            scoreLabelPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scoreBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(scoreLabelPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(scoreLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE))
        );

        highscoreLabel.setFont(new java.awt.Font("Segoe UI", 1, 40)); // NOI18N
        highscoreLabel.setForeground(new java.awt.Color(255, 255, 255));
        highscoreLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        highscoreLabel.setText("Highscore: ");

        highscoreBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/score Label.png"))); // NOI18N

        highscoreLabelPane.setLayer(highscoreLabel, javax.swing.JLayeredPane.PALETTE_LAYER);
        highscoreLabelPane.setLayer(highscoreBackground, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout highscoreLabelPaneLayout = new javax.swing.GroupLayout(highscoreLabelPane);
        highscoreLabelPane.setLayout(highscoreLabelPaneLayout);
        highscoreLabelPaneLayout.setHorizontalGroup(
            highscoreLabelPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(highscoreBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(highscoreLabelPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(highscoreLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE))
        );
        highscoreLabelPaneLayout.setVerticalGroup(
            highscoreLabelPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(highscoreBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(highscoreLabelPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(highscoreLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE))
        );

        instructions.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Fishfall Instructions.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(scoreLabelPane)
                    .addComponent(instructions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(25, 25, 25)
                .addComponent(Game, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(highscoreLabelPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(leaderboard1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(scoreLabelPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(instructions))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(highscoreLabelPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(leaderboard1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Game, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Sections.Fishfall.FishFallGame Game;
    private javax.swing.JLabel highscoreBackground;
    private javax.swing.JLabel highscoreLabel;
    private javax.swing.JLayeredPane highscoreLabelPane;
    private javax.swing.JLabel instructions;
    private Sections.Fishfall.Leaderboard leaderboard1;
    private javax.swing.JLabel scoreBackground;
    private javax.swing.JLabel scoreLabel;
    private javax.swing.JLayeredPane scoreLabelPane;
    // End of variables declaration//GEN-END:variables
}
