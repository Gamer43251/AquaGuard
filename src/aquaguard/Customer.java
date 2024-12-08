/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aquaguard;

import javax.swing.JOptionPane;

/**
 *
 * @author Joy Cannon
 */
public class Customer {
    //Declare Variables
    private String customerName;
    private String customerEmail;
    private String customerAddress;   
    
    //Setters
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    //Getter
    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }
    
    public boolean displayCustomerDetails() {//Confirm details method
        int option = JOptionPane.showConfirmDialog(null,
            "Customer Name: " + this.customerName + "\n" + "Customer Email: " + this.customerEmail + "\n" + "Customer Address: " + this.customerAddress, "Confirm Customer Details",
            JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);//Confirm yes or no if current info is correct 

        return option == JOptionPane.YES_OPTION;//Returns true if data confirmed and false if data is uncorrect and cancelled
    }
    
}
    