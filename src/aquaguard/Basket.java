/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aquaguard;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Joy Cannon
 */
public class Basket extends Stock{
    //Declare Variables
    private List<String> basketItems = new ArrayList<>();
    private double totalPrice;
    private double charityProfit;
    
    //Setters
    public void setBasketItems(List<String> basketItems) {
        this.basketItems = basketItems;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setCharityProfit(double charityProfit) {
        this.charityProfit = charityProfit;
    }
    
    //Getters
    public List<String> getBasketItems() {
        return basketItems;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public double getCharityProfit() {
        return charityProfit;
    }
    
    public void addItem(int index) {//add items to basket method
        String[] itemName = getItemNames();
        double[] itemPrices = getItemPrices();
        int[] itemStock = getItemStock();

        if (index >= 0 && index < itemName.length) {//Check for valid index
            if (itemStock[index] > 0) {//Check stock availability
                basketItems.add(itemName[index]);//Add item to basket
                totalPrice = totalPrice + itemPrices[index];//Add price to total
                itemStock[index]--;//Reduce stock quantity
                System.out.println(itemName[index] + " added to the basket.");
            } else {
                System.out.println(itemName[index] + " is out of stock.");
            }
        }
        updateBasket();//Call method to Update the basket display
    }

    
    public void removeItem(int index) {//Remove items to basket method
        String[] itemName = getItemNames();
        double[] itemPrices = getItemPrices();
        int[] itemStock = getItemStock();

        if (index >= 0 && index < itemName.length) {//Check for valid index
            if (basketItems.contains(itemName[index])) {//Check if item is in basket
                basketItems.remove(itemName[index]);//Remove item from basket
                totalPrice = totalPrice - itemPrices[index];//Subtract price from total
                itemStock[index]++;//Restore stock quantity
                System.out.println(itemName[index] + " removed from the basket.");
            } else {
                System.out.println(itemName[index] + " is not in the basket.");
            }
        } else {
            System.out.println("Invalid item index.");
        }
        updateBasket();//Call method to Update the basket display
    }

    
    public void updateBasket() {
        String basketContents = "";//Start with an empty basket
    
        if (basketItems.isEmpty()) {//If basketItems is empty, display that the basket is empty
            basketContents = "The basket is empty.";
        } else {
            for (String item : basketItems) {//Loop through each item in basketItems
                basketContents += item + "\n";//Add each item followed by a newline
            }
        }

        //Update and Display the basketItems textArea and totalPrice label 
        AquaGuardApp.basketItemsTA.setText(basketContents);
        AquaGuardApp.totalPriceLBL.setText("Total Price: €" + String.format("%.2f", totalPrice));
    }


    public void charityCalc(){//Calculate profit made to charity
        charityProfit = totalPrice * 0.15;//Find a percentage of total price to send to charity
    }
}
