/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aquaguard;

/**
 *
 * @author Joy Cannon
 */

public class Stock {
    //Declare variables
    private String[] itemNames;
    private double[] itemPrices;
    private int[] itemStock;
    
    //Constructor
    public Stock() {
        itemNames = new String[] {"AquaGuard Tshirt", "AquaGuard Cap", "AquaGuard Bottle", "AquaGuard Bracelet", "AquaGuard Poster", "AquaGuard Plush"};
        itemPrices = new double[] {20.99, 15.99, 18.50, 10.55, 10.20, 25.99};
        itemStock = new int[] {25, 15, 12, 12, 15, 13};
    }
    
    //Getters
    public String[] getItemNames() {
        return itemNames;
    }

    public double[] getItemPrices() {
        return itemPrices;
    }

    public int[] getItemStock() {
        return itemStock;
    }

}