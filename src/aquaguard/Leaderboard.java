/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package aquaguard;

import java.util.ArrayList;
import java.util.Comparator;

public class Leaderboard extends javax.swing.JPanel {
    private User[] topPlayers = new User[10];

    public Leaderboard() {
        initComponents();
    }

    public void getTopPlayers() {
        ArrayList<User> users = AquaGuardApp.getUsers();
        
        // Sort the users by high score in descending order
        users.sort(Comparator.comparingInt(User::getHighScore).reversed());
        
        // Copy the top 10 users into the topPlayers array
        for (int i = 0; i < topPlayers.length && i < users.size(); i++) {
            topPlayers[i] = users.get(i);
        }
    }

    public void displayPlayers() {
        getTopPlayers();

        // Display top players in the leaderboard
        leaderboardPlayer1.displayUser(1, topPlayers[0]);
        leaderboardPlayer2.displayUser(2, topPlayers[1]);
        leaderboardPlayer3.displayUser(3, topPlayers[2]);
        leaderboardPlayer4.displayUser(4, topPlayers[3]);
        leaderboardPlayer5.displayUser(5, topPlayers[4]);
        leaderboardPlayer6.displayUser(6, topPlayers[5]);
        leaderboardPlayer7.displayUser(7, topPlayers[6]);
        leaderboardPlayer8.displayUser(8, topPlayers[7]);
        leaderboardPlayer9.displayUser(9, topPlayers[8]);
        leaderboardPlayer10.displayUser(10, topPlayers[9]);
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Layers = new javax.swing.JLayeredPane();
        Border = new javax.swing.JPanel();
        Ranks = new javax.swing.JPanel();
        Title = new javax.swing.JLabel();
        leaderboardPlayer1 = new aquaguard.LeaderboardPlayer();
        leaderboardPlayer2 = new aquaguard.LeaderboardPlayer();
        leaderboardPlayer3 = new aquaguard.LeaderboardPlayer();
        leaderboardPlayer4 = new aquaguard.LeaderboardPlayer();
        leaderboardPlayer5 = new aquaguard.LeaderboardPlayer();
        leaderboardPlayer6 = new aquaguard.LeaderboardPlayer();
        leaderboardPlayer7 = new aquaguard.LeaderboardPlayer();
        leaderboardPlayer8 = new aquaguard.LeaderboardPlayer();
        leaderboardPlayer9 = new aquaguard.LeaderboardPlayer();
        leaderboardPlayer10 = new aquaguard.LeaderboardPlayer();

        setMaximumSize(new java.awt.Dimension(400, 600));
        setMinimumSize(new java.awt.Dimension(400, 600));
        setPreferredSize(new java.awt.Dimension(400, 600));

        Border.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 5));
        Border.setOpaque(false);

        javax.swing.GroupLayout BorderLayout = new javax.swing.GroupLayout(Border);
        Border.setLayout(BorderLayout);
        BorderLayout.setHorizontalGroup(
            BorderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        BorderLayout.setVerticalGroup(
            BorderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        Title.setBackground(new java.awt.Color(0, 255, 255));
        Title.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        Title.setForeground(new java.awt.Color(255, 255, 255));
        Title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Title.setText("Leaderboard");
        Title.setOpaque(true);

        leaderboardPlayer2.invertColor();

        leaderboardPlayer4.invertColor();

        leaderboardPlayer6.invertColor();

        leaderboardPlayer8.invertColor();

        leaderboardPlayer10.invertColor();

        javax.swing.GroupLayout RanksLayout = new javax.swing.GroupLayout(Ranks);
        Ranks.setLayout(RanksLayout);
        RanksLayout.setHorizontalGroup(
            RanksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RanksLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(RanksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(leaderboardPlayer1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(leaderboardPlayer2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(leaderboardPlayer3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(leaderboardPlayer4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(leaderboardPlayer5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(leaderboardPlayer6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(leaderboardPlayer7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(leaderboardPlayer8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(leaderboardPlayer9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(leaderboardPlayer10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        RanksLayout.setVerticalGroup(
            RanksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RanksLayout.createSequentialGroup()
                .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(leaderboardPlayer1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(leaderboardPlayer2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(leaderboardPlayer3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(leaderboardPlayer4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(leaderboardPlayer5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(leaderboardPlayer6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(leaderboardPlayer7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(leaderboardPlayer8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(leaderboardPlayer9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(leaderboardPlayer10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        Layers.setLayer(Border, javax.swing.JLayeredPane.PALETTE_LAYER);
        Layers.setLayer(Ranks, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout LayersLayout = new javax.swing.GroupLayout(Layers);
        Layers.setLayout(LayersLayout);
        LayersLayout.setHorizontalGroup(
            LayersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Ranks, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(LayersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(Border, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        LayersLayout.setVerticalGroup(
            LayersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Ranks, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(LayersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(Border, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Layers, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Layers)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Border;
    private javax.swing.JLayeredPane Layers;
    private javax.swing.JPanel Ranks;
    private javax.swing.JLabel Title;
    private aquaguard.LeaderboardPlayer leaderboardPlayer1;
    private aquaguard.LeaderboardPlayer leaderboardPlayer10;
    private aquaguard.LeaderboardPlayer leaderboardPlayer2;
    private aquaguard.LeaderboardPlayer leaderboardPlayer3;
    private aquaguard.LeaderboardPlayer leaderboardPlayer4;
    private aquaguard.LeaderboardPlayer leaderboardPlayer5;
    private aquaguard.LeaderboardPlayer leaderboardPlayer6;
    private aquaguard.LeaderboardPlayer leaderboardPlayer7;
    private aquaguard.LeaderboardPlayer leaderboardPlayer8;
    private aquaguard.LeaderboardPlayer leaderboardPlayer9;
    // End of variables declaration//GEN-END:variables
}
