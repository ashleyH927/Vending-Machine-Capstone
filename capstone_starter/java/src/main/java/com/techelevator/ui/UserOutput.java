package com.techelevator.ui;

import com.techelevator.models.Cash;
import com.techelevator.models.Inventory;
import com.techelevator.models.InventoryItem;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * Responsibilities: This class should handle formatting and displaying ALL
 * messages to the user
 * <p>
 * Dependencies: None
 */
public class UserOutput {

    public static void displayMessage(String message)  // give any messages when user makes an error
    {
        System.out.println("\n" + message + "\n");
    }

    public static void displayLine(String message)  // give any messages when user makes an error
    {
        System.out.println(message);
    }

    // display vending machine items method
    public static void displayFormattedLine(String message) {
        System.out.printf(message + "\n");
    }

    public static void displayHomeScreen()  // display banner
    {
        System.out.println();
        System.out.println("***************************************************");
        System.out.println("                      Home");
        System.out.println("***************************************************");
        System.out.println();
    }

    public static void displayMainMenu() {
        System.out.println("What would you like to do?\n");

        System.out.println("1) Display Vending Machine Items");
        System.out.println("2) Purchase");
        System.out.println("3) Exit");

        System.out.print("\nPlease select an option: ");
    }

    public static void displayPurchaseMenu() {
        System.out.println("What would you like to do?\n");

        System.out.println("1) Feed Money");
        System.out.println("2) Select Product");
        System.out.println("3) Finish Transaction");

        System.out.println("\nCurrent Money Provided: " + Cash.getCurrentBalance().toString());
        System.out.println();
        System.out.print("Please select an option: ");
    }

    public static void displayItems() {
        System.out.println();
        for (InventoryItem item : Inventory.getInventory()) {
            System.out.printf("%-4s-  %-20s $%-8s Number Available: %-3s\n", item.getSlotID(), item.getItemName(), item.getItemPrice().toString(), (item.qtyCheck()));
            //could be replaced with UserOutput.displayFormattedLine in toString in InventoryItem
        }
    }

    //Not used. Personal method for purchase menu. Comparison not working. 11.21.21
    public static void displayLowerCostItems(BigDecimal availableFunds) {
        System.out.println();
        for (InventoryItem item : Inventory.getInventory()) {
            if (availableFunds.compareTo(item.getItemPrice()) >= 0) {
                System.out.printf("%-4s-  %-20s $%-8s Number Available: %-3s\n", item.getSlotID(), item.getItemName(), item.getItemPrice().toString(), Integer.toString(item.getCurrentStock()));
                //could be replaced with UserOutput.displayFormattedLine in toString in InventoryItem
            }
        }
    }
}
