/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package aquaguard;

/**
 *
 * @author Jordan Dreelan x23150076
 */
public class AquaGuard {
    private static AquaGuardApp Display = new AquaGuardApp(); // Initialize immediately

    public static void main(String[] args) {
        Display.setVisible(true);
        Display.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
    }

    public static AquaGuardApp getDisplay() {
        return Display;
    }
}

    

