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
    private String customerName;
    private String customerEmail;
    private String customerAddress;

    public Customer() {
        
    }   

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }
    
    public boolean displayCustomerDetails() {
        int option = JOptionPane.showConfirmDialog(null,
            "Customer Name: " + this.customerName + "\n" +
            "Customer Email: " + this.customerEmail + "\n" +
            "Customer Address: " + this.customerAddress,
            "Confirm Customer Details",
            JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

        return option == JOptionPane.YES_OPTION; // Returns true if confirmed, false if cancelled
    }
    
}
